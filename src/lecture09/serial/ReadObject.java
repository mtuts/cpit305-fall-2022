package lecture09.serial;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(WriteObject.FILENAME)) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Student std1 = (Student)ois.readObject();
                    System.out.println(std1);
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Data on file are not as expected!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Unable to read file");
        }
    }
}
