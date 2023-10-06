public class RunnableExampleInterrupt implements Runnable{
    private String threadName;
    public RunnableExampleInterrupt(String threadName){
        this.threadName = threadName;
    }
    public void run() {
        for (int i=0; i<50; i++){
            try{
                Thread.sleep(100);
                System.out.println(this.threadName+":"+i+"; ");
            }
            catch (InterruptedException e){
                System.out.println("I was interrupted!");
                return;
            }
        }
    }
}
