
/* Set A
c) Define an interface Operation which has methods area(),volume().Define a constant PI having a value 3.142.Create a class cylinder which implements this interface (members – radius, height) Create one object and calculate the area and volume.
 */
import java.util.Scanner;

interface operation {
    void area();

    void volume();

    final double PI = 3.142;
}

class cylinder implements operation {
    int r;
    int h;

    cylinder(int r, int h){
        this.r=r;
        this.h=h;
    }

    public void area() {
        System.out.println("Area :" + (2 * PI * r * h + 2 * PI * r * r) +" sq units\n");
    }

    public void volume() {
        System.out.println("Volume : " + (PI * r * r * h) +" cubic units\n");
    }
}

public class CylinderVol {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius: ");
        int r = sc.nextInt();

        System.out.println("Enter height: ");
        int h = sc.nextInt();

        cylinder c = new cylinder(r,h);

        c.area();
        c.volume();

        sc.close();
    }
}
