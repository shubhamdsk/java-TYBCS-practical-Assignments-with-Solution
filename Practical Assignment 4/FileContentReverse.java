
/*Set A
b) Write a program to read a text file "sample.txt" and display the contents of a file in reverse order and also original contents change the case (display in upper case).
*/
import java.io.*;

public class FileContentReverse {

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("a.txt");
            String str = "";
            int ch;
            System.out.println("Original Content of File :\n");

            while ((ch = fin.read()) != -1) {
                System.out.printf("%c", ch);
                str += (char) (ch);
            }
            // reverse File Content
            StringBuffer sbf = new StringBuffer(str);

            System.out.println("\n\nReverse File Content: \n" + sbf.reverse());

            System.out.println("\nOriginal file content in UpperCase: \n" + str.toUpperCase());
            fin.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
/*
// a.txt file content
Bcs Bca Mca
We are cs Students.
*/

/*
O/P
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> javac FileContentReverse.java
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java FileContentReverse      
Original Content of File :

Bcs Bca Mca
We are cs Students.

Reverse File Content:
.stnedutS sc era eW
acM acB scB

Original file content in UpperCase:
BCS BCA MCA
WE ARE CS STUDENTS.
*/