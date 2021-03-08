public class Main {

    public static void main(String[] args) {
	// write your code here
        ThreadEx2_1 t1 = new ThreadEx2_1();
        // t1.start();
        t1.run();
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

