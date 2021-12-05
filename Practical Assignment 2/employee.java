/*Set A:
a.Create an employee class(id,name,deptname,salary). Define a default and parameterized constructor. Use ‘this’ keyword to initialize instance variables. Keep a count of objects created. Create objects using parameterized constructor and display the object count after each object is created.(Use static member and method). Also display the contents of each object.
*/

import java.util.*;

class employee {
    int id;
    String name;
    String deptname;
    double salary;
    static int cnt = 0;

    employee() {

    }//default counstructor

    void setdata(int id, String name, String deptname, double salary) {
        this.id = id;
        this.name = name;
        this.deptname = deptname;
        this.salary = salary;
        cnt++;
        System.out.println("Count of object : " + cnt);
    }//setdata

    void display() {
        System.out.println(this.id + "\t\t" + this.name + "\t\t" + this.deptname + "\t\t" + this.salary);
    }//displat

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employee:");
        int n = sc.nextInt();
        employee e[] = new employee[n];

        for (int i = 0; i < n; i++) {
            e[i] = new employee();

            System.out.println("Enter " + (i + 1) + " employee data");

            System.out.println("Enter id:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Employee Name:");
            String en = sc.nextLine();

            System.out.println("Enter DeptName:");
            String dn = sc.nextLine();

            System.out.println("Enter Salary:");
            double salary = sc.nextDouble();

            e[i].setdata(id, en, dn, salary);
        }//for

        System.out.println("Employee Records Are:");
        System.out.println("Id\tEmployee Name\t\tDept Name\tSalary");
        for (int i = 0; i < n; i++) {
            e[i].display();
        }
        sc.close();
    }//main
}//class
