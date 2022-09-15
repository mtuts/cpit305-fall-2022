package lecture07.filemanager;

import java.io.File;

public class FolderCreator {
    public static void main(String[] args) {
        File folder = new File("src/lecture07/filemanager/myfolder");
        if (folder.exists()) {
            if (folder.isDirectory()) {
                System.out.println("the directory is exists");
            } else {
                System.out.println("there is a file has same name");
            }
            if (folder.delete()) {
                System.out.println("Folder has been deleted");
            } else {
                System.out.println("unable to delete the folder");
            }
        } else {
            System.out.println("Not exists, we will create it");
            if (folder.mkdirs()) {
                System.out.println("Folder has been created");
            } else {
                System.out.println("You don't have rights to create folder here");
            }
        }
    }
}
