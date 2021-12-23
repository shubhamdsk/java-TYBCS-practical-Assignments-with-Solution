/* SET A
a) Write a program to calculate perimeter and area of rectangle.
(hint : area = length * breadth , perimeter=2*(length+breadth))
*/

import java.util.Scanner;
public class Rectangle 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length of Rectangle : ");
        int length = sc.nextInt();

        System.out.println("Enter breadth of Rectangle : ");
        int breadth = sc.nextInt();

        int area = length * breadth;
        System.out.println("Area of Reactangle : " + area);

        int Perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of Reactangle : " + Perimeter);

        sc.close();
    }
}
