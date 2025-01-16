import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

class MergeSort {

	public static void _f_Conquer(int arr[], int low, int mid, int high) {

		int mergedArr[] = new int[high - low + 1];

		/**
		 * Now we will start inserting element into the mergedArr[]
		 */

		/**
		 * Now we will create two index index1 and index2
		 * The index1 will start from starting index and index1 will track the first
		 * array.
		 * The index2 will start from (mid + 1) index and index2 will track the second
		 * array.
		 * 
		 */

		int index1 = low;
		int index2 = mid + 1;

		/**
		 * Now who is tracking the third array which is merged array.
		 * To track the merged array we will create the mergedIndex for the merged array
		 * as well.
		 * The mergedIndex will start from zero.
		 */

		int mergedIndex = 0;

		/**
		 * This is for first sub-array = [3, 6, 9] and second sub-array = [2, 5, 8]
		 */
		while (index1 <= mid && index2 <= high) {
			if (arr[index1] <= arr[index2]) {
				mergedArr[mergedIndex] = arr[index1];
				mergedIndex++;
				index1++;
			} else {
				mergedArr[mergedIndex] = arr[index2];
				mergedIndex++;
				index2++;
			}
		}

		/**
		 * The above while loop will work until we comparing in both array.
		 * Suppose if the first array get finished and if there is some elements
		 * remaining in the second array.
		 * Suppose if the second array get finished and if there is some elements
		 * remaining in the first array.
		 * Then we will write two more while loop to cover this.
		 * 
		 */

		while (index1 <= mid) {
			/**
			 * This is for first sub-array = [3, 6, 9]
			 */
			mergedArr[mergedIndex++] = arr[index1++];
		}

		while (index2 <= high) {
			/**
			 * This is for second sub-array = [2, 5, 8]
			 */
			mergedArr[mergedIndex++] = arr[index2++];
		}

		/**
		 * Now what we have to do?
		 * Now we have to copy the elements of merged array into the original array.
		 * So for that we will iterate using for loop.
		 * 
		 */

		for (int i = 0, j = low; i < mergedArr.length; i++, j++) {
			arr[j] = mergedArr[i];
		}

	}

	/**
	 * Our Original array is = [6,3,9,5,2,8]
	 * If we divide this array via applying mid then we get two sub array.
	 * The first array contains = [6, 3, 9] -> low to mid
	 * And second array contains = [5, 2, 8] -> mid + 1 to high.
	 * And while conquering then these two array gets sorted individually.
	 * First array become = [3, 6, 9] -> index1 to track this sub array
	 * Second array becomde = [2, 5, 8] -> index2 to track this second sub array.
	 * Now we merged these two array into new array called mergedArr.
	 * To track merged array we create mergedIndex.
	 * 
	 */
	public static int[] _f_DivideArr(int arr[], int low, int high) {

		/**
		 * To calculate mid = low + (high - low) / 2 Because of space complexity we are
		 * removing this
		 */
		int mid = low + (high - low) / 2;
		if (low >= high) {// if our starting index gets bigger than ending index
			return arr;
		} else {

			_f_DivideArr(arr, low, mid);
			_f_DivideArr(arr, mid + 1, high);
			_f_Conquer(arr, low, mid, high);
		}
		return arr;
	}

	public static void main(String[] args) {
		runTestCases();
	}

	public static void runTestCases() {
		List<int[]> testCases = new ArrayList<>();

		// Adding complex test cases
		testCases.add(new int[] {}); // Empty array
		testCases.add(new int[] { 1 }); // Single element
		testCases.add(new int[] { 2, 1 }); // Two elements unsorted
		testCases.add(new int[] { 1, 2 }); // Two elements sorted
		testCases.add(new int[] { 10, 16, 8, 12, 15, 6, 3, 9, 5, 100 }); // Random unsorted array
		testCases.add(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }); // Already sorted array
		testCases.add(new int[] { 8, 7, 6, 5, 4, 3, 2, 1 }); // Reverse sorted array
		testCases.add(new int[] { 4, 2, 2, 8, 3, 3, 1 }); // Array with duplicates

		// Generating additional complex test cases dynamically
		for (int i = 0; i < 92; i++) {
			int size = (int) (Math.random() * 100) + 10; // Random size between 10 and 100
			int[] randomArray = new int[size];
			for (int j = 0; j < size; j++) {
				randomArray[j] = (int) (Math.random() * 1000) - 500; // Random numbers between -500 and 499
			}
			testCases.add(randomArray);
		}

		// Running all test cases
		int testCaseNumber = 1;
		for (int[] testCase : testCases) {
			System.out.println("Test Case " + testCaseNumber + ":");
			System.out.println("Input: " + Arrays.toString(testCase));
			int[] sorted = MergeSort._f_DivideArr(testCase.clone(), 0, testCase.length - 1);
			System.out.println("Output: " + Arrays.toString(sorted));

			// Validate if the output is sorted
			if (isSorted(sorted)) {
				System.out.println("Result: Pass\n");
			} else {
				System.out.println("Result: Fail\n");
			}

			testCaseNumber++;
		}
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}
}