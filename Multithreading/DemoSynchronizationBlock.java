public class DemoSynchronizationBlock {
    public static int counter1 = 0;
    public static int counter2 = 0;
    public static void main(String[] args) {
        process();
    }

    public static void increment1(){
        synchronized(DemoSynchronizationBlock.class){
            counter1++;
        }
    }

    public static void increment2(){
        synchronized(DemoSynchronizationBlock.class){
            counter2++;
        }
    }

    private static void process() {
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i  =0;i<10000000;i++)
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
}
