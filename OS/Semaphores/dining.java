import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

<<<<<<< HEAD
=======
// class dining {
//     static int philosopher = 5;
//     static Philosopher philosophers[] = new Philosopher[philosopher];
//     static Chopstick chopsticks[] = new Chopstick[philosopher];
//     static Semaphore eatingSem = new Semaphore(4); // Semaphore to control eating access

//     static class Chopstick {
//         public Semaphore mutex = new Semaphore(1);

//         void grab() {
//             try {
//                 mutex.acquire();
//             } catch (Exception e) {
//                 e.printStackTrace(System.out);
//             }
//         }

//         void release() {
//             mutex.release();
//         }

//     }

//     static class Philosopher extends Thread {
//         public int number;
//         public Chopstick leftchopstick;
//         public Chopstick rightchopstick;

//         Philosopher(int num, Chopstick left, Chopstick right) {
//             number = num;
//             leftchopstick = left;
//             rightchopstick = right;
//         }

//         @Override
//         public void run() {
//             while (true) {
//                 try {
//                     eatingSem.acquire(); // Acquire the permit to eat
//                     leftchopstick.grab();
//                     System.out.println("Philosopher " + (number + 1) + " grabs left chopstick.");
//                     rightchopstick.grab();
//                     System.out.println("Philosopher " + (number + 1) + " grabs right chopstick.");
//                     eat();
//                     leftchopstick.release();
//                     System.out.println("Philosopher " + (number + 1) + " releases left chopstick.");
//                     rightchopstick.release();
//                     System.out.println("Philosopher " + (number + 1) + " releases right chopstick.");
//                     eatingSem.release(); // Release the permit after eating
//                 } catch (InterruptedException e) {
//                     e.printStackTrace(System.out);
//                 }
//             }
//         }

//         void eat() {
//             try {
//                 int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
//                 System.out.println("Philosopher " + (number + 1) + " eats for " + sleepTime + "ms");
//                 Thread.sleep(sleepTime);
//             } catch (InterruptedException e) {
//                 e.printStackTrace(System.out);
//             }
//         }
//     }

//     public static void main(String args[]) {
//         for (int i = 0; i < philosopher; i++) {
//             chopsticks[i] = new Chopstick();
//         }
//         for (int i = 0; i < philosopher; i++) {
//             philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % philosopher]);
//             philosophers[i].start();
//         }
//         // No need to check for deadlock, the program will run indefinitely
//     }
// }


>>>>>>> d4378aa675a17f48404f6ca2c57fefb1eb2b2dac

class dining {
    static Chopstick choptsticks[] = new Chopstick[5];
    static Philosopher philosophers[] = new Philosopher[5];
    static Semaphore room = new Semaphore(4);
    static class Chopstick{
        Semaphore mutex = new Semaphore(1);

        void grab(){
            try{
                mutex.acquire();
            }catch(InterruptedException e){

            }
        }
        void put(){
            mutex.release();
        }
    }

    static class Philosopher extends Thread{
        public int num;
        public Chopstick left;
        public Chopstick right;
        public Philosopher(int num, Chopstick left, Chopstick right){
            this.num = num;
            this.left = left;
            this.right = right;
        }
        @Override
        public void run(){
            while(true){
                try{
                    room.acquire();
                    left.grab();
                    right.grab();
                    eat();
left.put();
right.put();

                    room.release();
                }catch(InterruptedException e){

                }
            }
        }

        public void eat(){
            try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0,1000);
            System.out.println("Philosopher "+ (num+1)+" eats for "+ sleepTime+ " ms");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
<<<<<<< HEAD
    }
    public static void main(String args[]){
        for(int i=0;i<5;i++){
            choptsticks[i] = new Chopstick();
        }
        for(int i=0;i<5;i++){
            philosophers[i] = new Philosopher(i, choptsticks[i], choptsticks[(i+1 % 5)]);
            philosophers[i].start();
        }
=======
>>>>>>> d4378aa675a17f48404f6ca2c57fefb1eb2b2dac
    }
    public static void main(String args[]){
        for(int i=0;i<5;i++){
            choptsticks[i] = new Chopstick();
        }
        for(int i=0;i<5;i++){
            philosophers[i] = new Philosopher(i, choptsticks[i], choptsticks[(i+1 % 5)]);
            philosophers[i].start();
        }
    }
}
