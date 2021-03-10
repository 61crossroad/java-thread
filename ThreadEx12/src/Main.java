public class Main {

    public static void main(String[] args) {
	// write your code here

        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();
        th1.start();
        th2.start();

        try {
            // th1.sleep(2000); // static method
            Thread.sleep(2000); // better usage
        } catch (InterruptedException e) {}

        System.out.print("<<main finished>>\n");
    }
}

class ThreadEx12_1 extends Thread {
    public void run() {
        try {
            // this.sleep(2000);
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 finished>>\n");
    }
}

class ThreadEx12_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 finished>>\n");
    }
}