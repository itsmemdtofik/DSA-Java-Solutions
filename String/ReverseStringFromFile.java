import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReverseStringFromFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/itsmemdtofik/Downloads/DSA-Java-Solutions/String/file1.java");
        Scanner scanner = new Scanner(file);
        String string = "";
        if (file.exists()) {
            while (scanner.hasNextLine()) {
                string = string + scanner.nextLine();
            }

            System.out.println(string);
        } else {
            System.out.println("File does not exists");
            System.out.println("You need to create a file");
        }

        String revString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            revString = revString + string.charAt(i);
        }
        System.out.println("The reverse string is : " + revString);
        scanner.close();
    }
}
