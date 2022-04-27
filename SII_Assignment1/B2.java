/**
 * 
 * @author : shubham Deshmukh.
 * 
 *  Write a program for a simple search engine. Accept a string to be searched. Search for the string in all text files in the current folder. Use a separate thread for each file. The result should display the filename, line number where the string is found.
 * 
 * for executing this program
 * 1.you have create one folder and give name according to you (imy folder name is thread)
 * 2. In this particular folder you have to create some text files and put some text as well (my text files are a.txt & b.txt.)
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class Mythread extends Thread {
    String str;
    String filename;

    Mythread(String str, String filename) {
        this.str = str;
        this.filename = filename;
    }

    public void run() {
        try {
            int flag = 0;
            File f = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains(str) == true) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println("String found in folder/file :" + filename);
            } else {
                System.out.println("String not found in folder/file :" + filename);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Search string :");
        String str = sc.nextLine();

        //Your folder name 
        String dirname = "thread";
        File d = new File(dirname);
        if (d.isDirectory()) {
            String s[] = d.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isFile() && s[i].endsWith(".txt")) {
                    Mythread t = new Mythread(str, dirname + "/" + s[i]);
                    t.start();
                }
            }
        }
        sc.close();
    }
}
