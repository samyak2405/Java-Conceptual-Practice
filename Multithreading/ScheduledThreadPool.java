import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable{
    public void run(){
        System.out.println("Updating and downloading stock related data from web...");
    }
}
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);

                //Shutdown the executor otherwise it won't terminated.
        //We prevent the executor to execute any further tasks

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        //Terminate actual (running) tasks
        try{
            if(!executorService.awaitTermination(10000, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
                
        }catch(InterruptedException e){
            executorService.shutdownNow();
        }
    }
}
