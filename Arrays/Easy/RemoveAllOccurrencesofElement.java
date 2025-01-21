/**
 * * Remove all occurences of an element in an array.
 * 
 * Given an integer array arr[] and an integer ele the task is to the remove all
 * occurrences of ele from arr[] in-place and return the number of elements
 * which are not equal to ele. If there are k number of elements which are not
 * equal to ele then the input array arr[] should be modified such that the
 * first k elements should contain the elements which are not equal to ele and
 * then the remaining elements.
 * 
 * Note: The order of first k elements may be changed.
 * 
 * Examples:
 * 
 * Input: arr[] = [3, 2, 2, 3], ele = 3
 * Output: 2
 * Explanation: The answer is 2 because there are 2 elements which are not equal
 * to 3 and arr[] will be modified such that the first 2 elements contain the
 * elements which are not equal to 3 and remaining elements can contain any
 * element. So, modified arr[] = [2, 2, _, _]
 * 
 * Input: arr[] = [0, 1, 3, 0, 2, 2, 4, 2], ele = 2
 * Output: 5
 * Explanation: The answer is 5 because there are 5 elements which are not equal
 * to 2 and arr[] will be modified such that the first 5 elements contain the
 * elements which are not equal to 2 and remaining elements can contain any
 * element. So, modified arr[] = [0, 1, 3, 0, 4, _, _, _]
 * 
 */
package Easy;
public class RemoveAllOccurrencesofElement {

    public static int removeAllOccurenceOfElement(int arr[], int element) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                arr[count++] = arr[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int arr1[] = { 3, 2, 2, 3 };
        int element = 2;

        int arr2[] = { 0, 1, 3, 0, 2, 2, 4, 2 };
        int element2 = 2;
        System.out.print("The answer is: ");
        System.out.println(removeAllOccurenceOfElement(arr1, element));
        System.out.println(removeAllOccurenceOfElement(arr2, element2));
    }
}
