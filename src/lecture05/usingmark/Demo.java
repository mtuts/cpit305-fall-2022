package lecture05.usingmark;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        File file = new File("src/lecture05/usingmark/data.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        if (fis.markSupported()) {
            System.out.println("FileInputStream support mark");
        } else {
            System.out.println("FileInputStream does not support mark");
        }

        
        if (bis.markSupported()) {
            System.out.println("BufferedInputStream support mark");
        } else {
            System.out.println("BufferedInputStream does not support mark");
        }
        
        bis.mark(10);

        byte[] buff = new byte[300];

        for (int i = 0; i < 10; i++) {
            bis.read(buff);
            System.out.printf("%d: %s\n", i, byte2string(buff, 10));
             
        }

        bis.reset();

        System.out.println("\n------------------------------------\n");

        bis.read(buff);
        System.out.println( byte2string(buff, 10));


        fis.close();
    }

    private static String byte2string(byte[] buff) {
        return byte2string(buff, buff.length);
    }

    private static String byte2string(byte[] buff, int len) {
        String str = "";
        for (int i = 0; i < buff.length && i < len; i++) {
            str += (char) buff[i];
        }

        return str;
    }
}
