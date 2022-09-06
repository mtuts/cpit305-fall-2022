import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputDemo {
    public static void main(String[] args) throws IOException  {
        File file = new File("sample.txt");
        
        System.out.printf("filesize in bytes: %d\n", file.length());

        FileInputStream fis = new FileInputStream(file);
        

        // int c = fis.read();
        // System.out.println((char) c);

        // c = fis.read();
        // System.out.println((char) c);

        byte[] buff = new byte[500];

        int num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);

        System.out.println(byte2string(buff, 0));

        num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);

        num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);

        num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);

        num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);

        num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);

        num_of_read_bytes = fis.read(buff);
        System.out.printf("We read: %d\n", num_of_read_bytes);
        System.out.println(byte2string(buff, num_of_read_bytes));

        // System.out.println(fis.available());

        fis.close();

    }

    private static String byte2string(byte[] buff, int len) {
        String str = "";
        for (int i = 0; i < buff.length && i < len; i++) {
            str += (char) buff[i];
        }

        return str;
    }
}