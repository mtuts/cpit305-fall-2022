package lecture02.file_info;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        File file = new File("ahmed.txt");
        
        FileOutputStream fos = new FileOutputStream(file, true);


        // fos.write(65);
        String name = "Khalid Ahmed";

        byte[] b = name.getBytes();
        fos.write(b);
        // fos.write(b, 4, 4);



        fos.close();
    }
}
