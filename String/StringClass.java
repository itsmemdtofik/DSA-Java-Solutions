import java.util.*;

public class StringClass {

    public static void removeParticularCharacter(String string){

        string = string.toLowerCase();
        String anotherString = "";
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == 'm'){
                anotherString = string.replace(string.charAt(i), 'c');
            }
        }
        
        System.out.println("The string is " + anotherString);
    }

    public static void ConsonantWovels(String str) {
        str = str.toLowerCase();
        int CountConsonant = 0;
        int CountWovels = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                CountWovels++;
            }

            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                CountConsonant++;
            }
        }

        if (CountConsonant > 0) {
            System.out.println("Consonant are : " + CountConsonant);
        }

        if (CountWovels > 0) {
            System.out.println("Wovels are : " + CountWovels);
        }
    }

    public static void countDigitSpace(String str) {
        str = str.toLowerCase();
        int countSpace = 0;
        int countDigit = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                countSpace++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                countDigit++;
            }
        }

        if (countSpace > 0) {
            System.out.println("Space are : " + countSpace);
        }

        if (countDigit > 0) {
            System.out.println("Digit are : " + countDigit);
        }
    }

    public static int countFrequency(String str, char ch) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void removeWovels(String str){
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u'){
                continue;
            }else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                System.out.print(str.charAt(i));
            }
        }
    }

    public static void removeConsonant(String str){
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u'){
                System.out.print(str.charAt(i));
            }else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                continue;
            }
        }
    }

    public static void frequencyOfEachCharacter(String str) {
         str = str.toLowerCase();
         
         char ch[] = str.toCharArray();
         int freq[] = new int[str.length()];
         
         for(int i = 0; i < str.length(); i++) {
             freq[i] = 1;
             for(int j = i + 1; j < str.length(); j++) {
                 if(ch[i] == ch[j]) {
                     freq[i] = freq[i] + 1;
                     ch[j] ='0'; /*For avoiding the visited character*/
                 }
             }
             
         }
         
         System.out.println("Charcater           :            Frequency");
         for(int i = 0; i < freq.length; i++) {
            if(ch[i] != ' ' && ch[i] != '0') {
                System.out.println(ch[i]+"                                  "+ freq[i]);
            }
         }
    }

    public static void WovelsAndConsonantUsingCharArray(String str){
        str = str.toLowerCase();
        int WovelsCount = 0;
        int ConsonantCount = 0;
        char ch[] = str.toCharArray();
        
        System.out.print("The wovels are : ");
        for(int i = 0; i < str.length(); i++){
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                System.out.print(ch[i] +", ");
                WovelsCount++;
            }
        }

        System.out.println();
        System.out.print("The consonant are : ");
        for(int i = 0; i < str.length(); i++){
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                continue;
            }
            else if(ch[i] >= 'a' || ch[i] <= 'z'){
                System.out.print(ch[i] +", ");
                ConsonantCount++;
            }
        }

        System.out.println();
        if(WovelsCount > 0){
            System.out.println("The total number of wovels in the given string is : " + WovelsCount);
        }

        if(ConsonantCount > 0){
            System.out.println("The total number of consonant in the given string is : " + ConsonantCount);
        }
    }

    private static boolean checkWovel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }else{
            return false;
        }
    }

    public static void WovelsAndConsonantUsingArrayList(String str){
        int wovelsCount = 0;
        int consonantCount = 0;
        str = str.toLowerCase();
        List<Character> wovels = new ArrayList<Character>();
        List<Character> consonant = new ArrayList<Character>();
        char ch[] = str.toCharArray();

        for(int i = 0; i < str.length(); i++){
            if(ch[i] >= 'a' && ch[i] <= 'z'){
                if(checkWovel(ch[i])){
                    wovels.add(ch[i]);
                    wovelsCount++;
                }else{
                    consonant.add(ch[i]);
                    consonantCount++;
                }
            }
        }

        System.out.println("The wovels are : " + wovels +" And count is : " + wovelsCount);
        System.out.println();
        System.out.println("The consonant are : " + consonant + " And count is : " + consonantCount);
        System.out.println();

    }

    public static void reverseStringUsingRecursion(String str){
        if((str.length() == 0) || (str.length() <= 1)){
            System.out.println("The string is : " + str);
        }

        System.out.println(str.charAt(str.length() - 1));
        reverseStringUsingRecursion(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string : ");
        String str = scanner.nextLine();
        WovelsAndConsonantUsingArrayList(str);
        reverseStringUsingRecursion(str);
        scanner.close();
    }
}
