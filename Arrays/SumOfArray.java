import java.util.*;

public class SumOfArray {

    public static int _f_SumArray(int arr[]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int _f_SumArrayList(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static int _f_SumArrayHash(HashMap<Integer, Integer> hashMap){
        int sum = 0;

        for(int i = 0; i < hashMap.size(); i++){
            sum = sum + hashMap.put(i, hashMap.get(i));
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arr[] = { 2, 3, 4, 1 };
        System.out.println("Sum of array is : " + _f_SumArray(arr));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        
        System.out.println("The sum of array list is : " + _f_SumArrayList(list));

        System.out.println("Enter the element into the hash map: ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < hashMap.size(); i++){
            hashMap.put(i, hashMap.get(scanner.nextInt()));
        }

        System.out.println("The element into the hash map are : ");
        for(int i = 0; i < hashMap.size(); i++){
            System.out.println(hashMap.get(i));
        }
        

    }
}