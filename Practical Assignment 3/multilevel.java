/*Set A
a) Write a program for multilevel inheritance such that country is inherited from continent. State is inherited from country. Display the place, state, country and continent.
*/

import java.util.Scanner;

class continent {
    String cName;
}

class country extends continent {
    String country_name;
}

class state extends country {
    String state_name;
    String place;

    state(String c1, String c2, String c3, String c4) {
        cName = c1;
        country_name = c2;
        state_name = c3;
        place = c4;
    }

    public void display() {
        System.out.println("\n\t\t\t\t Data \t\t");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|\tContinent\tCountry\t\tState\t\tPlace\t\t|");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|\t" + cName + "\t\t" + country_name + "\t\t" + state_name + "\t\t" + place + "\t\t|");
        System.out.println("------------------------------------------------------------------------");
    }
}

public class multilevel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Continent Name: ");
        String c1 = sc.nextLine();

        System.out.println("Enter Country Name: ");
        String c2 = sc.nextLine();

        System.out.println("Enter State Name: ");
        String c3 = sc.nextLine();

        System.out.println("Enter Place Name: ");
        String c4 = sc.nextLine();

        state s = new state(c1, c2, c3, c4);
        s.display();

        sc.close();

    }
}