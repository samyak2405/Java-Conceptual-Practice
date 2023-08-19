import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoLiveLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    private void worker1(){
        while(true){
            try {
                lock1.tryLock(50,TimeUnit.MILLISECONDS);
                System.out.println("Worker 1 acquries the lock1...");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            System.out.println("Worker1 tries to get the lock2...");
            if(lock2.tryLock()){
                System.out.println("Worker1 acquires the lock2...");
                lock2.unlock();
            }
            else{
                System.out.println("Worker1 cannot acquire lock2...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    private void worker2(){
        while(true){
            try {
                lock2.tryLock(50,TimeUnit.MILLISECONDS);
                System.out.println("Worker 2 acquries the lock2...");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            System.out.println("Worker2 tries to get the lock1...");
            if(lock1.tryLock()){
                System.out.println("Worker2 acquires the lock1...");
                lock1.unlock();
            }
            else{
                System.out.println("Worker2 cannot acquire lock1...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }


    public static void main(String[] args) {
        DemoLiveLock liveLock = new DemoLiveLock(); 
        new Thread(liveLock::worker1,"worker1").start();
        new Thread(liveLock::worker2,"worker2").start();   
    }
}
