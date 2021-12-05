/*Set C 
a.Write a package for String operation which has two classes Con and Comp. Con class has to concatenates two strings and comp class compares two strings. Also display proper message on execution.
*/

import java.util.Scanner;
import ConComp.*;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1St String : ");
        java.lang.String s1 = sc.nextLine();

        System.out.println("Enter 2nd String : ");
        java.lang.String s2 = sc.nextLine();

        con1 c = new con1();
        c.displaycon(s1,s2);

        comp1 cm = new comp1();
        cm.displaycomp(s1,s2);

        sc.close();
    }

}