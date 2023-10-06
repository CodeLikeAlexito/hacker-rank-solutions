class SortThread implements Runnable {
    private String threadName;
    ArrayClass arr;
    Thread T;
    public SortThread(String threadName, ArrayClass arr){
        this.threadName = threadName;
        this.T = new Thread(this, this.threadName);
        this.arr = arr;
    }
    public void run(){
        arr.sortArray();
    }
}