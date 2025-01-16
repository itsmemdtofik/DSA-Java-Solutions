import java.util.Scanner;

class UserDefinecException {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int sum = 0;

		System.out.print("Enter the size : ");
		int n = scanner.nextInt();

		System.out.print("Enter the elements of an array : ");
		int arr[] = new int[n];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scanner.nextInt();
		}

		for(int i = 0; i < arr.length; i++){
			sum = sum + arr[i];
		}

		try{
			if(sum % 2 == 0){
				throw new ArithmeticException("This is UserDefinecException");
			}
		}catch(ArithmeticException e){
			System.out.print(sum + " " + e.getMessage());
		}

		System.out.println();
	}
	
}