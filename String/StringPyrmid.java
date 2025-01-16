import java.util.Scanner;

class StringPyrmid {

	public static void pyramidOne(String str){

		str = str.toLowerCase();
		for(int i = 1; i <= str.length(); i++){
			for(int j = 1; j <= i; j++){
				System.out.print(str.charAt(i - 1));
			}
			System.out.println();
		}
	}

	public static void pyramid2(String str){

		str = str.toLowerCase();
		for(int i = 1; i <= str.length(); i++){
			for(int j = str.length(); j >= i; j--){
				System.out.print(str.charAt(j - 1));
			}
			System.out.println();
		}
	}

	public static void pyramid3(String string){

		string = string.toLowerCase();
		for(int i = 1; i <= string.length(); i++){
			for(int j = string.length(); j >= i; j--){
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++){
				System.out.print(string.charAt(i - 1));
			}
			System.out.println();
		}
	}

	public static void pyramid4(String string){

		string = string.toLowerCase();
		for(int i = 1; i <= string.length(); i++){
			for(int j = 1; j <= i; j++){
				System.out.print(" ");
			}
			for(int k = string.length(); k >= i; k--){
				System.out.print(string.charAt(k - 1));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the string : ");
			String string = scanner.nextLine();
			pyramidOne(string);
			System.out.println("---------------------------------------------------------");
			pyramid2(string);
			System.out.println("---------------------------------------------------------");
			pyramid3(string);
			System.out.println("---------------------------------------------------------");
			pyramid4(string);
		}
		System.out.println("---------------------------------------------------------");

	}
	
}