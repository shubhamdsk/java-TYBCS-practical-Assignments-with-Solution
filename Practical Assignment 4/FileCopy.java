import java.io.*;
import java.util.*;

public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name of File 1 : ");
        String f1 = sc.nextLine();

        System.out.println("Enter Name of File 2 : ");
        String f2 = sc.nextLine();

        try {
            FileInputStream fin = new FileInputStream(f1);
            FileOutputStream fout = new FileOutputStream(f2);
            int ch;

            while ((ch = fin.read()) != -1) {
                fout.write(ch);
            }
            String end = "End of File";
            byte b[] = end.getBytes();
            fout.write(b);
            System.out.println("File Content Copied\n");
            fin.close();
            fout.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}

/*
// a.txt file content
Bcs Bca Mca
We are cs Students.
*/

/*O/P

PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> javac FileCopy.java
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java FileCopy
Enter Name of File 1 :
a.txt
Enter Name of File 2 :
simple.txt
File Content Copied
*/

/* 
// simple.txt file content after Execution of program
Bcs Bca Mca
We are cs Students.End of File
*/