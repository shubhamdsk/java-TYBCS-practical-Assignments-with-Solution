public class A1 extends Thread {
    String str;
    int n;

    A1(String str, int n) {
        this.str = str;
        this.n = n;
    }
    
    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                System.out.println(getName() + " : " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        A1 t1 = new A1("COVID19", 10);
        A1 t2 = new A1("LOCKDOWN2020", 20);
        A1 t3 = new A1("VACCINATED", 30);

        t1.start();
        t2.start();
        t3.start();

    }
}