package lecture02.file_info;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsingBuffer {
    
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("data.txt");

        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] b = "Khalid Ahmed".getBytes();
        bos.write(b);




        // bos.close();

        fos.close();
    }
}
