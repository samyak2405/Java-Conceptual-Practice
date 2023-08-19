import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);

    public void download(){
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            // TODO: handle 
            e.printStackTrace();
        }finally{
            semaphore.release();
        }
    }
    private void downloadData(){
        try {
            System.out.println("Downloading data from the web...");
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}

public class DemoSemaphores {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0;i<12;i++){
            service.execute(new Runnable(){
                public void run(){
                    Downloader.INSTANCE.download();
                }
            });
        }
    }
}
