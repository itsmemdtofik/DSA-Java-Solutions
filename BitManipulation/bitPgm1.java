/** Write a program to check is the given number is power of 2 or not. */

import java.util.*;
public class bitPgm1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int number = scanner.nextInt();

        int decrementByOne = number - 1;

        if((decrementByOne & number) == 0){
            System.out.println("The number is power of 2 ");
        }else{
            System.out.println("The number is not power of 2");
        }

        scanner.close();
    }
    
}
