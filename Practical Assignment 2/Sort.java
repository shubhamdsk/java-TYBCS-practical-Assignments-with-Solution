/* Set A
c. Write a java program to accept 5 numbers using command line arguments sort and display them.
*/

public class Sort {
    public static void main(String[] args) {
        if (args.length == 5) {
            int a[] = new int[5];

            for (int i = 0; i < 5; i++) {
                a[i] = Integer.parseInt(args[i]);
            }
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (a[i] > a[j]) {
                        int t = a[i];
                        a[i] = a[j];
                        a[j] = t;

                    } // if
                } // for

                System.out.println(a[i] + " ");
            } // for
        } // if

    }
}
