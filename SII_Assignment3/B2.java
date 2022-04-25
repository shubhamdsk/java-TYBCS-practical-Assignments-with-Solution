/**
 * @author : Shubham Deshmukh
 * 
 * Write a program for a simple search engine. Accept a string to be searched. Search for the string in all text files in the current folder. Use a separate thread for each file. The result should display the filename, line number where the string is found.
 * 
 * i have use a.txt and b.txt use can use any text file according to you, but all the text file must be in the same folder. Thank you
 */
import java.io.*;

public class B2 extends Thread {
    File f1;
    String fname;
    static String str;
    String line;
    LineNumberReader reader = null;

    B2(String fname) {
        this.fname = fname;
        f1 = new File(fname);
    }

    public void run() {
        try {
            FileReader fr = new FileReader(f1);
            reader = new LineNumberReader(fr);
            while ((line = reader.readLine()) != null) {
                if (line.indexOf(str) != -1) {
                    System.out.println("String found in " + fname + " at " + reader.getLineNumber() + " line");
                    interrupt();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            Thread t[] = new Thread[20];
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter String to Search :");

            str = br.readLine();
            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File file, String name) {
                    if (name.endsWith(".txt")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };

            File dir = new File(".");
            File[] files = dir.listFiles(filter);
            if (files.length == 0) {
                System.out.println("No files available with this extension");
            } else {
                for (int i = 0; i < files.length; i++) {
                    for (File aFile : files) {
                        t[i] = new B2(aFile.getName());
                        t[i].start();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
