import java.io.*;

class FileOperationCheck{
    public static void main(String[] args) throws IOException {
        File myFile = new File("/home/mohammadtofik/190905514/DataStructureInJava/file1.java");
        if(myFile.exists()){
            System.out.println("Name of the file is : " + myFile.getName());
            System.out.println("The absolute path of the file is : " + myFile.getAbsolutePath());
            System.out.println("Length of the file is : " + myFile.length());
            System.out.println("Can read the file : " + myFile.canRead());
            System.out.println("Can write to the file : " + myFile.canWrite());
            System.out.println(myFile.getPath());
            System.out.println(myFile.getCanonicalPath());
            System.out.println(myFile.getCanonicalFile());
            System.out.println(myFile.getFreeSpace());
            System.out.println(myFile.getParent());
            System.out.println(myFile.getTotalSpace());
            System.out.println(myFile.getUsableSpace());
            System.out.println(myFile.getParentFile());
        }else{
            System.out.println("File does not exists");
        }
    }
}