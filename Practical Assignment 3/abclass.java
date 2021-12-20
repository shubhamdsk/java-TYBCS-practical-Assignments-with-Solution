
/* Set A
b) Define an abstract class Staff with protected members id and name. Define a parameterized constructor. Define one subclass OfficeStaff with member department. Create n objects of OfficeStaff and display all details.
*/
import java.util.*;

abstract class Staff {
    protected int id;
    protected String name;

    Staff(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract public void display();
}

class OfficeStaff extends Staff {
    String dept;

    OfficeStaff(int id, String name, String dept) {
        super(id, name);
        this.dept = dept;
    }

    public void display() {
        System.out.println("\t|\t" + id + "\t\t" + name + "\t\t" + dept + "\t\t" + "|");
        System.out.println("------------------------------------------------------------------------");
    }
}

public class abclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Total number of Employee: ");
        int n = sc.nextInt();
        OfficeStaff s[] = new OfficeStaff[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter " + (i + 1) + " number employee Details: \n");

            System.out.println("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.println("Enter Dept Name: ");
            String dept = sc.nextLine();

            s[i] = new OfficeStaff(id, name, dept);

        }
        System.out.println("\t\t\t\t Employee Details");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t|\tID\t\tName\t\tDept\t\t|");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
        sc.close();
    }
}
