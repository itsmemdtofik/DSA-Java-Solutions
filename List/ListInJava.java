/**
 * !List
 * 
 * A List is an interface in Java that extends the Collection interface and
 * provides a way to store elements in a specific order. The elements in a
 * List can be accessed by their index (position), and Lists allow duplicate
 * elements (i.e., two identical elements can be in the same list).
 * 
 * Creating a List: List<Type> list = new ArrayList<>();
 * 
 * Adding Elements: add(E element) or add(int index, E element)
 * Accessing Elements: get(int index)
 * Removing Elements: remove(int index) or remove(Object o)
 * Updating Elements: set(int index, E element)
 * Checking Containment: contains(Object o)
 * Size of List: size()
 * Clear the List: clear()
 * 
 * Iterating Over List: for-each loop or Iterator
 * Sublist: subList(int fromIndex, int toIndex)
 * Check if Empty: isEmpty()
 */
package List;

import java.util.ArrayList;
import java.util.*;

class ArrayListClass {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void ListOperation() {

        List<Integer> list = new ArrayList<>();

        // Adding the element to the list.
        list.add(10);
        list.add(20);
        list.add(30);

        // Print the list
        System.out.println("List is: " + list);

        // Acces an element
        System.out.println("Element at index 1: " + list.get(1));

        // Remove an element from index in list.
        System.out.println("Removing element: " + list.remove(0));

        // Adding 40 to list again.
        list.add(40);

        System.out.println("List is: " + list);

        // remove element from list.
        System.out.println("Remove lement: " + list.remove(Integer.valueOf(40)));

        // Set element in the list.
        list.set(0, 50);

        // Check is list contains an element.
        System.out.println("Contains 50: " + list.contains(50));

        // Get the size of the list
        System.out.println("List size is: " + list.size());

        // Clear the list
        list.clear();

        System.out.println("List after clearing: " + list);

        // check if the list is empty.
        System.out.println("Is the list empty: " + list.isEmpty());

        // Creating new list.
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(200);
        list2.add(50);

        // Creating one more list.
        List<Integer> list3 = new ArrayList<>();

        // adding all the lements of list2 in the list3
        list3.addAll(list2);
        System.out.println("List3 is : " + list3);

        // Checking the list3 if it contains all the element from list2.
        System.out.println("Is list3 contains2 element: " + list3.containsAll(list2));

        // convert list to array
        list3.toArray();
        // list is in array so for that i have use loop to traverse this list.
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("List became array now: " + list3.get(i));
        }

        // Sort the list
        Collections.sort(list3);
        System.out.println("List is in sorted order: " + list3);

        // Remove all element
        list3.removeAll(list2);
        System.out.println("List is: " + list3);

        // We can create a list which contains homogenious and hetrogeneous elements.
        List al = new ArrayList<>();
        
        al.add("Name");
        al.add(1234);
        al.add('c');

        System.out.println("List is : " + al);

        // Traverse the list using for-each loop.
        System.out.println("Element are: ");
        for (Object i : al) {
            System.out.println(i);
        }

        //Iterating the list using iterator.
        Iterator it = al.iterator();
        System.out.println("Itrator are: ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        //Itrating the list using for-loop.
        System.out.println("List is: ");
        for(int i = 0; i < al.size(); i++){
            System.out.println(al.get(i));
        }

    }

}

public class ListInJava {
    public static void main(String[] args) {
        ArrayListClass.ListOperation();
    }

}
