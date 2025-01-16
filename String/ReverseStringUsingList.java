import java.util.*;

class ReverseStringUsingList{
	public static void reverseString(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string : ");
		String str = scanner.nextLine();

		str = str.toLowerCase();
		String string = "";
		List<String> list = new ArrayList<>();


		for(int i = (str.length() - 1); i >= 0; i--){
			string = string + str.charAt(i);
		}
		

		list.add(string);
		System.out.print("After reversing the string the list is : " + list);
		System.out.println();

		/*Reverse the list of string using list*/

		List<String> stringList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango"));

		for(int k = 0, j = (stringList.size() - 1); k < j; k++){
			stringList.add(k, stringList.remove(j));
		}

		System.out.print("After Reversing the list is : " + stringList);
		
		scanner.close();

	}
	public static void main(String args[]){
		reverseString();
	}
}
