package Chapter8_数组和矩阵问题.Q4_找到无序数组中最小的k个数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/06/2020 13:07
 **/

public class FindMinimumK {
    /**
     * 采用堆来找出最小的k个数字，时间复杂度NLogK,空间复杂度为O(1)
     * @param arr
     * @param k
     * @return
     */
    public static int[] getMiniKNumberByHeap(int[] arr, int k){
        if(k < 1 || k > arr.length){
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap,arr[i],i);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < kHeap[0]){
                kHeap[0] = arr[i];
                heapify(kHeap,0,k);
            }
        }
        return kHeap;
    }
    public static void heapInsert(int[] arr, int value, int index){
        arr[index] = value;
        while (index != 0){
            int parent = (index -1)/2;
            if(arr[parent] < arr[index]){
                swap(arr,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 +1;
        int right = index * 2 +1;
        int largest = index;
        while (left < heapSize){
            if(arr[left] > arr[index]){
                largest = left;
            }
            if(right < heapSize && arr[right] > arr[largest]){
                largest = right;
            }
            if(largest != index){
                swap(arr,largest,index);
            }else{
                break;
            }
            index = largest;
            left = index * 2 +1;
            right = index *2 +2;
        }
    }
    public static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,53,2,4,435,235,23,1,23,452,334,5,21};
        int[] result = getMiniKNumberByHeap(nums,4);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
