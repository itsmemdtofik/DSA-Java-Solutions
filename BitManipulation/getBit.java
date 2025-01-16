/** We used getBit to know the position of the any bits in a given binary number */

/**Program 1 : write a program to get the third bit(position = 2) of a number(n = 0101) */

/** Idea : bitMask : 1 << i
 *         Operation : AND
 * Note : In this manner we give the position from right side
 */

public class getBit {
    public static void main(String[] args) {
       
        int number = 5;
        int position = 3;

        int bitMask = 1 << position;

        System.out.println(bitMask);

        if((bitMask & number) == 0){
            System.out.println("The bits was zero");
        }else{
            System.out.println("The bits was one");
        }

    }
}
