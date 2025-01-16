import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsJava {

    public static void ListFunc(){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        System.out.println(list);

        List<String> strList = new ArrayList<>();
        
        strList.add("mohammad");
        strList.add("tofik");
        strList.add("kiran");
        strList.add("Danish");
        strList.add("mohammad");

        System.out.println(strList);
        

    }
    public static void SetFunc(){

        Set<String> set = new HashSet<>();

        set.add("mohammad");
        set.add("tofik");
        set.add("kiran");
        set.add("Danish");
        set.add("mohammad");

        System.out.println(set);

        System.out.println("Check whether an element is there or not: "+set.contains("mohammad"));
    }
    public static void main(String[] args) {
        
        CollectionsJava.ListFunc();
        CollectionsJava.SetFunc();
    }
}
