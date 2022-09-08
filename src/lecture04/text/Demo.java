package lecture04.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        File file = new File("src/lecture04/text/sample.txt");
        FileOutputStream fos = new FileOutputStream(file); // , true);
        PrintWriter writer = new PrintWriter(fos);


        Scanner keyboard = new Scanner(System.in);

        String line;
        while (true) {
            System.out.print("Enter your text (to exit write [:quit]): ");
            line = keyboard.nextLine();

            if (line.equalsIgnoreCase(":quit")) break;

            writer.println(line);

        }


        writer.close();
    }
}
