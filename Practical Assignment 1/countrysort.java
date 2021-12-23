/*
Set C
a) Write a program to accept n names of country and display them in descending order.
*/
import java.util.*;

public class countrysort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total no of Countries: ");
        int n = sc.nextInt();
        String country[] = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter country no :" + (i + 1));
            country[i] = sc.nextLine();
        }
        System.out.println("Country names without Sorting:");
        for (String ele : country) {
            System.out.println("" + ele);
        }
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (country[i].compareTo(country[j]) < 0) {
                    temp = country[i];
                    country[i] = country[j];
                    country[j] = temp;
                }
            }
        }
        System.out.println("Countries in Descending order:");
        for (String ele : country) {
            System.out.println("" + ele);
        }
        sc.close();
    }
}
