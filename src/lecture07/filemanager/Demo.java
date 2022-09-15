package lecture07.filemanager;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        File file = new File(".");

        System.out.printf("is file exists: %b\n", file.exists());
        System.out.printf("is it a directory: %b\n", file.isDirectory());
        System.out.printf("located at: %s\n", file.getAbsolutePath());
    }
}
