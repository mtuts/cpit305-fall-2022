package lecture07.filemanager;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    public static void main(String[] args) {
        File file = new File("src/lecture07/filemanager/sample.txt");

        if (file.exists()) {
            System.out.println("File already exist");
            System.out.println("I will remove it");
            if (file.delete()) {
                System.out.println("we have delete the file");
            }
        } else {
            System.out.println("File not exist i will try to create it!");
            try {
                if ( file.createNewFile()) {
                    System.out.println("file has been created");
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
