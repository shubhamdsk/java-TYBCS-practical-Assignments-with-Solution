class shop {
    int material;
    boolean flag = false;

    public synchronized int get() {
        while (flag == false) {
            try {
                wait();
            } catch (Exception e) {
                e.getStackTrace();
            } // catch
        } // while
        flag = false;
        notify();
        return material;
    }// get

    public synchronized void put(int value) {
        while (flag == true) {
            try {
                wait();
            } catch (Exception e) {
                e.getStackTrace();
            } // catch
        } // while
        material = value;
        flag = true;
        notify();
    }// put

}// shop

class Consumer extends Thread {
    shop sh;
    int no;

    public Consumer(shop shp, int no) {
        sh = shp;
        this.no = no;
    }// consumerc

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = sh.get();
            System.out.println("Consumer #" + this.no + " got: " + value);
        } // for
    }// run
}// Consumer

class Producer extends Thread {
    shop sh;
    int no;

    public Producer(shop s, int no) {
        sh = s;
        this.no = no;
    }// producerc

    public void run() {
        for (int i = 0; i < 10; i++) {
            sh.put(i);
            System.out.println("Producer #" + this.no + " put: " + i);
            try {
                sleep((int) (Math.random() * 1000));
            } catch (Exception e) {
                e.getStackTrace();
            } // catch
        } // for
    }// run
}// Producer

public class A3 {
    public static void main(String[] args) {
        shop s = new shop();
        Producer p = new Producer(s, 1);
        Consumer c = new Consumer(s, 1);

        p.start();
        c.start();
    }
}
