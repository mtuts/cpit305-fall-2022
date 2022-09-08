package lecture04.text;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DataEntry {
    public static void main(String[] args) {
        // id, name, gpa
        Scanner keyboard = new Scanner(System.in);

        String line;
        while (true) {
            System.out.print("Enter student info (id,name,gpa)\n(to exit write [:quit]): ");
            line = keyboard.nextLine();
            if (line.equalsIgnoreCase(":quit")) break;
            
            StringTokenizer tokenizer = new StringTokenizer(line, " ,:\t:");
        
            System.out.println(tokenizer.nextToken());
            System.out.println(tokenizer.nextToken());
            System.out.println(tokenizer.nextToken());

        }

        keyboard.close();
    }
}
