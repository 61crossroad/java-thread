public class Main {

    public static void main(String[] args) {
	// write your code here

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("\nET1: " + (System.currentTimeMillis() - startTime));

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("\nET2: " + (System.currentTimeMillis() - startTime));
    }
}
