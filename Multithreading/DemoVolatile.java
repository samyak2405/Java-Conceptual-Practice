class Worker implements Runnable{
    //It will be stored in the main memory
    private volatile boolean terminated;

    public void run(){
        while(!terminated){
            System.out.println("Working class is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated(){
        return terminated;
    }

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }
}

public class DemoVolatile {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");
    }
}
