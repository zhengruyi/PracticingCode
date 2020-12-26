import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[start]){
                if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    if(target >= nums[start]){
                        right = mid - 1;
                    }else{
                        left = mid+1;
                    }
                }
            }else{
                if(nums[mid] < target){
                    if(target <= nums[end]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }else{
                    left = mid + 1;
                }
            }
        }
        return  -1;
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[] nums = {4,5,6,7,0,1,2};
        search(nums,0);
    }

    public static void main(String[] args) {
        int i = 5;
        while (i > 0) {
            i -= lowbit(i);
            System.out.println(i);
        }

    }
    public static int lowbit(int x) {
        // 等价：x & (~x +1)
        return x & (-x);
    }

}
