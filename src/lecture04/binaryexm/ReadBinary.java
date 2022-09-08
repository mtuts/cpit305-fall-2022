package lecture04.binaryexm;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinary {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/lecture04/binaryexm/sample.txt");
        DataInputStream dis = new DataInputStream(fis);

        while (true) {
            try {
                int id = dis.readInt();
                byte[] buff = new byte[15];
                dis.read(buff);
                String name = byte2string(buff);
                double gpa = dis.readDouble();

                System.out.printf("%d, %s, %f\n", id, name, gpa);
            } catch (EOFException ignored) {
                break;
            }
        }


        dis.close();
    }

    public static String byte2string(byte[] buff) {
        String str = "";
        for (int i = 0; i < buff.length; i++) {
            if (buff[i] == 0) break;
            str += (char) buff[i];
        }

        return str;
    }
}
