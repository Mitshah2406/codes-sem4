import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

class dining {
    static int philosopher = 5;
    static Philosopher philosophers[] = new Philosopher[philosopher];
    static Chopstick chopsticks[] = new Chopstick[philosopher];
    static Semaphore eatingSem = new Semaphore(4); // Semaphore to control eating access

    static class Chopstick {
        public Semaphore mutex = new Semaphore(1);

        void grab() {
            try {
                mutex.acquire();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        void release() {
            mutex.release();
        }

        boolean isFree() {
            return mutex.availablePermits() > 0;
        }
    }

    static class Philosopher extends Thread {
        public int number;
        public Chopstick leftchopstick;
        public Chopstick rightchopstick;

        Philosopher(int num, Chopstick left, Chopstick right) {
            number = num;
            leftchopstick = left;
            rightchopstick = right;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    eatingSem.acquire(); // Acquire the permit to eat
                    leftchopstick.grab();
                    System.out.println("Philosopher " + (number + 1) + " grabs left chopstick.");
                    rightchopstick.grab();
                    System.out.println("Philosopher " + (number + 1) + " grabs right chopstick.");
                    eat();
                    leftchopstick.release();
                    System.out.println("Philosopher " + (number + 1) + " releases left chopstick.");
                    rightchopstick.release();
                    System.out.println("Philosopher " + (number + 1) + " releases right chopstick.");
                    eatingSem.release(); // Release the permit after eating
                } catch (InterruptedException e) {
                    e.printStackTrace(System.out);
                }
            }
        }

        void eat() {
            try {
                int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
                System.out.println("Philosopher " + (number + 1) + " eats for " + sleepTime + "ms");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < philosopher; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < philosopher; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % philosopher]);
            philosophers[i].start();
        }
        // No need to check for deadlock, the program will run indefinitely
    }
}
