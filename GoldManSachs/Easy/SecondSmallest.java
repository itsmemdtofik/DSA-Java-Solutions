package GoldManSachs.Easy;

/**
 * * ::Second Smallest::
 * 
 * Q2. Find the second smallest element in an array.
 * Important to take note of the word element
 * For example, [4,8, 9, 2, 1, 1] should return 1, not 2.
 * Also, if array.length is less than 2, just immediately return zero.
 */
public class SecondSmallest {

    public static int findSecondSmallest(int arr[]){

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;


        for(int i = 0; i < arr.length; i++){
            if(arr[i] < firstSmallest){
                firstSmallest = arr[i];
            }
        }
        System.out.println("First smallest : " + firstSmallest);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < secondSmallest && arr[i] > firstSmallest){
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static int anotherSecondSmallestMethod(int arr[]){
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < firstSmallest){
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            }else if(arr[i] < secondSmallest && arr[i] != firstSmallest){
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static int usingMinMaxToFindSecondSmallest(int arr[]){

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            firstMin = Math.min(firstMin, arr[i]);
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > firstMin){
                secondMin = Math.min(secondMin, arr[i]);
            }
        }
        return secondMin;
    }
    public static void main(String[] args) {
        
        int arr[] = {7,1,3,4,2};
        System.out.println("Second Smallest is : " + findSecondSmallest(arr));
        System.out.println("Using another method : " + anotherSecondSmallestMethod(arr));
        System.out.println("Second Min : " + usingMinMaxToFindSecondSmallest(arr));
    }

}
