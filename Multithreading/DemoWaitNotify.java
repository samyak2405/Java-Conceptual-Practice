/**
 * DemoWaitNotify
 * t1 and t2 cannot be excuted at the same time because every single object in java has a single intrinsic lock.
 * If one of the synchronize blocks acquire the intrinsic lock than other threads have to wait for running other synchronized blocks because there is a just a single intrinsic lock.
 * 
 * 
 */

class Process{
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Running the produce method...");
            wait(); // Producer waits until consume notifes.
            System.out.println("Again in the producer method...");
        }
    }
    public void consume() throws InterruptedException{
        Thread.sleep(1000);
        synchronized(this){
            System.out.println("Consume method is executed...");
            notify(); //consumer notifies the producer that it can acquire the lock now.
        }
    }
}

public class DemoWaitNotify {

    public static void main(String[] args) {
        Process process = new Process();
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}