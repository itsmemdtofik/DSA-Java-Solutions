
/** We used updateBit to update the bit on any position in a given binary number. */

/**
 * Idea : 
 * To make 0 we use this operation and this is nothing but clear operation and we have studied already. For 0
 * bitMask : 1 << position
 * Operation : AND with NOT
 */

/**
 * To make 1 we use this operation and this is nothing but set operation and we have already studied : For 1
 *bitMask : 1 << position
 *Operation : OR
 */

/** Write a program to update the second bit(position = 1) of a number to 1(n = 0101) */

/** We used */
import java.util.Scanner;;

public class updateBit {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number : ");
    int number = scanner.nextInt();

    System.out.println("Enter the position : ");
    int position = scanner.nextInt();

    /** If we have to make the bits from 0 to 1 then use set operation */
    System.out.println("Before changing the bits from 0 to 1 the decimal value is : " + number);

    int bitMask = 1 << position;
    int newNumber = bitMask | number;

    System.out.println("After changing the bits from  0 to 1 the decimal value is : " + newNumber);

    System.out.println("--------------Now changing the bits from 1 to 0---------------");

    System.out.println("Enter the number : ");
    int secondNumber = scanner.nextInt();

    System.out.println("Enter the position : ");
    int secondPosition = scanner.nextInt();

    int secondBitMask = 1 << secondPosition;

    int newBitMask = ~(secondBitMask);

    int secondNewNumber = newBitMask & secondNumber;

    System.out.println("Before changing the bits from 1 to 0 the decimal value is : " + secondNumber);
    
    System.out.println("After changing the bits from 0 to 1 the decinmal value is : " + secondNewNumber);
    scanner.close();
  }

}
