/**
 * DemoSynchronization1: In this application problem arises when 1st thread call increment1 then it acquires intrinsic lock of the class
 * that means the second thread will not be able to implement the independent increment2 method of the class because thread 1 has acquired the
 * lock. Hence using multithreading here is going to make application slower.
 */
public class DemoSynchronization1 {

    public static int counter1 = 0;
    public static int counter2 = 0;
    //because DemoSynchronization1 has a single lock: this is why the methods cannot be 
    //executed at the same time.
    public static synchronized void increment1(){
        counter1++;
    }

    public static synchronized void increment2(){
        counter2++;
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
        System.out.println("The counter is: "+counter1);
        System.out.println("The counter is: "+counter2);
    }

    public static void main(String[] args) {
        process();
    }
}