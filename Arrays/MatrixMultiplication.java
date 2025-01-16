import java.util.Scanner;

class MatrixMultiplication {

	public static void transpose(int m, int n, int first[][], int second[][]){

		int result[][] = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				result[i][j] = 0;
				for(int k = 0; k < m; k++){
					result[i][j] = result[i][j] + first[i][k] * second[k][j];
				}
			}
		}

		System.out.println("The multiplication of matrix is : ");
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(result[i][j]+" \t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the size of row : ");
			int m = scanner.nextInt();
			System.out.print("Enter the size of column : ");
			int n = scanner.nextInt();

			System.out.println("Enter the first matrix : ");
			int first[][] = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					first[i][j] = scanner.nextInt();
				}
			}

			System.out.println("Enter the second matrix : ");
			int second[][] = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					second[i][j] = scanner.nextInt();
				}
			}

			transpose(m, n, first, second);
		}
		
	}
	
}