
import java.lang.Math;

class SecondLargestInArray {

	public static int ReturnSecondLargest(int arr[], int n) {

		/* Arrays.sort(arr); */

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < (n - i - 1); j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return arr[n - 2];
	}

	public static void SecondLargestWithoutSorting(int arr[], int n) {
		int second;
		int largest;

		if (n < 2) {
			System.out.println("Invalid input");
			return;
		}
		second = largest = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			largest = Math.max(largest, arr[i]);
		}
		System.out.println("largest is : " + largest);
		for (int i = 0; i < n; i++) {
			if (arr[i] != largest) {
				second = Math.max(second, arr[i]);
			}
		}

		if (second != Integer.MIN_VALUE) {
			System.out.println("The second largest number is : " + second);
		}

	}

	public static void main(String[] args) {

		int n = 5;
		int arr[] = { 11, 6, 10, 10, 11 };

		System.out.println(ReturnSecondLargest(arr, n));

		int n1 = 6;
		int arr1[] = { 3, 5, 1, 8, 9, 8 };
		SecondLargestWithoutSorting(arr1, n1);
	}
}