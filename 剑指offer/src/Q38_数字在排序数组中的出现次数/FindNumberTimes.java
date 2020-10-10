package Q38_数字在排序数组中的出现次数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/04/2020 21:10
 **/

public class FindNumberTimes {
    public int findTimes(int[] nums, int n){
        if(nums == null || nums.length == 0)
            return 0;
        int start = 0;
        int end = nums.length - 1;
        int n1 = getFirstK(nums, n,start,end);
        int n2 = getLastK(nums, n, start, end);
        if( n1 == -1 || n2 == -1)
            return 0;
        else
            return n2 - n1 + 1;
    }

    public int getFirstK(int[] nums, int n , int start, int end){
        if(start > end)
            return -1;
        int mid  = (start + end) / 2;
        if(nums[mid] == n){
            if((mid > 0 && nums[mid-1] != n) || mid == 0)
                return mid;
            else
                end = mid - 1;
        }
        else if(nums[mid] > n)
            end = mid - 1;
        else{
            start = mid + 1;
        }

        return getFirstK(nums, n, start, end);
    }

    public int getLastK(int[] nums, int n, int start, int end){
        if(start > end)
            return -1;
        int mid  = (start + end) / 2;
        if(nums[mid] == n){
            if((mid < nums.length - 1 && nums[mid+1] != n) || mid == nums.length -1)
                return mid;
            else
                start = mid + 1;
        }
        else if(nums[mid] > n)
            end = mid - 1;
        else{
            start = mid + 1;
        }

        return getLastK(nums, n, start, end);
    }

    @Test
    void test(){
        int nums[] ={1, 2, 3, 3, 3, 3, 4, 5};
        Assertions.assertEquals(4, findTimes(nums,3));
        Assertions.assertEquals(1,findTimes(nums,2));
        Assertions.assertEquals(0,findTimes(nums,11));
    }
}
