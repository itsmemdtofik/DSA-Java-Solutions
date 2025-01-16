
import java.io.*;

class FileOperationDemo{
    public static void main(String[] args) {
        try{
            File myFile = new File("/home/mohammadtofik/190905514/DataStructureInJava/file1.java");
            if(myFile.createNewFile()){
                System.out.println("File has been created successfully" + myFile.getName());
            }else{
                System.out.println("File already exist");
            }
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}