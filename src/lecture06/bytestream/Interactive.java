package lecture06.bytestream;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * new Methods:
 *      nameMatch(), idExist(), deleteEmployee(), searchForEmployeeByID()
 * 
 * - Done TODO: create method nameMatch() to check if stored name equals given name
 * - Done TODO: create method idExist() to check if id exist before add or edit user
 * - Done TODO: listUsersWithGivenName() print All users with the given name
 * - Done TODO: searchForEmployeeByID() Get Employee By ID
 * - Done TODO: deleteEmployee() replce last Employee with deleted Employee 
 * - Done TODO: delete empty bytes at the end of file
 * 
 * Note:
 *     * You can't manage the employee when search by name.
 *
 */

public class Interactive {

    static final int ID_LENGTH = 4;
    static final int SALARY_LENGTH = 8;
    static final int NAME_LENGTH = 15;
    static final int RECORD_SIZE = NAME_LENGTH + ID_LENGTH + SALARY_LENGTH; // id(4), name(15), salary(8)

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile("src/lecture05/bytestream/sample.dat", "rw");
        String option;
        while (true) {
            System.out.println("\n==========================================================\n");
            System.out.println("\nWelcome to our mini-database system\n");
            System.out.println("1. Add new Employee");
            System.out.println("2. Get Employee by record #");
            System.out.println("3. Get Employee by ID #");
            System.out.println("4. List Employees by name");
            System.out.println("5. List all Employees");
            System.out.println("10. Exit");
            System.out.print("Choose from above: ");

            option = keyboard.nextLine();

            if (option.equals("1")) {
                addNewEmployee(keyboard, raf);
            } else if (option.equals("2")) {
                System.out.print("Enter record Number: ");
                option = keyboard.nextLine();
                int record_number = Integer.parseInt(option);
                long pos = (record_number - 1) * RECORD_SIZE;

                if (pos <= raf.length() - RECORD_SIZE) {
                    raf.seek(pos);

                    manageRecord(keyboard, raf);
                } else {
                    System.out.printf("The record (%d) is not exist\n", record_number);
                }
            } else if (option.equals("3")) {

                System.out.print("Enter employee ID to search for it: ");
                int emp_id = Integer.parseInt(keyboard.nextLine());
                int record_num = searchForEmployeeByID(emp_id, raf);
                if (record_num < 1) {
                    System.out.printf("(%s) not in data file!\n", emp_id);
                    continue;
                }
                manageRecord(keyboard, raf);

            } else if (option.equals("4")) { 

                System.out.print("Enter employee name to search for it: ");
                String emp_name = keyboard.nextLine();
                int record_num = listUsersWithGivenName(emp_name, raf);
                if (record_num < 1) {
                    System.out.printf("(%s) not in data file!\n", emp_name);
                    continue;
                }
            } else if (option.equals("5")) {
                raf.seek(0); // let current point to the begining of file
                int num_of_records = (int) (raf.length() / RECORD_SIZE);
                System.out.println();
                System.out.printf("%-10s | %-20s | %-10s\n", "id", "name", "salary");
                System.out.println("---------------------------------------------------------");
                for (int i = 0; i < num_of_records; i++) {
                    displayEmployee(raf);
                }
            } else if (option.equals("10")) {
                System.out.println("\nThank you for using our DB\n");
                break;
            } else {
                System.out.println("Wrong choice!");
            }
        }

        raf.close();
    }

    private static int listUsersWithGivenName(String emp_name, RandomAccessFile raf) throws IOException {
        raf.seek(0);
        int num_of_records = (int) raf.length() / RECORD_SIZE;
        int found = 0;
        long pos;

        for (int i = 0; i < num_of_records; i++) {

            raf.skipBytes(ID_LENGTH);
            String name = readFixedString(raf); // new pos = 4 + 15 = 19
            // if (name.toLowerCase().contains(emp_name.toLowerCase())) {
            if (nameMatch(name, emp_name)) {
                raf.seek(raf.getChannel().position() - ID_LENGTH - NAME_LENGTH);
                if (found == 0) {
                    System.out.printf("\n%-10s | %-20s | %-10s\n", "id", "name", "salary");
                    System.out.println("---------------------------------------------------------");
                }

                pos = raf.getChannel().position();
                displayEmployee(raf);
                raf.seek(pos - SALARY_LENGTH + RECORD_SIZE);
                found++;
            }
            // move to next record
            raf.skipBytes(SALARY_LENGTH); // skip salary of current record and skip id of next one
        }

        return found;
    }

    private static void manageRecord(Scanner keyboard, RandomAccessFile raf) throws IOException {
        System.out.println("\n------------------");
        displayEmployee(raf);
        raf.seek(raf.getChannel().position() - RECORD_SIZE);
        System.out.println("Choose form following:");

        System.out.println("1. Edit");
        System.out.println("2. Delete");

        String option = keyboard.nextLine();

        if (option.equals("1")) {
            editEmployee(keyboard, raf);
        } else if (option.equals("2")) {
            deleteEmployee(raf);
        } else {
            System.out.println("Wrong choice!");
        }
    }

    private static void deleteEmployee(RandomAccessFile raf) throws IOException {
        long pos = raf.getChannel().position();
        raf.seek(raf.length() - RECORD_SIZE);

        int id = raf.readInt();
        String name = readFixedString(raf);
        double salary = raf.readDouble();

        raf.setLength(raf.length() - RECORD_SIZE);

        raf.seek(pos);
        raf.writeInt(id);
        writeFixedString(name, raf);
        raf.writeDouble(salary);
        System.out.println("Employee record has been deleted");
    }

    private static int searchForEmployeeByID(int emp_id, RandomAccessFile raf) throws IOException {

        raf.seek(0);
        int num_of_records = (int) raf.length() / RECORD_SIZE;
        for (int i = 0; i < num_of_records; i++) {

            int id = raf.readInt();

            if (id == emp_id) {
                raf.seek(raf.getChannel().position() - 4);
                System.out.println("We found it, choose from following: ");
                return (int) raf.getChannel().position() / RECORD_SIZE + 1;
            }
            // move to next record
            raf.skipBytes(NAME_LENGTH + SALARY_LENGTH);
        }

        return 0;
    }

    private static void addNewEmployee(Scanner keyboard, RandomAccessFile raf) throws IOException {
        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(keyboard.nextLine());
        if (idExist(raf, id)) {
            System.out.printf("[%d] is already Exist", id);
            return;
        }
        System.out.print("Enter employee Name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter employee Salary: ");
        double salary = Double.parseDouble(keyboard.nextLine());

        raf.seek(raf.length()); // move to the end of file to add new record

        raf.writeInt(id);
        writeFixedString(name, raf);
        raf.writeDouble(salary);

    }

    private static boolean idExist(RandomAccessFile raf, int id) throws IOException {
        raf.seek(0);
        for (int i = 0; i < (raf.length() / RECORD_SIZE); i++) {
            if (raf.readInt() == id)
                return true;
            raf.skipBytes(NAME_LENGTH + SALARY_LENGTH);
        }
        return false;
    }

    private static void writeFixedString(String name, RandomAccessFile raf) throws IOException {
        if (name.length() > NAME_LENGTH) {
            name = name.substring(0, NAME_LENGTH);
        }
        for (int i = 0; i < NAME_LENGTH; i++) {
            byte b = 0;
            if (i < name.length()) {
                b = (byte) name.charAt(i);
            }
            raf.write(b);
        }
    }

    private static void editEmployee(Scanner keyboard, RandomAccessFile raf) throws IOException {
        System.out.println("Which field do you want update:");

        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Salary");

        String option = keyboard.nextLine();

        long pos = raf.getChannel().position();

        if (option.equals("1")) {
            System.out.print("Enter Employee new ID");
            int id = Integer.parseInt(keyboard.nextLine());
            if (idExist(raf, id)) {
                System.out.printf("\n[%d] is already Exist", id);
                return;
            }
            raf.writeInt(id);
        } else if (option.equals("2")) {
            System.out.print("Enter Employee new Name");
            String name = keyboard.nextLine();

            raf.skipBytes(ID_LENGTH);
            writeFixedString(name, raf);
        } else if (option.equals("3")) {
            System.out.print("Enter Employee new Salary");
            double sal = Double.parseDouble(keyboard.nextLine());

            raf.skipBytes(ID_LENGTH + NAME_LENGTH);
            raf.writeDouble(sal);
        } else {
            System.out.println("Wrong choice!");
            return;
        }
        raf.seek(pos);
        System.out.println("Employee info has been updated");
        displayEmployee(raf);
    }

    private static void displayEmployee(RandomAccessFile raf) throws IOException {
        int id = raf.readInt();
        String name = readFixedString(raf);
        double salary = raf.readDouble();
        System.out.printf("%-10d | %-20s | %-10.2f\n", id, name, salary);
    }

    public static String readFixedString(RandomAccessFile raf) throws IOException {
        String str = "";
        byte[] buff = new byte[NAME_LENGTH];

        raf.read(buff);

        for (int i = 0; i < buff.length; i++) {
            if (buff[i] == 0)
                break;
            str += (char) buff[i];
        }

        return str;
    }

    private static boolean nameMatch(String fullName, String givenName) {
        String[] splited = fullName.split(" ");
        for (String s : splited) {
            if (s.equalsIgnoreCase(givenName))
                return true;
        }
        return false;
    }
}
