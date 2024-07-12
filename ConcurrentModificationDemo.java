import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("one");
        myList.add("two");
        myList.add("three");

        System.out.println("Initial list: " + myList);
        System.out.println("Starting iterating over the list...");

        try {
            Iterator<String> it = myList.iterator();
            while (it.hasNext()) {
                String value = it.next();
                if (value.equals("one")) {
                    System.out.println("Printing the first value in the list...");
                }
                System.out.println("Value: " + value);
                System.out.println("Trying to add 'four' to the list...");
                myList.add("four");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught!");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
        
        Iterator<String> it2 = myList.iterator();
        System.out.println("Starting iterating over the list again...");
        while (it2.hasNext()) {
            String value = it2.next();
            System.out.println("Value: " + value);
        }

        System.out.println("Iteration completed successfully without any exceptions!");
    }
}
