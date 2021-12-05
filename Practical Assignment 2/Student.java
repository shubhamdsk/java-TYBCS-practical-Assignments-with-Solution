/*Set B
a) Write a Java program to create a Package “SY” which has a class SYMarks (members – ComputerTotal, MathsTotal, and ElectronicsTotal). Create another package TY which has a class TYMarks (members – Theory, Practicals). Create n objects of Student class (having rollNumber, name, SYMarks and TYMarks). Add the marks of SY and TY computer subjects and calculate the Grade (‘A’ for >= 70, ‘B’ for >= 60 ‘C’ for >= 50 ,
*/

import java.util.Scanner;

import SY.SYMarks;
import TY.TYMarks;

public class Student {
    int rollno;
    String studentname, grade;
    SYMarks sym;
    TYMarks tym;

    Student(int r, String name, SYMarks s, TYMarks t) {
        rollno = r;
        studentname = name;
        sym = s;
        tym = t;

    }

    public String toString() {
        return rollno + "\t" + studentname + "\t" + sym + "\t\t" + tym + "\t";
    }

    void calculategrade() {
        int total = sym.ComputerTotal + tym.Theory + tym.Practicals;
        double per = total / 14;
        if (per >= 70) {
            System.out.println("\tA");
        } else if (per >= 60) {
            System.out.println("\tB");
        } else if (per >= 50) {
            System.out.println("\tC");
        } else if (per >= 40) {
            System.out.println("\tPass");
        } else {
            System.out.println("\tFAIL.!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How Many Students:");
        int n = sc.nextInt();
        Student[] stud = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " student data");

            System.out.println("Enter Roll no:");
            int roll_no = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student Name:");
            String name = sc.nextLine();

            System.out.println("Enter SY Percentage(Comp total,Math total,Elect total):");

            int ct = sc.nextInt();
            int mt = sc.nextInt();
            int et = sc.nextInt();

            SYMarks sym = new SYMarks(ct, mt, et);

            System.out.println("Enter TY Marks (Theory  and Practicals)");
            int th = sc.nextInt();
            int pr = sc.nextInt();
            TYMarks tym = new TYMarks(th, pr);

            stud[i] = new Student(roll_no, name, sym, tym);

        }
        System.out.println("\n*  STUDENT DETAILS *");
        System.out.println("R.No\tName\tCompTotal\tMathTotal\tElectTotal\tTheory\t\tPractical\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.print(stud[i]);
            stud[i].calculategrade();
        }
        sc.close();
    }
}
