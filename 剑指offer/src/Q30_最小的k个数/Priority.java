package Q30_最小的k个数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/04/2020 19:40
 **/

public class Priority {
    public static int[] findK(int[] nums, int k){
        if(k < 0 || nums == null || nums.length == 0 || k > nums.length)
            throw  new RuntimeException("Error");

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new UseComparator());
        for (int i = 0; i < nums.length; i++) {
            if(pq.size() < k)
                pq.add(nums[i]);
            else{
                if(nums[i] < pq.peek()){
                    pq.remove(pq.peek());
                    pq.add(nums[i]);
                }
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()){
          result[i] = pq.poll();
          i++;
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7,  6, 8, 3, 24, 12, 9, 1, -2, 1, 3};
        int[] result = findK(nums,5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


}
class UseComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}