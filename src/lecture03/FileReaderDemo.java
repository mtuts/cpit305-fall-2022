import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException  {
        File file = new File("sample.txt");
        
        System.out.printf("filesize in bytes: %d\n", file.length());

        FileInputStream fis = new FileInputStream(file);

        byte[] buff = new byte[500];

        int num_of_read_bytes = 0;

        // way 1
        while (fis.available() > 0) {
            num_of_read_bytes = fis.read(buff);
            System.out.println(byte2string(buff, num_of_read_bytes));
        }


        // way 2

        // while ((num_of_read_bytes = fis.read(buff)) != -1) {
        //     System.out.println(byte2string(buff, num_of_read_bytes));
        // }
        System.out.printf("\nlast iteration read: %d\n", num_of_read_bytes);
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
