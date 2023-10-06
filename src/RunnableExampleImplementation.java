public class RunnableExampleImplementation implements Runnable {
    private boolean isInterrupted;
    String threadName;

    public RunnableExampleImplementation(String threadName) {
        this.threadName = threadName;
        this.isInterrupted = false;
    }

    public void interrupt() {
        this.isInterrupted = true;
    }

    private void stopMsg() {
        System.out.println("I was interrupted!");
    }

    public void run() {
        while (this.isInterrupted == false) {
            try {
                Thread.sleep(1);
                double time = System.currentTimeMillis();
                while (System.currentTimeMillis() - time < 5000 && this.isInterrupted == false) {
                    System.out.print(".");
                }
                System.out.println();
            } catch (InterruptedException e) {
                this.stopMsg();
                return;
            }
        }
        stopMsg();
    }
}
