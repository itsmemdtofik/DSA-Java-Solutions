/** Write a program to update the bits from position 2. and the condition is if that bit 1 make it zero and if that bits is 0 make it one. */

import java.util.Scanner;

class clearAndSet {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number  : ");
		int number = scanner.nextInt();

		System.out.println("Enter the position : ");
		int position = scanner.nextInt();

		System.out.println("Enter the operation to make the changes in the given number : ");
		int operation = scanner.nextInt();
		int bitMask = 1 << position;

		if(operation == 1){
			int newNumber = bitMask | number;
			System.out.println("After changing the bits from 0 to 1 : " + newNumber);
			System.out.println("The binary number of number [ " + newNumber +" ]  is : " + Integer.toBinaryString(newNumber));
		}else{
			
			int newBitMask = ~(bitMask);
			int newNumber = newBitMask & number;
			System.out.println("After changing the bits from 1 to 0 : " + newNumber);
			System.out.println("The binary number of number [ " + newNumber +" ]  is : " + Integer.toBinaryString(newNumber));
		}
	}
	
}

