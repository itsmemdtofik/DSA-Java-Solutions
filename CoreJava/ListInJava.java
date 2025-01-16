import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayListClass {
    /**
     * A List in Java is a collection that maintains the order of elements,
     * allows duplicates, and provides indexed access to its elements.
     * The List interface is a part of the java.util package and extends the
     * Collection interface.
     * 
     * Types of Lists in Java:
     * There are two main types : 1. ArrayList 2. LinkedList
     * 
     * Operations in ArrayList:
     * 
     * add(E e): Adds the element e to the end of the list.
     * add(int index, E element): Adds the element e at the specified index,
     * shifting subsequent elements to the right.
     * remove(Object o): Removes the first occurrence of the specified element.
     * remove(int index): Removes the element at the specified index.
     * get(int index): Retrieves the element at the specified index.
     * set(int index, E element): Replaces the element at the specified index with
     * the given element.
     * contains(Object o): Checks if the list contains the specified element.
     * indexOf(Object o): Returns the index of the first occurrence of the specified
     * element, or -1 if not found.
     * size(): Returns the number of elements in the list.
     * clear(): Removes all elements from the list.
     */
    public void display() {

        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("mango");
        list.add("cherry");

        System.out.println("Elements are: ");
        for(String i: list){
            System.out.println(i);
        }

        /**
         * Modifying the list
         */
        list.set(1, "book");
        System.out.println("Updated list: ");
        for(String i: list){
            System.out.println(i);
        }

        /**
         * Removing the list
         */
        list.remove(0);
        /**
         * Checking the if the list contains the element.
         */
        if(list.contains("apple")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        /**
         * Getting the index of an element.
         */
        System.out.println("Updated list: " + list);
        System.out.println("Index of 'Cherry': " + list.indexOf("cherry"));

        /**
         * Storing multiple elements at a time.
         */

         List<Integer> InList = Arrays.asList(1,2,4,3,6,8,9,11);
         System.out.println("List are: " + InList);

         /**
          * Using list through loop.
          */
        System.out.println("Listing lements using loop: ");
          for(int i: InList){
            System.out.println(i);
          }
    }
}

public class ListInJava {
    public static void main(String[] args) {
        ArrayListClass ls = new ArrayListClass();
        ls.display();
    }
}
