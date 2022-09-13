package lecture05.bytestream;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Interactive {

    static final int NAME_LENGTH = 15;
    static final int RECORD_SIZE = NAME_LENGTH + 4 + 8; // id(4), name(15), salary(8)

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        RandomAccessFile raf = new RandomAccessFile("src/lecture05/bytestream/sample.dat", "rw");
        String option;
        while (true) {
            System.out.println("\n==========================================================\n");
            System.out.println("\nWelcome to our mini-database system\n");
            System.out.println("1. Add new Employee");
            System.out.println("2. Get Employee by record #");
            System.out.println("3. Search for by Empolyee name");
            System.out.println("4. List all Employees");
            System.out.println("10. Exit");
            System.out.print("Choose from above: ");

            option = keyboard.nextLine();

            if (option.equals("1")) {
                addNewEmployee(raf);
            } else if (option.equals("2")) {
                System.out.print("Enter record Number: ");
                option = keyboard.nextLine();
                int record_number = Integer.parseInt(option);
                
                raf.seek((record_number - 1) * RECORD_SIZE);

                System.out.println("Choose form following:");

                System.out.println("1. Display");
                System.out.println("2. Edit");
                System.out.println("3. Delete (Not implemented yet)");
                
                if (option.equals("1")) {
                    displayEmployee(raf);
                } else if (option.equals("2")) {
                    editEmployee(raf);
                } else if (option.equals("3")) {
                    System.out.println("Not implemented yet");
                } else {
                    System.out.println("Wrong choice!");
                }
            }
        }

        raf.close();
    }
}
