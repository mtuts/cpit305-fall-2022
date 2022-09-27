package lecture09.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {

    public static final String FILENAME = "src/lecture09/serial/students.dat";

    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Student std1 = new Student(456, "Ahmed", 4.8f);

            oos.writeObject(std1);

            std1 = new Student(798, "Khalid", 5.0f);
            oos.writeObject(std1);

            std1 = new Student(132, "Saeed", 3.90f);
            oos.writeObject(std1);

            std1 = new Student(159, "Ali", 4.0f);
            oos.writeObject(std1);


            oos.close();

        } catch (IOException e) {
            System.err.printf("Unable to access (%s)\n", FILENAME);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.err.println("Failed while closing the file!");
                }
            }
        }
    }
}
