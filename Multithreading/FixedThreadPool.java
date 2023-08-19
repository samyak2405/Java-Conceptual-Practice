import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
    private int id;
    public Task(int id){
        this.id = id;
    }
    public void run(){
        System.out.println("Task with id "+id+" is in work - thread id"+Thread.currentThread().getId());
        long duration = (long)(Math.random()*5);
        try{
            TimeUnit.SECONDS.sleep(duration);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

public class FixedThreadPool {
    public static void main(String[] args) {
        //It is a single thread that will execute the tasks sequentially
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0;i<100;i++)
            executor.execute(new Task(i+1));
        //Shutdown the executor otherwise it won't terminated.
        //We prevent the executor to execute any further tasks

        executor.shutdown();

        //Terminate actual (running) tasks
        try{
            if(!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                // executor.shutdownNow();
            }
                
        }catch(InterruptedException e){
            executor.shutdownNow();
        }
    }
}
