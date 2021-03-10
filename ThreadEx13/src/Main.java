import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();
        System.out.println("isInterrupted(): " + th1.isInterrupted());
    }
}

class ThreadEx13_1 extends Thread {
    public void run() {
        int i = 100;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            // for (long x = 0; x < 2500000000L; x++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("count finished");
    }
}