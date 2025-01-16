import java.util.*;
public class CharacterDisplay {

    public static void displayCharacter(String str){

        str = str.toLowerCase();
        int count = 0;
        char ch[] = str.toCharArray();

        for(int i = 0; i < str.length(); i++){
            count++;
            System.out.print(ch[i] +", ");
        }

        if(count > 0){
            System.out.println("The number of character is : " + count);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = scanner.nextLine();
        displayCharacter(str);
        scanner.close();

    }
}
