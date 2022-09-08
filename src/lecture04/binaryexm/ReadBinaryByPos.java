package lecture04.binaryexm;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadBinaryByPos {
    public static void main(String[] args) throws IOException {
        File file = new File("src/lecture04/binaryexm/sample.txt");
        
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);

        Scanner keyboard = new Scanner(System.in);

        int num_of_records = (int)file.length() / 27; // 27 = id(4) + name(15) + gpa(8)
        System.out.printf("Enter student record number (0 - %d): ", num_of_records - 1);

        int r = Integer.parseInt(keyboard.nextLine());


        if (r < num_of_records) {
            dis.skip(r * 27);

            try {
                int id = dis.readInt();
                byte[] buff = new byte[15];
                dis.read(buff);
                String name = ReadBinary.byte2string(buff);
                double gpa = dis.readDouble();

                System.out.printf("%d, %s, %f\n", id, name, gpa);
            } catch (EOFException ignored) {
                System.out.println("Not found");
            }
        }


        dis.close();
    }
}
