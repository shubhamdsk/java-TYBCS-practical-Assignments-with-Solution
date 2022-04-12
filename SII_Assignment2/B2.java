import java.util.HashMap;
import java.util.TreeMap;

public class B2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Prasad", 2002);
        map.put("Ashish", 2001);
        map.put("Suhas", 2002);
        map.put("Swayam", 2001);
        map.put("Sanket", 2002);
        System.out.println("\nHashMap Details Before Sorting :\n" + map);

        TreeMap<Object,Object> tm = new TreeMap<>(map);
        System.out.println("\nHashMap Details After Sorting :\n" + tm);
    }
}
