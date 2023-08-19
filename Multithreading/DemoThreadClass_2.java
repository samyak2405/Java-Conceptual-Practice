

class Runner1 extends Thread{
    @Override
    public void run()
    {
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

class Runner2 extends Thread{
    @Override
    public void run()
    {
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

public class DemoThreadClass_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();
    }
}
