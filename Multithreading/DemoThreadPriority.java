class Worker implements Runnable{
    public void run()
    {
        for(int i = 0;i<5;i++)
            System.out.println("Worker thread: "+i);
    }
}

public class DemoThreadPriority {
    public static void main(String[] args) {
        //In this case the Priority of main thread and worker thread is same
        //Hence they are implemented in FCFS manner.
        // Thread t1 = new Thread(new Worker());
        // t1.start();
        // System.out.println("Main thread");

        /**
         * In the below code we have set the worker thread priority to max hence in here worker thread executes first then
         * main thread will execute.
         */

        Thread t2 = new Thread(new Worker());
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        System.out.println("Worker thread priority: "+t2.getPriority());
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
        System.out.println("Main thread");
    }   
}
