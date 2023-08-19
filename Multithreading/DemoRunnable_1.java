/**
 * DemoRunnable: Implement the Runnable Interface which overrides the run()
 * method
 * and whatever is defined in the run() method that is going to be executed by
 * given thread.
 * There are two ways to implement Runnable interface.
 */

// Method 1

// class Runner1 implements Runnable{
// @Override
// public void run() {
// for(int i = 0;i<10;i++)
// System.out.println("Runner1: "+i);
// }
// }

// class Runner2 implements Runnable{
// @Override
// public void run() {
// for(int i = 0;i<10;i++)
// System.out.println("Runner2: "+i);
// }
// }

public class DemoRunnable_1{

    public static void printSeqeunce(int x) {
        for (int i = 0; i < 10; i++)
            System.out.println("Runner"+x+": " + i);
    }

    public static void main(String[] args) {

        /* Achieve Multithreading */

        // Thread t1 = new Thread(new Runner1());
        // Thread t2 = new Thread(new Runner2());

        // Method 2 Using Anonymous Inner class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printSeqeunce(1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printSeqeunce(2);
            }
        });

        t1.start();
        t2.start();
    }
}