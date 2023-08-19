public class DemoSynchronization {

    public static int counter = 0;

    /*We have to make sure this method is executed only by a single thread at a time */
    public static synchronized void increment(){
        counter++;
    }

    public static void process(){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i = 0;i<10000000;i++)
                    increment();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i = 0 ;i<10000000;i++)
                    increment();
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("The Counter is: "+counter);
    }

    public static void main(String[] args) {
        /** When we run the process method without synchronization then
        * The result of counter which is supposed to count the total number
        * of times loops run will give wrong output. This failure is because
        * their is only one counter variable and both t1 and t2 threads are 
        * trying to access it simultaneously.*/

        // process();

        //With the help of synchronization we can ensure mutual exclusion.
        process();

    }
}
