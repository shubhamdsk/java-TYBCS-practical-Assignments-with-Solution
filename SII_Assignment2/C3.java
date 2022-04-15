/**
 * @author:Shubham Deshmukh
 * 
 * c) Read a text file, specified by the first command line argument, into a list. The
    program should then display a menu which performs the following operations on the
    list:
 * 1.Insert line 2. Delete line 3. Append line 4. Modify line 5. Exit
    When the user selects Exit, save the contents of the list to the file and end the
    program.
 */
import java.util.*;
import java.io.*;

public class C3 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        try {
            // Here, we have used command line argument , so at the time of run the code use command java C3 C3.txt
            File f = new File(arg[0]);
            BufferedReader br = null;

            br = new BufferedReader(new FileReader(f));
            FileOutputStream fout = new FileOutputStream(arg[0]);
            int ch;
            ArrayList<Object> al = new ArrayList<>();

            String line = "";
            while ((line = br.readLine()) != null) {
                al.add(line);

            } // while
              // main logic
            do {
                System.out.println("1.Insert Line\n2.Delete Line\n3.Append Line\n4.Modify Line\n5.Exit");
                System.out.println("Enter choice: ");
                ch = sc.nextInt();
                String l1 = "This is a new Line";
                switch (ch) {
                    case 1:
                        al.add(l1);
                        break;

                    case 2:
                        al.remove(l1);
                        break;

                    case 3:
                        al.add(l1);
                        break;

                    case 4:
                        int n = al.size() - 1;
                        al.set(n, "\tUpdated line");

                        break;
                    case 5:
                        ListIterator<Object> li = al.listIterator();
                        while (li.hasNext()) {
                            String l2 = (String) li.next();
                            byte b[] = l2.getBytes();
                            fout.write(b);

                        }
                        System.exit(1);
                        break;

                }
            } while (ch < 6);
            br.close();
            fout.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}