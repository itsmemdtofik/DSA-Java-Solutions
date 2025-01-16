import java.util.*;

class FindCommonIntegerFromArray  {

	public static void findCommonElements(int arr1[], int arr2[], int arr3[], int m, int n, int o){

		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		HashSet<Integer> set3 = new HashSet<Integer>();

		for(int i = 0; i < m; i++){
			set1.add(arr1[i]);
		}

		for(int i = 0; i < n; i++){
			set2.add(arr2[i]);
		}

		/*Check if the elements of the third array is present in the first two array*/

		for(int i = 0; i < o; i++){
			if(set1.contains(arr3[i]) && set2.contains(arr3[i])){
				if(set3.contains(arr3[i]) == true){                        /*To prevent duplicate elements*/
					set3.add(arr3[i]);
				}else{
					System.out.println(arr3[i] + ", ");
				}
			}
		}
	}
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the size of first array : ");
			int m = scanner.nextInt();
			System.out.print("Enter the elements of first array : ");
			int arr1[] = new int[m];
			for(int i = 0; i < m; i++){
				arr1[i] = scanner.nextInt();
			}

			System.out.print("Enter the size of second array : ");
			int n = scanner.nextInt();
			System.out.print("Enter the elements of second array : ");
			int arr2[] = new int[n];
			for(int i = 0; i < n; i++){
				arr2[i] = scanner.nextInt();
			}

			System.out.print("Enter the size of third array : ");
			int o = scanner.nextInt();
			System.out.print("Enter the elements of third array : ");
			int arr3[] = new int[o];
			for(int i = 0; i < o; i++){
				arr3[i] = scanner.nextInt();
			}

			findCommonElements(arr1, arr2, arr3, m, n, o);
		}
	}
	
}