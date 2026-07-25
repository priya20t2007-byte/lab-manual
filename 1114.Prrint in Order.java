import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

// User-defined exception
class InvalidThreadOrderException extends Exception {
    public InvalidThreadOrderException(String message) {
        super(message);
    }
}

// Foo class
class Foo {

    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public void first() {
        System.out.println("first");
        latch1.countDown();
    }

    public void second() {
        try {
            latch1.await();
            System.out.println("second");
            latch2.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            latch2.await();
            System.out.println("third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    // Method to validate user input
    public static void validateOrder(int[] order) throws InvalidThreadOrderException {

        boolean[] visited = new boolean[4];

        for (int value : order) {

            if (value < 1 || value > 3) {
                throw new InvalidThreadOrderException(
                        "Thread numbers must be 1, 2, or 3 only.");
            }

            if (visited[value]) {
                throw new InvalidThreadOrderException(
                        "Duplicate thread number found.");
            }

            visited[value] = true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] order = new int[3];

        System.out.println("Enter thread launch order (1 2 3 in any order):");

        for (int i = 0; i < 3; i++) {
            order[i] = sc.nextInt();
        }

        try {

            validateOrder(order);

            Foo foo = new Foo();

            Thread t1 = new Thread(() -> foo.first());
            Thread t2 = new Thread(() -> foo.second());
            Thread t3 = new Thread(() -> foo.third());

            Thread[] threads = new Thread[4];
            threads[1] = t1;
            threads[2] = t2;
            threads[3] = t3;

            // Start threads in user-given order
            for (int i = 0; i < 3; i++) {
                threads[order[i]].start();
            }

            // Wait for completion
            t1.join();
            t2.join();
            t3.join();

            System.out.println("Output is always in correct order.");

        } catch (InvalidThreadOrderException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        sc.close();
    }
}
