package lecture04.binaryexm;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/lecture04/binaryexm/sample.txt");
        DataOutputStream dos = new DataOutputStream(fos);


        dos.writeInt(125);
        // write fixed string with len 15 

        byte[] fixed_name = new byte[15];
        String name = "Ahmed";
        
        writeFixedString(name, fixed_name, 15);

        dos.write(fixed_name);
        dos.writeDouble(4.5);


        // Khalid
        dos.writeInt(456);
        name = "Khalid Ahmed Ali";
        writeFixedString(name, fixed_name, 15);
        dos.write(fixed_name);
        dos.writeDouble(4.8);

        // Saeed
        dos.writeInt(798);
        name = "Saeed";
        writeFixedString(name, fixed_name, 15);
        dos.write(fixed_name);
        dos.writeDouble(4.3);

        // Fahad
        dos.writeInt(132);
        name = "Fahad";
        writeFixedString(name, fixed_name, 15);
        dos.write(fixed_name);
        dos.writeDouble(2.8);

        dos.close();
    }

    private static void writeFixedString(String str, byte[] buff, int length) {
        for (int i = 0; i < length; i++) {
            if (str.length() <= i) {
                buff[i] = 0;
            } else {
                buff[i] = (byte)str.charAt(i);
            }
        }
    }
}
