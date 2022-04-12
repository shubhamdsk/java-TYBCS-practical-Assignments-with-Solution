/**
 * @author:Shubham Deshmukh
 * 
 * b) Write a program to create link list of integer objects. Do the following: 
 * i. add element at first position
 * ii. delete last element 
 * iii. display the size of link list
 * */
import java.util.LinkedList;
import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Object> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);

        System.out.println("\nElements in List :\n" + ll);

        ll.addFirst(0);

        System.out.println("\nList after adding Elements at First :\n" + ll);

        ll.removeLast();

        System.out.println("\nList after deleting Last Element :\n" + ll);

        System.out.println("\nSize of the List :\n" + ll.size());

        sc.close();
    }
}
