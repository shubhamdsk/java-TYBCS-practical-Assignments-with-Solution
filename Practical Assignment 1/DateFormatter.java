/*SET B
a)Write a java program to display the system date and time in various formats shown below: 
Current date is : 31/08/2021
Current date is : 08-31-2021
Current date is : Tuesday August 31 2021
Current date and time is : Fri August 31 15:25:59 IST 2021
Current date and time is : 31/08/21 15:25:59 PM +0530
Current time is : 15:25:59
Current week of year is : 35
Current week of month : 5
Current day of the year is : 243
*/
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String Str = sdf.format(date);
        System.out.println("Current date is: " + Str);

        sdf = new SimpleDateFormat("MM-dd-yyyy");
        Str = sdf.format(date);
        System.out.println("Current date is: " + Str);

        sdf = new SimpleDateFormat("EEEE MMMM dd yyyy");
        Str = sdf.format(date);
        System.out.println("Current date is: " + Str);

        sdf = new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy");
        Str = sdf.format(date);
        System.out.println("Current date and time is: " + Str);

        sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss a Z");
        Str = sdf.format(date);
        System.out.println("Current date and time is: " + Str);

        sdf = new SimpleDateFormat("hh:mm:ss");
        Str = sdf.format(date);
        System.out.println("Current time is: " + Str);

        sdf = new SimpleDateFormat("w");
        Str = sdf.format(date);
        System.out.println("Current week of year is: " + Str);

        sdf = new SimpleDateFormat("W");
        Str = sdf.format(date);
        System.out.println("Current week of the month is: " + Str);

        sdf = new SimpleDateFormat("D");
        Str = sdf.format(date);
        System.out.println("Current day of the year: " + Str);
    }
}
