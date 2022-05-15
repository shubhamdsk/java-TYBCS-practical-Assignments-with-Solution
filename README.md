# Java-Practical-Assignments with Solution
Assignment Related Programs are Here.

# SII_Assignment1
Set A

A1. Program to define a thread for printing text on output screen for ‘n’ number of times. Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor. Example:
i. First thread prints “COVID19” 10 times.
ii. Second thread prints “LOCKDOWN2020” 20 times
iii. Third thread prints “VACCINATED2021” 30 times

A2.Write a program in which thread sleep for 6 sec in the loop in reverse order from 100 to 1 and change the name of 	thread.

A3.Write a program to solve producer consumer problem in which a producer produces a value and consumer consume the value before producer generate the next value. (Hint: use thread synchronization)


Set B
B1.

B2. Write a program for a simple search engine. Accept a string to be searched. Search for the string in all text files in the current folder. Use a separate thread for each file. The result should display the filename, line number where the string is found.
  for executing this program
  1.you have create one folder and give name according to you (folder name is thread)
  2. In this particular folder you have to create some text files and put some text as well (my text files are a.txt & b.txt.)

B3.


Set C
C1. Write a program that simulates a traffic light. The program lets the user select one of three lights: red, yellow, or green with radio buttons. On selecting a button, an appropriate message with “stop” or “ready” or “go”should appear above the buttons in a selected color. Initially there is no message shown.


# SII_Assignment2
Set A

A1. Write a java program to accept names of ‘n’ cities, insert same into array list collection and display the contents of same array list, also remove all these elements.

A2. Write a java program to read ‘n’ names of your friends, store it into linked list, also display contents of the same.

A3. Write a program to create a new tree set, add some colors (string) and print out the tree set.

A4. Create the hash table that will maintain the mobile number and student name. Display the contact list.

Set B

B1. Accept 'n' integers from the user. Store and display integers in sorted order having proper collection class. The collection should not accept duplicate elements.

B2. Write a program to sort HashMap by keys and display the details before sorting and after sorting.

B3. Write a program that loads names and phone numbers from a text file where the data is organized as one line per record and each field in a record are separated by a tab (\t)or(:).it takes a name or phone number as input and prints the corresponding other value from the hash table (hint: use hash tables). (For file content use B3.txt)

Set C
C1. Create a java application to store city names and their STD codes using an
        appropriate collection. The GUI should allow the following operations:
        i. Add a new city and its code (No duplicates)
        ii. Remove a city from the collection
        iii. Search for a city name and display the code

C2. Write a program to create link list of integer objects. Do the following: 
    i.add element at first position
    ii.delete last element 
    iii.display the size of link list

C3. Read a text file, specified by the first command line argument, into a list. The
    program should then display a menu which performs the following operations on the
    list:
  1.Insert line 
  2. Delete line 
  3. Append line 
  4. Modify line 
  5. Exit
    When the user selects Exit, save the contents of the list to the file and end the
    program. (For file content use C3.txt)


# SII_Assignment3
Set A

A1.(StudentprojectDisplay)-Create a PROJECT table with fields project_id, Project_name, Project_description, Project_Status. etc. Insert values in the table. Display all the details of the PROJECT table in a tabular format on the screen.(using swing).
--for database material use here project.pgsql file.

A2.(Metadata)- Write a program to display information about the database and list all the tables in the database. (Use DatabaseMetaData).

A3.(DONOR) - Write a program to display information about all columns in the DONAR table using ResultSetMetaData.
--for database material use here donor.pgsql file.

Set B

B1.(mobile) - Create a MOBILE table with fields Model_Number, Model_Name, Model_Color, Sim_Type, NetworkType, BatteryCapacity, InternalStorage, RAM and ProcessorType. Insert values in the table. Write a menu driven program to pass the input using Command line argument to perform the following operations on MOBILE table.
1. Insert 2. Modify 3. Delete 4. Search 5. View All 6. Exit.
--for database material use here mobile.pgsql file

B2.(Cowin) - Design a following Registration form and raise an appropriate exception if invalid information is entered like Birth Year ‘0000’.
--for database material use here cowin.pgsql file

Set C

C1.(Student_Course) - Create tables : Course (courseid, coursename, courseinstructor) and Student
(studentid, studentname, studentclass). Course and Student have a many to many
relationship. Create a GUI based system for performing the following operations on
the tables:
Course : Add Course, View All students of a specific course
Student : Add Student, Delete Student, View All students, Search student.
--for database material use here student_course.pgsql file.

C2.(Employee) - Create the following tables and relations, for an INVESTMENT firm EMP(empid
,empname, empaddress, empcontact, empage) INVESTOR(invno, invname , invdate,
invamt) An employee may invest in one or more investments, hence he can be an
investor. But an investor need not be an employee of the firm. Insert sufficient
number of records in the relations / tables with appropriate values.
i. Display the List the distinct names of person who are either employees, or
investors or both.
ii. List the names of employees who are not investors
--for database material use here employee.pgsql file
