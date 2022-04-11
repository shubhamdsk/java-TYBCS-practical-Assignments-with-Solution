
/**
 * @author:Shubham Deshmukh
 * 
 * d) Create the hash table that will maintain the mobile number and student name. Display the contact list.
 * */
import java.util.Hashtable;
public class A4 {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("Prasad", "8796465800");
        hashtable.put("Ashish", "8806503414");
        hashtable.put("Suhas", "8629913414");
        hashtable.put("Sanket", "7118919895");

        System.out.println(hashtable);
    }
}
