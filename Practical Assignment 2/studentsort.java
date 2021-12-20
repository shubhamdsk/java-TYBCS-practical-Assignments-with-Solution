/*Set A
b.Define Student class(roll_no, name, percentage) to create n objects of the Student class. Accept details from the user for each object. Define a static method "sortStudent" which sorts the array on the basis of percentage.
*/


import java.util.*;

public class studentsort {
    int roll_no;
    String name;
    double per;

    studentsort() {

    }// default counstructor

    void setdata(int roll_no, String name, double per) {
        this.roll_no = roll_no;
        this.name = name;
        this.per = per;

    }// setdata

    void display() {
        System.out.println(this.roll_no + "\t\t" + this.name + "\t\t" + this.per);
    }// display

    static void sort(studentsort a[], int n) {
        studentsort temp = new studentsort();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i].per > a[j].per) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of student:");
        int n = sc.nextInt();
        studentsort s[] = new studentsort[n];

        for (int i = 0; i < n; i++) {
            s[i] = new studentsort();

            System.out.println("Enter " + (i + 1) + " student data");

            System.out.println("Enter Roll no:");
            int rn = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student Name:");
            String name = sc.nextLine();

            System.out.println("Enter Percentage:");
            double per = sc.nextDouble();

            s[i].setdata(rn, name, per);
        } // for

        System.out.println("\nStudent Records Are:\n");
        System.out.println("R.No\t\tStud Name\tPercentage");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }

        studentsort.sort(s, n);
        System.out.println("\nSorted Student Details:\n");
        System.out.println("R.No\t\tStud Name\tPercentage");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
        sc.close();
    }// main
}// class
