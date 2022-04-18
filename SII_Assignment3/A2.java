/**
 * 
 * @author:Shubham Deshmukh
 * 
 * b) Write a program in which thread sleep for 6 sec in the loop in reverse order from 100 to 1 and change the name of 	thread.
 */
public class A2 {
	public static void main(String[] args) {
		try {
			Thread t = Thread.currentThread();
			t.setName("Reverse Thread");
			System.out.println(t);
			for (int i = 100; i >= 1; i--) {
				System.out.println(i);
				Thread.sleep(6000);
			}
		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}// main
}// class
