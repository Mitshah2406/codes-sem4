import java.util.Scanner;
import java.util.concurrent.Semaphore;

//release ->signal
//acquire ->wait


class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Buffer b=new Buffer(2);
        new Producer(b);
        new Consumer(b);
     
    }
    
}

class Buffer{
    Semaphore empty;
    Semaphore full;
    Semaphore S;  //mutex
    int in,out,size;
    int buffer[];

    Buffer(int size){
        this.size=size;
        in=0;
        out=0;
        empty=new Semaphore(size);
        full =new Semaphore(0);
        S=new Semaphore(1);
        buffer=new int[size];
    }

    void put(int item){
        try{
            if (empty.availablePermits() == 0) {
                System.out.println("Cannot produce. Buffer is full.");
                return;
            }
            empty.acquire();
        }catch(InterruptedException e){
            System.out.println("Interrupted!");
        }

        try{
            S.acquire();
        }catch(InterruptedException e){
            System.out.println("Interrupted!");
        }
        buffer[in]=item;
        System.out.println("Produced produced item "+item);
        in=(in+1)%size;
        printBuffer();
        S.release();
        full.release();
    }

    void get(){
        try{
            if (full.availablePermits() == 0) {
                System.out.println("Cannot consume. Buffer is empty.");
                return;
            }

            full.acquire();
        }catch(InterruptedException e){
            System.out.println("Interrupted!");
        }

        try{
            S.acquire();
        }catch(InterruptedException e){
            System.out.println("Interrupted!");
        }
        System.out.println("Consumed produced item "+buffer[out]);
        buffer[out]=0;
        out=(out+1)%size;
        printBuffer();
        S.release();
        empty.release();
    }

    void printBuffer(){
        System.out.println("Buffer: ");
        for(int i=0;i<size;i++){
            System.out.print(buffer[i]+" ");
        }
        System.out.println();
    }

}


class Producer implements Runnable{

    Buffer b;
    Producer(Buffer b){
        this.b=b;
        new Thread(this, "Producer").start();
    }
    @Override
    public void run(){
        try{
for(int i=1;i<=5;i++){
            b.put(i);
            Thread.sleep(1000);
        }
        }catch(Exception e){

        }
        
    }
}

class Consumer implements Runnable{
    Buffer b;
    Consumer(Buffer b){
        this.b=b;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run(){
         try{
for(int i=1;i<=5;i++){
            b.get();
            Thread.sleep(1000);
        }
        }catch(Exception e){

        }
    }
}