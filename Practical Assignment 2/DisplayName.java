 /* Set A
 d.Write a java program that take input as a person name in the format of first, middle and last name and then print it in the form last, first and middle name, where in the middle name first character is capital letter. */

import java.util.*;

public class DisplayName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name:");
        String fname = sc.nextLine();

        System.out.println("Enter middle name:");
        String mname = sc.nextLine();

        System.out.println("Enter last name:");
        String lname = sc.nextLine();

        System.out.println("\nFull Name: " + fname + " " + mname + " " + lname + " ");

        String finalname = lname;
        finalname = finalname.concat(" ");
        String ab = mname.substring(0, 1).toUpperCase();

        finalname = finalname.concat(fname);

        String cd = mname.substring(1, mname.length());

        finalname = finalname.concat(" ");
        finalname = finalname.concat(ab);
        finalname = finalname.concat(cd);

        System.out.println("\n--------Updated Name---------\n");
        System.out.println(finalname);
        System.out.println();
        sc.close();
    }
}
