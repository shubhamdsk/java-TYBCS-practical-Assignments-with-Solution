/*
Set A
a) Define a class patient (patient_name, patient_age, patient_oxy_level,patient_HRCT_report). Create an object of patient. Handle appropriate exception while patient oxygen level less than 95% and HRCT scan report greater than 10, then throw user defined Exception "Patient is Covid Positive(+) and Need to Hospitalized" otherwise display its information.
*/

import java.util.*;

class HealthException extends Exception {
    String msg = "I'm sorry ! Your'e Covid Positive(+) \n Need to Hospitalized\n";

    public String toString() {
        return msg;
    }
}

class patient {
    String pname;
    byte page;
    int p_oxy_level;
    int p_HRTC_report;

    patient(String p, byte a, int ol, int pr) {
        pname = p;
        page = a;
        p_oxy_level = ol;
        p_HRTC_report = pr;
    }

    public void display() {
        System.out.println("\n\t\tPatient Details\n");
        System.out.println("\tPatient Name\tPatient Age\tOxygen_level\tHRTC_Report");
        System.out.println("\t" + pname + "\t\t" + page + "\t\t" + p_oxy_level + "\t\t" + p_HRTC_report);
    }
}

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter Patient Name: ");
            String pn = sc.nextLine();

            System.out.println("Enter Patient Age: ");
            Byte pa = sc.nextByte();

            System.out.println("Enter Oxygen Level: ");
            int ol = sc.nextInt();

            System.out.println("Enter HRTC Report: ");
            int pr = sc.nextInt();
            patient p = new patient(pn, pa, ol, pr);

            if (p.p_oxy_level < 95 && p.p_HRTC_report > 10) {
                throw new HealthException();

            }
            p.display();

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();

    }
}
/*O/P:
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> javac Hospital.java
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java Hospital      
Enter Patient Name: 
ABC
Enter Patient Age: 
67
Enter Oxygen Level:
98
Enter HRTC Report:
8

                Patient Details

        Patient Name    Patient Age     Oxygen_level    HRTC_Report
        ABC             67              98              8

PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 4> java Hospital
Enter Patient Name: 
XYZ
Enter Patient Age:
89
Enter Oxygen Level:
78
Enter HRTC Report:
15
I'm sorry ! Your'e Covid Positive(+)
 Need to Hospitalized
*/
