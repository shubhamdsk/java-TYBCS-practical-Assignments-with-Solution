
/*Set B
b) Write a program to using marker interface create a class product(product_id, product_name, product_cost, product_quantity) define a default and parameterized constructor. Create objects of class product and display the contents of each object and Also display the object count.
*/
import java.util.*;

interface MarkerInt {

}

class product implements MarkerInt {
    int pid, pcost, quantity;
    String pname;
    static int cnt;
    // Default constructor

    product() {
        pid = 1;
        pcost = 10;
        quantity = 1;
        pname = "pencil";
        cnt++;
    }

    // Parameterized constructor

    product(int id, String n, int c, int q) {
        pid = id;
        pname = n;
        pcost = c;
        quantity = q;
        cnt++;
        System.out.println("\nCOUNT OF OBJECT IS : " + cnt + "\n");
    }

    public void display() {

        System.out.println("\t" +pid + "\t" + pname + "\t" + pcost + "\t" + quantity);

    }
}

public class MarkerInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Product : ");
        int n = sc.nextInt();

        product pr[] = new product[n];
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter " + (i + 1) + " Product Details :\n");

            System.out.println("Enter Product ID: ");
            int pid = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter Product Name: ");
            String pn = sc.nextLine();

            System.out.println("Enter Product Cost:");
            int pc = sc.nextInt();

            System.out.println("Enter Product Quantity:");
            int pq = sc.nextInt();

            pr[i] = new product(pid, pn, pc, pq);

        }
        System.out.println("\n\t\t Product Details\n");
        System.out.println("\tId\tPname\tCost\tQuantity\n");
        for (int i = 0; i < n; i++) {
            pr[i].display();
        }

        sc.close();
    }

}
