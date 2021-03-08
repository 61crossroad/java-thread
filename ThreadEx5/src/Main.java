public class Main {
    static long startTime = 0;

    public static void main(String[] args) {
	// write your code here

        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("\nET1: " + (System.currentTimeMillis() - Main.startTime));
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("\nET2: " + (System.currentTimeMillis() - Main.startTime));
    }
}