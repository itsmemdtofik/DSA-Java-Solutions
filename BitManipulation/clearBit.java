/** We used clearBit to make the bit zero in the given binary number. */

/** Write a program to clear the third bit(position = 2) of a number n(n == 0101) */

/** Idea : bitMask == 1 << position
 *         Operation : AND with NOT
 */

 import java.util.*;
public class clearBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int number = scanner.nextInt();

        System.out.println("Enter the position : ");
        int position = scanner.nextInt();

        int bitMask = 1 << position;

        int newBitMask = ~(bitMask);

        int newNumber = newBitMask & number;

        System.out.println("After clearing the bit the bits are : " + newNumber);


        scanner.close();
    }
    
}
