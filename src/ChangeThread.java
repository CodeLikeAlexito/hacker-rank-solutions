class ChangeThread implements Runnable {
    private String threadName;
    ArrayClass arr;
    Thread T;
    public ChangeThread(String threadName, ArrayClass arr){
        this.threadName = threadName;
        this.arr = arr;
        this.T = new Thread(this, this.threadName);
    }
    public void run() {
        arr.changeArray();
    }
}