class runner1 implements Runnable{
    public void run(){
        for(int i = 0;i<10;i++)
        {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Runner1: "+i);
        }
    }
}

class runner2 implements Runnable{
    public void run(){
        for(int i = 0;i<10;i++)
        {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Runner2: "+i);
        }
    }
}

public class DemoJoinMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(new runner1());
        Thread t2 = new Thread(new runner2());
        
        /**
         * Java executes line 1, line 2 and line 3 in sequential manner as line 1 and line 2 will take time it executed line 3
         * but that should not be happening, line 3 should execute after line 1 and line 2 code finishes. To ensure that we use join() method
         */
        // t1.start(); //Line 1
        // t2.start(); //Line 2
        // System.out.println("After Finishing Thread Execution"); //Line 3

        /**
         * In this snippet java will wait till 1st thread completes it's execution
         */
        // t1.start();
        // t2.start();
        // try{
        //     t1.join();
        // }catch(InterruptedException e)
        // {
        //     e.printStackTrace();
        // }
        // System.out.println("After finishing Thread Execution");

        /**
         * In this snippet java will wait till All threads completes it's execution
         */
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("After finishing Thread Execution");
    }
}
