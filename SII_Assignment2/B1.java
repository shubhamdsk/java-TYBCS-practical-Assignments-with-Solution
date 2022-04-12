
/**
 * @author:Shubham Deshmukh
 * 
 * a) Accept 'n' integers from the user. Store and display integers in sorted order having proper collection class. 
 * 4
 * The collection should not accept duplicate elements. 
* */
import java.util.TreeSet; 
import java.util.Scanner;
public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Object> ts = new TreeSet<>();

        System.out.println("Enter how many Numbers: ");
        int n = sc.nextInt();

        System.out.println("Enter the " + n + " Numbers: ");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ts.add(num);
        }
        System.out.println("Numbers in Sorted Order and without Duplication :" + ts);
        sc.close();
    }
}