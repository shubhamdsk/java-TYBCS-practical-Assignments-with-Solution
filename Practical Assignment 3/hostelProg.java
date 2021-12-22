/*
Set C
a) Create an interface Department containing attributes deptName and deptHead. It also has abstract methods for printing the attributes. Create a class hostel containing hostelName, hostelLocation and numberOfRooms. The class contains method printing the attributes. Then write Student class extending the Hostel class and implementing the Department interface. This class contains attributes studentName, regNo, electiveSubject and avgMarks. Write suitable printData method for this class. Also, implement the abstract methods of the Department interface. Write a driver class to test the Student class. The program should be menu driven containing the options:
i. Admit new student
ii. Migrate a student
iii. Display details of a student
For the third option, a search is to be made on the basis of the entered registration Number.
*/

import java.util.Scanner;

interface Department {
    String deptName = "Computer Science";
    String deptHead = "Dr.Ladda Sir";

    void printData();
}

class Hostel {
    String hostelName;
    String hostelLocation;
    int roomNumber;

    Hostel(String hostelName, String hostelLocation, int roomNumber) {
        this.hostelName = hostelName;
        this.hostelLocation = hostelLocation;
        this.roomNumber = roomNumber;
    }

    void printData() {
        System.out.print(hostelName + "\t\t" + hostelLocation + "\t\t\t" + roomNumber +"\n");
    }
}

class Student extends Hostel implements Department {
    String studentName;
    int regNo;
    String electiveSubject;
    double avgMarks;

    Student(int regNo, String studentName, String electiveSubject, double avgMarks, String hostelName,
            String hostelLocation, int roomNumber) {
        super(hostelName, hostelLocation, roomNumber);
        this.studentName = studentName;
        this.regNo = regNo;
        this.electiveSubject = electiveSubject;
        this.avgMarks = avgMarks;
    }

    public void printData() {
        System.out.println("\n----------------------------------------------------------------------------------------------------------");
        System.out.print("RegNo\tStud Name\tElected Sub\tAvgMarks\tHostelName\tHostelLocation\t\tRoomNumber");
        System.out.println("\n----------------------------------------------------------------------------------------------------------");
        System.out.print(regNo + "\t" + studentName + "\t\t" +
                electiveSubject + "\t\t" + avgMarks + "\t\t");
                super.printData();
    }
}

public class hostelProg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 0, choice, i, flag = 0;
        Student s[] = new Student[20];
        do {
            System.out.println("\n1.Admit new Student");
            System.out.println("2.Migrate a student by Hostel");
            System.out.println("3.Display details of a student");
            System.out.println("0.Exit");
            System.out.println("\nEnter your Choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Reg number : ");
                    int regNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    String studentName = sc.nextLine();

                    System.out.print("Enter Subject : ");
                    String electiveSubject = sc.nextLine();

                    System.out.print("Enter AvgMarks : ");
                    double avgMarks = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Hostel Name : ");
                    String hostelName = sc.nextLine();

                    System.out.print("Enter Hostel Location: ");
                    String hostelLocation = sc.nextLine();

                    System.out.print("Enter Room Number : ");
                    int roomNumber = sc.nextInt();

                    s[n] = new Student(regNo, studentName, electiveSubject, avgMarks, hostelName, hostelLocation,
                            roomNumber);
                    n++;
                    System.out.println("Sucessfully Record Added");
                    break;

                case 2:
                    if (n > 0) {
                        flag = 0;
                        System.out.println("Migrate Student by Hostel Name");
                        System.out.print("Enter Reg Number : ");
                        int rno = sc.nextInt();
                        sc.nextLine();

                        for (i = 0; i < n; i++) {
                            if (s[i].regNo == rno) {
                                System.out.print("Enter New Hostel Name : ");
                                String hname = sc.nextLine();

                                System.out.print("Enter New Hostel Location : ");
                                String lname = sc.nextLine();

                                System.out.print("Enter New Room Number : ");
                                int rnumber = sc.nextInt();

                                s[i].hostelName = hname;
                                s[i].hostelLocation = lname;
                                s[i].roomNumber = rnumber;
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid Reg Number or Student Name");
                        }
                    } else {
                        System.out.println("Empty Students Records ");
                    }
                    break;
                case 3:
                    if (n > 0) {
                        flag = 0;
                        System.out.print("Enter Reg Number : ");
                        int rno = sc.nextInt();
                        for (i = 0; i < n; i++) {
                            if (s[i].regNo == rno) {
                                s[i].printData();
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Invalid Reg Number ");
                        }
                    } else {
                        System.out.println("Empty Students Records ");
                    }
                    break;
                case 0:
                    System.out.println("Thank You !!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
        sc.close();
    }
}

/*
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 3> javac hostelProg.java
PS C:\Users\shubham Deshmukh\Desktop\College\Java\Practical Assignments\Practical Assignment 3> java hostelProg

1.Admit new Student
2.Migrate a student by Hostel 
3.Display details of a student
0.Exit

Enter your Choice
1
Enter Reg number : 11
Enter Student Name : Shubham
Enter Subject : Math
Enter AvgMarks : 87
Enter Hostel Name : Private
Enter Hostel Location: Sangamner
Enter Room Number : 78
Sucessfully Record Added

1.Admit new Student     
2.Migrate a student by Hostel
3.Display details of a student
0.Exit

Enter your Choice
1
Enter Reg number : 56
Enter Student Name : Prasad
Enter Subject : Java
Enter AvgMarks : 89
Enter Hostel Name : Govt
Enter Hostel Location: Vadgaon
Enter Room Number : 67
Sucessfully Record Added

1.Admit new Student
2.Migrate a student by Hostel
3.Display details of a student
0.Exit

Enter your Choice
3
Enter Reg Number : 11

----------------------------------------------------------------------------------------------------------
RegNo   Stud Name       Elected Sub     AvgMarks        HostelName      HostelLocation          RoomNumber
----------------------------------------------------------------------------------------------------------
11      Shubham         Math            87.0            Private         Sangamner                       78

1.Admit new Student
2.Migrate a student by Hostel
3.Display details of a student
0.Exit

Enter your Choice
3
Enter Reg Number : 56

----------------------------------------------------------------------------------------------------------
RegNo   Stud Name       Elected Sub     AvgMarks        HostelName      HostelLocation          RoomNumber
----------------------------------------------------------------------------------------------------------
56      Prasad          Java            89.0            Govt            Vadgaon                 67

1.Admit new Student
2.Migrate a student by Hostel
3.Display details of a student
0.Exit

Enter your Choice
2
Migrate Student by Hostel Name
Enter Reg Number : 56
Enter New Hostel Name : Private
Enter New Hostel Location : Sangamner
Enter New Room Number : 78

1.Admit new Student
2.Migrate a student by Hostel
3.Display details of a student
0.Exit

Enter your Choice
3
Enter Reg Number : 56

----------------------------------------------------------------------------------------------------------
RegNo   Stud Name       Elected Sub     AvgMarks        HostelName      HostelLocation          RoomNumber
----------------------------------------------------------------------------------------------------------
56      Prasad          Java            89.0            Private         Sangamner                       78

1.Admit new Student
2.Migrate a student by Hostel
3.Display details of a student
0.Exit

Enter your Choice
0
Thank You !!
*/