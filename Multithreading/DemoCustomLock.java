/**
 * DemoCustomLock
 * This solves the problem of intrinsic lock.
 * We cannot use intrinsic lock if their are multiple independent methods in a class 
 * because their is just a single intrinsic lock associate with object or class in java
 * 
 */
public class DemoCustomLock {

    public static int counter1 = 0;
    public static int counter2 = 0;

    //Here we have created our custom object to lock synchronized block.
    //1st thread is going to lock on lock1 and 2nd thread is going to lock
    //on lock2.
    //This ensure that Independent methods can be executed at the same time by independent threads.
    
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1(){
        synchronized(lock1){
            counter1++;
        }
    }

    public static synchronized void increment2(){
        synchronized(lock2){
            counter2++;
        }
    }

    public static void process(){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i = 0;i<10000000;i++)
                    increment1();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i = 0;i<10000000;i++)
                    increment2();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter1: "+counter1);
        System.out.println("Counter2: "+counter2);
    }

    public static void main(String[] args) {
        process();
    }
}