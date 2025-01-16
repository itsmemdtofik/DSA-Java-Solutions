/** We used to setBit to make 0 or 1 in the given binary number. */

/** Write a program to set the second bits(position = 1) of a number N(N = 0101) */

/** Idea : bitMask = 1 << position
 *         Operation : OR
 */

 import java.util.*;
public class setBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int number = scanner.nextInt();

        System.out.println("Enter the position : ");
        int position = scanner.nextInt();

        int bitMask = 1 << position;

        int newNumber = bitMask | number;

        System.out.println("After settings the bits the new number is : " + newNumber);


        scanner.close();

    }
    
}
