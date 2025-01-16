package GoldManSachs.Easy;

public class DotProduct {
	public static int dotProduct(int arr1[], int arr2[]){

        int dotProduct = 0;

		if(arr1.length != arr2.length){
			System.out.println("Array must be the same length: ");
            return 0;
		}else{
            for(int i = 0; i < arr1.length; i++){
                dotProduct += arr1[i] * arr2[i];
            }
        }
        return dotProduct;
	}
    public static void main(String[] args) {
    	
        System.out.println("The dot product of this array {1,2,3} and {4,5,6} is : " + dotProduct(new int[]{1,2,3}, new int[]{4,5,6}));
    }
}
