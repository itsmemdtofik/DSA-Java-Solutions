import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("/home/mohammadtofik/190905514/DataStructureInJava/file1.java");
        System.out.println("Enter some text to write the file : ");
        String str = scanner.nextLine();
        fileWriter.write(str);
        fileWriter.close();
        System.out.println("Successfully written to the file : ");
        scanner.close();
    }
}
