
/** Write a program to count the number of 1 in a binary representation number. */

import java.util.Scanner;

public class bitDecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int number = scanner.nextInt();

        int bitDecimalToBinary = 0;
        int base = 1;
        int countOne = 0;
        int countZero = 0;
        int totalNumberOfCount = 0;

        while (number != 0) {
            totalNumberOfCount = totalNumberOfCount + 1;
            int rem = number % 2;
            bitDecimalToBinary = bitDecimalToBinary + base * rem;
            number = number / 2;
            base = base * 10;

            if (rem == 1) {
                countOne++;
            }else{
                countZero++;
            }

        }

        System.out.println(bitDecimalToBinary);
        System.out.println("Total number of 1's in a binary representation is : " + countOne +" and total number of 0's is : " + countZero);
        System.out.println("Number of times the while loop has been executed : " + totalNumberOfCount);
        scanner.close();
    }
}
