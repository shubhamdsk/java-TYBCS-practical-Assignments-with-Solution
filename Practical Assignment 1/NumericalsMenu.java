
/*SET A
b)Write a menu driven program to perform the following operations
i. Calculate the volume of cylinder. (hint : Volume: π × r² × h)
ii. Find the factorial of given number.
iii. Check the number is Armstrong or not.
iv. Exit
*/
import java.util.Scanner;

public class NumericalsMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n1.Volume of Cylinder. \n2.Factorial of Number. \n3.Armstrong Number. \n4.Exit");
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();

        switch (choice) {
        case 1:
            System.out.println("Enter Radius:");
            Float r = sc.nextFloat();
            System.out.println("Enter Height:");
            Float h = sc.nextFloat();
            double Volume = Math.PI * r * r * h;
            System.out.printf("Volume of Cylinder: %f" ,Volume);
            break;

        case 2:
            System.out.println("Enter Number for Finding Factorial : ");
            int num = sc.nextInt();
            long fact = 1;
            for (int i = 1; i <= num; ++i) {
                fact = fact * i;
            }
            System.out.printf("Factorial of %d = %d\n", num, fact);
            break;

        case 3:
            System.out.println("Enter Number for Finding Armstrong Number : ");

            int n = sc.nextInt();

            int leng = 0;
            int t1 = n;

            while (t1 != 0) {
                t1 = t1 / 10;
                leng = leng + 1;
            }

            int t2 = n;
            int arm = 0;
            int rem;

            while (t2 != 0) {
                int mult = 1;
                rem = t2 % 10;
                for (int i = 1; i <= leng; i++) {
                    mult = mult * rem;
                }
                arm = arm + mult;
                t2 = t2 / 10;
            }
            if (arm == n) {
                System.out.println("The given number is armstrong..!");
            } else {
                System.out.println("The given number is not armstrong..!");
            }
            break;
        case 4:
            System.exit(0);
        
        default:
            break;

        }
        sc.close();

    }
}
