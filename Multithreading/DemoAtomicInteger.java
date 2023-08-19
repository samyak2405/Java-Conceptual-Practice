import java.util.concurrent.atomic.AtomicInteger;

public class DemoAtomicInteger {
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
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
        System.out.println("Counter: "+counter);
    }
    public static void increment(){
        for(int i = 0;i<1000000;i++)
            counter.getAndIncrement();
    }
}
