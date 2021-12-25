/*
Set C
a) Create an interface Department containing attributes deptName and deptHead. It also has abstract methods for printing the attributes. Create a class hostel containing hostelName, hostelLocation and numberOfRooms. The class contains method printing the attributes. Then write Student class extending the Hostel class and implementing the Department interface. This class contains attributes studentName, regNo, electiveSubject and avgMarks. Write suitable printData method for this class. Also, implement the abstract methods of the Department interface. Write a driver class to test the Student class. The program should be menu driven containing the options:
i. Admit new student
ii. Migrate a student
iii. Display details of a student
For the third option, a search is to be made on the basis of the entered registration Number.
*/

import java.util.*;

interface dept {
    String dname = "Computer";
    String dhead = "Varient";

    void printData();

}

class hostel {
    String hname;
    String loc;
    int noOfRooms;

    hostel(String h, int no, String l) {
        hname = h;
        noOfRooms = no;
        loc = l;
    }

    void printData() {
        System.out.print(hname + "\t\t" + loc + "\t\t\t" + noOfRooms + "\n");
    }
}

class student extends hostel implements dept {
    String sname;
    int regNo;
    String sub;
    double avg;

    student(String n, int r, String s, double a, String h, int no, String l) {
        super(h, no, l);
        sname = n;
        regNo = r;
        sub = s;
        avg = a;
    }

    public void printData() {
        System.out.println(
                "\n----------------------------------------------------------------------------------------------------------");
        System.out.print("RegNo\tStud Name\tElected Sub\tAvgMarks\tHostelName\tHostelLocation\t\tRoomNumber");
        System.out.println(
                "\n----------------------------------------------------------------------------------------------------------");
        System.out.print(regNo + "\t" + sname + "\t\t" + sub + "\t\t" + avg + "\t\t");
        super.printData();
    }
}

public class StudentHostel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        student s[] = new student[20];

        int ch, n = 0;
        do {

            System.out.println("\n*...Menu For Student Details...*\n");
            System.out.println("1.Admit Student\n2.Migrate Student\n3.Display Details Of Student\n4.Exit");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Student Name:");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter Reg No:");
                    int rn = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Sub Name:");
                    String sub = sc.nextLine();

                    System.out.print("Enter Avg Marks: ");
                    double avg = sc.nextDouble();

                    System.out.println("\nEnter Hostel Details\n");

                    sc.nextLine();
                    System.out.print("Enter Hostel Name:");
                    String h = sc.nextLine();

                    System.out.print("Enter No Of Rooms :");
                    int r = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Hostel Loc:");
                    String loc = sc.nextLine();

                    s[n] = new student(name, rn, sub, avg, h, r, loc);
                    n++;
                    System.out.println("\n Record Added Successfully\n");
                    break;
                case 2:
                    if (n > 0) {
                        System.out.println("Migrate Student By Register No: ");
                        System.out.print("Enter Reg Number : ");
                        int rno = sc.nextInt();
                        for (int i = 0; i < n; i++) {
                            if (s[i].regNo == rno) {

                                sc.nextLine();
                                System.out.print("Enter New Hostel Name : ");
                                String h1 = sc.nextLine();

                                System.out.print("Enter New Hostel Location : ");
                                String lname = sc.nextLine();

                                System.out.print("Enter New Room Number : ");
                                int r1 = sc.nextInt();

                                s[i].hname = h1;
                                s[i].loc = lname;
                                s[i].noOfRooms = r1;

                            } // if of regNo
                            else {
                                System.out.println("Invalid Register No.");
                            }

                        } // i

                    } // if of n
                    else {
                        System.out.println("No Student Records");
                    }
                    break;
                case 3:
                    if (n > 0) {
                        System.out.println("Display Student By Register No: ");
                        System.out.print("Enter Reg Number : ");
                        int rno = sc.nextInt();
                        for (int i = 0; i < n; i++) {

                            if (s[i].regNo == rno) {
                                s[i].printData();

                            } else {
                                System.out.println("Invalid Register No.");
                            }

                        } // i

                    } // if
                    else {
                        System.out.println("No Student Records");
                    }

                    break;
                case 4:
                    System.out.println("Thank You !!");
                    break;
                default:
                    System.out.println("Invalid choice");

            }// switch

        } while (ch != 4); // do
        sc.close();

    }// main

}// student

/*
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments> javac StudentHostel.java
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments> java StudentHostel      

*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student
4.Exit
Enter Choice: 1
Enter Student Name:Shubham
Enter Reg No:12
Enter Sub Name:Math
Enter Avg Marks: 87

Enter Hostel Details

Enter Hostel Name:private
Enter No Of Rooms :2
Enter Hostel Loc:Sangamner

 Record Added Successfully      


*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student    
4.Exit
Enter Choice: 1
Enter Student Name:Prasad
Enter Reg No:56
Enter Sub Name:Java
Enter Avg Marks: 95

Enter Hostel Details

Enter Hostel Name:Govt
Enter No Of Rooms :1
Enter Hostel Loc:Vadgaon

 Record Added Successfully


*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student
4.Exit
Enter Choice: 3
Display Student By Register No: 
Enter Reg Number : 12

----------------------------------------------------------------------------------------------------------
RegNo   Stud Name       Elected Sub     AvgMarks        HostelName      HostelLocation          RoomNumber
----------------------------------------------------------------------------------------------------------
12      Shubham         Math            87.0            private         Sangamner                       2
Invalid Register No.

*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student
4.Exit
Enter Choice: 3
Display Student By Register No: 
Enter Reg Number : 56
Invalid Register No.

----------------------------------------------------------------------------------------------------------
RegNo   Stud Name       Elected Sub     AvgMarks        HostelName      HostelLocation          RoomNumber
----------------------------------------------------------------------------------------------------------
56      Prasad          Java            95.0            Govt            Vadgaon                 1

*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student
4.Exit
Enter Choice: 2
Migrate Student By Register No:
Enter Reg Number : 56
Invalid Register No.
Enter New Hostel Name : Private
Enter New Hostel Location : Sangamner
Enter New Room Number : 2

*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student
4.Exit
Enter Choice: 3
Display Student By Register No:
Enter Reg Number : 56
Invalid Register No.

----------------------------------------------------------------------------------------------------------
RegNo   Stud Name       Elected Sub     AvgMarks        HostelName      HostelLocation          RoomNumber
----------------------------------------------------------------------------------------------------------
56      Prasad          Java            95.0            Private         Sangamner                       2

*...Menu For Student Details...*

1.Admit Student
2.Migrate Student
3.Display Details Of Student
4.Exit
Enter Choice: 4
Thank You !!
*/