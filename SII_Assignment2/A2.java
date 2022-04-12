/**
 * @author:Shubham Deshmukh
 * 
 * b) Write a java program to read ‘n’ names of your friends, store it into linked list, also display contents of the same.
 */
import java.util.*;
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Object> ll = new LinkedList<>();

        System.out.println("Enter How many Friends :");
        int n = sc.nextInt();

        System.out.println("Enter the "+n+" Friends :");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String fl = sc.nextLine();
            ll.add(fl);
        }
        System.out.println("Friends :" + ll);
        sc.close();
    }
}
