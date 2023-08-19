import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Processor implements Callable<String>{

    private int id;

    public Processor(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        Thread.sleep(3000);
        return "ID: "+id;
    }
    
}

public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>();
        for(int i = 0;i<5;i++)
        {
           Future<String> futures = executorService.submit(new Processor(i+1));
           list.add(futures);
        }

        list.stream().forEach(f->{
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

        //Terminate actual (running) tasks
        try{
            if(!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                // executor.shutdownNow();
            }
                
        }catch(InterruptedException e){
            executorService.shutdownNow();
        }
    }
}
