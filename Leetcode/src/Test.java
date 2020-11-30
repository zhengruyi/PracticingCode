import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        loop:
        while(fast < nums.length){
            while(slow < nums.length){
                if(nums[slow] != val){
                    slow++;
                    continue;
                }
                break;
            }
            fast = slow;
            while(nums[fast] == val && fast < nums.length){
                fast++;
            }
            nums[slow] = nums[fast];
            nums[fast] = val;
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {4,5};
        removeElement(nums,4);
    }
}
