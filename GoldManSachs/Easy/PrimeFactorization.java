package GoldManSachs.Easy;

import java.lang.Math;

public class PrimeFactorization {

    public static void printPrimeFactor(int num) {
        // Check for the number of 2s that divide num.
        while (num % 2 == 0) {
            System.out.println(2 + " ");
            num = num / 2;
        }

        // Check for odd factor starting from 3.
        for (int i = 3; i <= Math.sqrt(num); i = i + 2) {
            while (num % i == 0) {
                System.out.println(i + ", ");
                num = num / i;
            }
        }

        // If num is a prime number greater than 2.
        if (num > 2) {
            System.out.println(num);
        }
    }

    /**
     * *To check if the number is prime or not.
     * 
     * @param args
     */
    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }

        // Check divisibility from 2 to sqrt(num) for efficiency.
        for (int i = 2; i <= Math.sqrt(num); i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 315;
        printPrimeFactor(n);

        System.out.println("This is prime number: " + isPrime(n));
    }
}
