package Q36_数组中的逆序对;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/04/2020 19:02
 **/

public class FindReverseCount {
    public int find(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("Invalid input");
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return inversePairsCore(nums, copy, 0, nums.length - 1);
    }

    public int inversePairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }
        int mid = (start + end) / 2;
        int left = inversePairsCore(copy, nums, start, mid);
        int right = inversePairsCore(copy, nums, mid + 1, end);
        int i = mid;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= mid + 1) {
            if (nums[i] > nums[j]) {
                copy[indexCopy--] = nums[i--];
                count += j - mid;
            }else{
                copy[indexCopy--] = nums[j--];
            }
        }
        while(i >= start)
            copy[indexCopy--] = nums[i--];
        while(j > mid)
            copy[indexCopy--] = nums[j--];

        return count + left +right;
    }

    @Test
    void test(){
        Assertions.assertEquals(5,find(new int[]{7, 5, 6, 4}));
        Assertions.assertEquals(0,find(new int[]{4,5,6,7}));
    }
}
