class Worker implements Runnable{
    public void run(){
        System.out.println("Hello world from Worker thread");
    }
}

class Daemon implements Runnable{
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside the Daemon thread");
        }
    }
}

class NormalWorker implements Runnable{
    public void run(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Normal Thread finishes");
    }
}

public class DemoDaemonThread_3 {
    public static void main(String[] args) {

        //To set a thread as Daemon thread set setDaemon to true.

        // Thread t1 = new Thread(new Worker());
        // t1.setDaemon(true);
        // System.out.println(t1.isDaemon());

        //After 3s once the normal thread finishes execution it terminates the JVM thus terminating Daemon thread.

        Thread t1 = new Thread(new Daemon());
        Thread t2 = new Thread(new NormalWorker());
        t1.setDaemon(true);
        t2.setDaemon(false);
        t1.start();
        t2.start();
    }
}
