
/*Set C
b) Write a java program to accept Employee name from the user and check whether it is valid or not. If it is not valid then throw user defined Exception "Name is Invalid" otherwise display it.(Name should contain only characters)
*/
import java.util.Scanner;

class NameisInvalid extends Exception {
    String msg = "\nInvalid Name....\nName should contain only characters\nThank You :)\n";

    public String toString() {
        return msg;
    }
}

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

public class EmployeeException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name :");
        String name = sc.nextLine();

        try {
            for (int i = 0; i < name.length(); i++) {
                int ch = (int) name.charAt(i);

                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                } else {
                    throw new NameisInvalid();
                }
            }

            System.out.println("\nEmployee Name:-" + name +"\n");

        } catch (NameisInvalid e) {
            System.out.println(e);
        }

    }
}
