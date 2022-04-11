/**
 * @author:Shubham Deshmukh
 * 
 * c) Write a program to create a new tree set, add some colors (string) and print out the tree set.
 */
import java.util.*;
public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList ll = new LinkedList();

        System.out.println("Enter How many Friends :");
        int n = sc.nextInt();

        System.out.println("Enter the "+n+" Friends :");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String fl = sc.nextLine();
            ll.add(fl);
        }
        System.out.println("Cities :" + ll);
        sc.close();
    }
}