package Q15_调整数组顺序使奇数位于偶数前面;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/05/2020 10:18
 **/

public class SortArray {
    public static void sort(int[] array){
        if(array.length == 0)
            return;

        int start = 0;
        int end = array.length - 1;
        while(start < end){

            while (array[end] % 2 == 0 && start < end)
                end --;

            while(array[start] % 2 == 1 && start < end)
                start++;
            if(start < end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
