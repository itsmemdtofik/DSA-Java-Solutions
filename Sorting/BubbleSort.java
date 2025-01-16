import java.util.Scanner;

class BubbleSortOptimization{

    public int[] _f_OptimizedBubbleSort(int arr[]){

        for(int i = 0; i < (arr.length - 1); i++){

            /**
             * The variable swapped is a boolean flag that tracks whether 
             * any elements were swapped during a pass of the inner loop.
             * If no swaps were made during a pass, it means that the array is already sorted,
             * and there is no need to continue iterating through the list.
             */
            boolean swapped = false;
            for(int j = 0; j < (arr.length - i - 1); j++){
                /**
                 * Note down that here we are using the > symbole to ascending order.
                 * But if you want this in a descending order then you can chnage this > to <.
                 * If you go for selection sort then you will get ulta I mean > symbole for dscending and < for ascending order.
                 */
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }
        return arr;
    }
}


public class BubbleSort {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int i;
            int j;
            int n;
            int count = 0;
            String temp;
            System.out.println("Entet the size of item : ");
            n = scanner.nextInt();
            System.out.println("Enter the number of items : ");
            String names[] = new String[n];
            for (i = 0; i < names.length; i++) {
                names[i] = scanner.next();
            }
            System.out.println("Printing before sorting : ");
            for (i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }
            System.out.println("Enter the name to be search : ");
            String itemString = scanner.next();
            for (i = 0; i < names.length; i++) {
                if (names[i] == itemString) {
                    count++;
                    break;
                }
            }
            if (count > 0) {
                System.out.println("Item is found : " + itemString + "\tAt location : " + i + "\tAnd count is : " + count);
            } else {
                System.out.println("Item is not present in list !");
            }

            for (i = 0; i < (names.length - 1); i++) {
                for (j = 0; j < (names.length - i - 1); j++) {
                    if (names[j].compareTo(names[j + 1]) > 0) {
                        temp = names[j];
                        names[j] = names[j + 1];
                        names[j + 1] = temp;
                    }
                }
            }

            System.out.println("Printing after sorting : ");
            for (i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }
        }

        //Accessing the array
        int newArr[] = {-2,45,0,11,-9};
        BubbleSortOptimization bblSort = new BubbleSortOptimization();

        int sortedArr[] = bblSort._f_OptimizedBubbleSort(newArr);

        System.out.println("Sorted array are: ");
        for(int i : sortedArr){
            System.out.println(i);
        }
       
    }
}
