/*Set B
c) Define a class MyDate (day, month, year) with methods to accept and display a MyDate object. Accept date as dd, mm, yyyy. Throw user defined exception "InvalidDateException" if the date is invalid.
Examples of invalid dates : 03 15 2019, 31 6 2000, 29 2 2021
*/

import java.util.Scanner;

class InvalidDateException extends Exception {
    String msg = "Invalid date....\nTry Again\n";

    public String toString() {
        return msg;
    }
}

class MyDate {
    int day, mon, yr;

    MyDate(int d, int m, int y) {
        day = d;
        mon = m;
        yr = y;
    }

    void display() {
        System.out.println("\n\t\tDate\n");
        System.out.println("\t----------------------");
        System.out.println("\tDay\tMonth\tYear");
        System.out.println("\t----------------------");
        System.out.println("\t" + day + "\t" + mon + "\t" + yr);
        System.out.println("\t----------------------");
    }
}

public class DateException {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Date  :  dd mm yyyy ");
        int day = sc.nextInt();
        int mon = sc.nextInt();
        int yr = sc.nextInt();

        int flag = 0;
        try {
            if (mon <= 0 || mon > 12)

                throw new InvalidDateException();
            else {
                if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
                    if (day >= 1 && day <= 31)
                        flag = 1;
                    else
                        throw new InvalidDateException();
                } else if (mon == 2) {
                    if (yr % 4 == 0) {
                        if (day >= 1 && day <= 29)
                            flag = 1;
                        else
                            throw new InvalidDateException();
                    } else {
                        if (day >= 1 && day <= 28)
                            flag = 1;
                        else
                            throw new InvalidDateException();
                    }
                } else {
                    if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
                        if (day >= 1 && day <= 30)
                            flag = 1;
                        else
                            throw new InvalidDateException();
                    }
                }
            }
            if (flag == 1) {
                MyDate dt = new MyDate(day, mon, yr);
                dt.display();
            }
        } catch (InvalidDateException e) {
            System.out.println(e);
        }
    }
}

/*O/P:
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> javac DateException.java
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java DateException      
Enter Date  :  dd mm yyyy 
17 9 2000

                Date

        ----------------------
        Day     Month   Year
        17      9       2000
        ----------------------
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java DateException
Enter Date  :  dd mm yyyy
31 06 2021
Invalid date....
Try Again

PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java DateException
Enter Date  :  dd mm yyyy
29 2 2021
Invalid date....
Try Again

PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java DateException
Enter Date  :  dd mm yyyy 
29 2 2020

                Date

        ----------------------
        Day     Month   Year
        ----------------------
        29      2       2020
        ----------------------
*/
