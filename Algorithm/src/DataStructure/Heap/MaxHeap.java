package DataStructure.Heap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/08/2019 23:03
 **/

public class MaxHeap {
    private int  count;
    private int[] array;
    private int capacity;

    public MaxHeap(int size) {
        array= new int[size+1];
        this.capacity=size;
        count=0;
    }


    public void add(int e){
        count++;
        array[count]=e;
        heapfyTail();

    }



    public int remove(){
        int e=array[1];
        array[1]=array[count];
        count--;
        heapfyTop();
        return e;
    }



    private void heapfyTop(){
        int i=1;
        int pos=1;
        while(true){
            i=pos;

            if(2*i<=count && array[i]<array[2*i])
                pos=2*i;

            if(2*i+1<=count&&array[pos]<array[2*i+1])
                pos=2*i+1;

            if(pos==i)
                break;

            swap(i,pos);


        }
    }


    private void heapfyTail(){
        int i=count;
        while(i/2>0&&array[i]>array[i/2]){
            swap(i,i/2);
            i=i/2;
        }
    }

    private void swap(int i, int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }


    @Override
    public String toString() {
        String result=" ";
        for(int i=1; i<=count;i++){
            result+=array[i]+" ";
        }
        return result;
    }

    public static void main(String[] args) {
        int [] a= {1,7,9,2,5,3,4,8,6,14,21,43,67};
        MaxHeap heap =new MaxHeap(13);
        for(int b :a){
            heap.add(b);
        }
        System.out.println(heap.toString());

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.toString());
        heap.add(32);
        heap.add(52);
        heap.add(42);
        System.out.println(heap.toString());

    }

}
