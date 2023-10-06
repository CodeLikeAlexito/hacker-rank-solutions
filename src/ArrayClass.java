class ArrayClass{
    int[] arr;
    public ArrayClass(){
        this.arr = new int[200];
        for(int i=this.arr.length-1; i>=0; i--){
            this.arr[i] = i;
        }
    }
    public synchronized void changeArray(){
        for(int i=0; i<this.arr.length; i++){
            this.arr[i] = (int)Math.round(Math.random()*100);
        }
        System.out.println("Change finished");
    }
    public synchronized void sortArray(){
        java.util.Arrays.sort(this.arr);
        System.out.println("Sort finished");
    }
    public void showArray(){
        for(int i: this.arr){
            System.out.print(i+" ");
        }
    }
}