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
    }

    public void display() {
        System.out.println("\n Product Details..");
        System.out.println("Id\tPname\tCost\tQuantity\n");
        System.out.println(pid + "\t" + pname + "\t" + pcost + "\t" + quantity);
        
    }
}

public class MarkerInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product ID: ");
        int pid = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter Product Name: ");
        String pn = sc.nextLine();

        System.out.println("Enter Product Cost:");
        int pc = sc.nextInt();

        System.out.println("Enter Product Quantity:");
        int pq = sc.nextInt();

        product p1 = new product();
        p1.display();

        product p = new product(pid, pn, pc, pq);
        p.display();

        sc.close();
    }

}