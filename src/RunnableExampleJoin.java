public class RunnableExampleJoin implements Runnable{
    private String threadName;
    // Вече нишката е член-променлива на класа
    Thread T;
    public RunnableExampleJoin(String threadName){
        this.threadName = threadName;
        // Инициализираме нишката вътре в конструктора
        this.T = new Thread(this, this.threadName);
    }
    public void run() {
        for (int i=0; i<10; i++){
            try{
                // Нарочно слагаме произволно време за "заспиване"
                Thread.sleep((int)Math.random()*1000);
                System.out.print(this.threadName+":"+i+"; ");
            }
            catch (InterruptedException e){
                return;
            }
        }
        System.out.println("\nThread "+this.threadName+ "finished!");
    }
}
