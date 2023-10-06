class RunnableExample implements Runnable {
    private String threadName;
    public RunnableExample(String threadName){
        this.threadName = threadName;
    }
    public void run() {
        for (int i=0; i<10; i++){
//            System.out.print(this.threadName+":"+i+"; ");
            try{
                Thread.sleep(1000);
                System.out.print(this.threadName+":"+i+"; ");
            }
            catch (InterruptedException e){
                return;
            }
        }
    }
}