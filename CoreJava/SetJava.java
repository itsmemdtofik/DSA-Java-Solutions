
/**
 *In Java, a Set is a collection that does not allow duplicate elements. 
 It is part of the java.util package and extends the Collection interface. 
 A Set represents a mathematical set, and it is used when you want to ensure 
 that there are no duplicate elements in the collection.
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SetJava {

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        /**
         * HashSet says that I wont accept duplicate and not be addded.
         */
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(4);
        /**
         * The for-each loop is simple and concise.
         * However, you cannot remove elements directly during iteration using a for-each loop.
         */
        System.out.println("Traversing elements using for-each loop: ");
        for (int i : hashSet) {
            System.out.println(i);
        }

        /**
         * Traversing using iterator
         * 
         * It iterates over all elements in the HashSet without exposing the underlying implementation.
         * 
         */
        System.out.println("Traversing using iterator: ");
        Iterator<Integer> iterator = hashSet.iterator();

        while(iterator.hasNext()){
            Integer numbers = iterator.next();
            System.out.println(numbers);
            
            /**
             * removing an element using iterator
             */
            if(iterator.next() == 1){
                iterator.remove();
            }
        }
        System.out.println("Hash Set are: " + hashSet);

    }
}