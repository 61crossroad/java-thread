public class Main {

    public static void main(String[] args) {
	// write your code here
        // ThreadEx1_1 t1 = new ThreadEx1_1();
        ThreadEx1_1 t1 = new ThreadEx1_1("ThreadEx1_1");
        // t1.setName("ThreadEx1_1");

        Runnable r = new ThreadEx1_2();
        // Thread t2 = new Thread(r);
        Thread t2 = new Thread(r, "ThreadEx1_2");

        t1.start();
        t2.start();
    }
}

class ThreadEx1_1 extends Thread {
    ThreadEx1_1 () {}
    ThreadEx1_1 (String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " t1");
        }
    }
}

class ThreadEx1_2 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " t2");
        }
    }
}