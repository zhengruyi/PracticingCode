package Q33_把数组排成最小的数字;


import java.util.ArrayList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/04/2020 21:03
 **/

public class MinimumNumber {
    public static void combineMin(int[] nums){
        if(nums == null || nums.length == 0)
            return ;
        ArrayList<String> list = new ArrayList <>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        quickSort(list,0, nums.length-1);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            buffer.append(list.get(i));
        }
        System.out.println(buffer.toString());
    }

    public static void quickSort(ArrayList<String> list, int start, int end){
        if(start >= end)
            return ;
        int mid = partition(list, start, end);
        quickSort(list,start,mid);
        quickSort(list,mid+1,end);
    }

    public static int partition(ArrayList<String> list, int start, int end){
        String threshold = list.get(start);
        while(start < end){
            while(compare(list.get(end), threshold) && start < end)
                end --;
            if(end > start){
                list.set(start,list.get(end));
                start++;
            }
            while (!compare(list.get(start),threshold) && start < end)
                start++;
            if(start < end){
                list.set(end,list.get(start));
                end -- ;
            }
        }
        list.set(start, threshold);
        return start;
    }

    public static boolean compare(String s1, String s2){
        return  s1.concat(s2).compareTo(s2.concat(s1)) >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,32,321};
        combineMin(nums);
        nums = new int[]{1,1,3,4,5};
        combineMin(nums);
        nums = new int[]{5};
        combineMin(nums);
    }
}
