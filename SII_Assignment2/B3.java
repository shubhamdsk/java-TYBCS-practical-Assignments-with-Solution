/**
 * @author:Shubham Deshmukh
 * 
 * c) Write a program that loads names and phone numbers from a text file where the data is organized as one line per record and each field in a record are separated by a tab (\t)or(:).it takes a name or phone number as input and prints the corresponding other value from the hash table (hint: use hash tables).
 */
import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;
public class B3 {
    public static void main(String[] args) {
        try {
            File f = new File("B3.txt"); 
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(f));
            Hashtable<String, String> table = new Hashtable<>();
            Scanner sc = new Scanner(System.in);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");

                String name = parts[0].trim();
                String number = parts[1].trim();
                if (!name.equals("") && !number.equals("")) {
                    table.put(name, number);
                }
            }
            System.out.println("Enter Name :");
            String key = sc.nextLine();

            if (table.containsKey(key)) {
                System.out.println(table.get(key));
                br.close();
                sc.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
