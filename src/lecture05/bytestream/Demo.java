package lecture05.bytestream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("src/lecture05/bytestream/sample.dat", "rw");

        raf.writeInt(123);
        raf.writeLong(468);
        raf.writeUTF("Marwan Alsahafi"); // UTF writes 2 bytes for string length and the reset will be the actual string
        raf.writeFloat(45.89f);

        System.out.println(raf.getChannel().position());

        // move pointer to position of the long value
        raf.seek(4);
        System.out.println(raf.readLong());


        // move pointer to position of the float value
        raf.seek(4+8+2+15);
        System.out.println(raf.readFloat());

        // move pointer to position of the UTF value
        raf.seek(4+8);
        System.out.println(raf.readUTF());

        
        raf.seek(4+8);
        System.out.println(myUTFReader(raf));

        raf.close();
    }

    private static String myUTFReader(RandomAccessFile raf) throws IOException {
        String str = "";
        short str_len = raf.readShort();
        
        for (int i = 0; i < str_len; i++) {
            str += (char) raf.read();
        }

        return str;
    }
}
