/**
 * @author:Shubham Deshmukh
 * 
 * a) Write a java program to accept names of ‘n’ cities, insert same into array list collection and display the contents of same array list, also remove all these elements.
 */

import java.util.*;
public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Object> al = new ArrayList<>();

        System.out.println("Enter How many cities :");
        int n = sc.nextInt();

        System.out.println("Enter the Cities :");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String c = sc.nextLine();
            al.add(c);
        }
        System.out.println("Cities :" + al);
        
        System.out.println("ArrayList after removing the elements  :");
        al.clear();
        
        sc.close();
    }
}
