import java.util.Scanner;

class ReplacingStringWithNewString {
	public static void replacingString(String str, String newString){
		str = str.toLowerCase();
		String newSecondString = "";
		for(int i = 0; i < str.length(); i++){
			newSecondString = newSecondString + str.replace(str.charAt(i), newString.charAt(i));
		}

		System.out.println("After reforming the new String is : " + newSecondString);
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the string  : ");
		String string = scanner.nextLine();
		System.out.print("Enter the string by which you wanna replace old string : ");
		String newString = scanner.nextLine();
		replacingString(string, newString);

	}
	
}