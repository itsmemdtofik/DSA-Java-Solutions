import java.util.Arrays;

/**
 * There are methods to copy one array to another array
 * 
 * 1. Shallow Copy: A shallow copy means that the destination array will refer
 * to the same elements as the source array.
 * If the elements are objects (like arrays of objects or custom classes),
 * modifying an element in the destination array will affect the source array
 * because they both refer to the same object in memory.
 * 
 * There are methods of shallow copy.
 * 
 * 1. System.arraycopy()
 * 2. clone()
 * 3. Arrays.copyOf()
 * 4. using for loop
 * 
 * 
 */


class ShallowCopy {

	public static void f_shallowCopy(int sourceArray[], int destinationArray[]) {

		System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);

		System.out.println("Using the System.arraycopy() : ");
		for (int i : destinationArray) {
			System.out.println(i + " ");
		}

		System.out.println("Using the clone() methods: ");

		destinationArray = sourceArray.clone();
		for (int i : destinationArray) {
			System.out.println(i + " ");
		}

		System.out.println("Using the Arrays.copyOf() : ");
		destinationArray = Arrays.copyOf(destinationArray, sourceArray.length);
		for (int i : destinationArray) {
			System.out.println(i + " ");
		}

		System.out.println("Using for loop: ");
		for (int i = 0; i < sourceArray.length; i++) {
			destinationArray[i] = sourceArray[i];
		}

		for (int i : destinationArray) {
			System.out.println(i + " ");
		}
	}


}

/**
 * 2. Deep Copy of an Array: A deep copy means that the destination array will
 * have its own independent copies of the elements,
 * even if the elements are objects. In Java, arrays of primitive types (like
 * int[], char[], etc.)
 * do not require a deep copy since they are value types, but if the array
 * contains objects
 * (like an array of arrays or custom objects), you need to copy the objects as
 * well.
 * 
 * There are methods of shallow copy.
 * 
 * 2.1 Deep Copying Arrays of Objects
 * 
 * 
 */

class DeepCopy {
	public static void f_deepCopy(int sourceArray[][], int destinationArray[][]) {

		/**
		 * deep copy: creating a new arrays for each elements.
		 */
		for (int i = 0; i < sourceArray.length; i++) {
			destinationArray[i] = sourceArray[i].clone();
		}

		/**
		 * printing the destination array
		 */
		System.out.println("using deep copy: ");
		for (int[] subArray : destinationArray) {
			for (int num : subArray) {
				System.out.println(num + " ");
			}
			System.out.println();
		}
	}
}

class CopyArrayToAnotherArray {

	public static void main(String[] args) {

		int sourceArray[] = { 1, 3, 3, 4, 5 };
		int destinationArray[] = new int[sourceArray.length];
		ShallowCopy.f_shallowCopy(sourceArray, destinationArray);

		int source[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int destination[][] = new int[source.length][];
		DeepCopy.f_deepCopy(source, destination);

	}
}