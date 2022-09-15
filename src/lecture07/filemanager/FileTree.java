package lecture07.filemanager;

import java.io.File;

import javax.swing.JFileChooser;

public class FileTree {
    public static void main(String[] args) {
        
        JFileChooser chooser = new JFileChooser(".");

        int c = chooser.showOpenDialog(null);
        if (c == JFileChooser.APPROVE_OPTION) {
            System.out.println("You select Open");
        } else if (c == JFileChooser.CANCEL_OPTION) {
            System.out.println("You select Cancel");
        } else if (c == JFileChooser.ERROR_OPTION) {
            System.out.println("An error occor");
        } else {
            System.out.println("Unexpected return value!");
        }

        File file = chooser.getSelectedFile();

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());

        File parent = file.getParentFile();

        tree(parent);


    }

    private static void tree(File folder) {
        File[] list = folder.listFiles();

        for (File item : list) {
            if (item.isDirectory()) {
                System.out.println(item.getAbsolutePath());
                tree(item);
            } else {
                System.out.println(item.getAbsolutePath());
            }
        }
    }
}
