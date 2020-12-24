import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length -1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            boolean isEven = (hi - mid) % 2 != 0;
            if(nums[mid + 1] == nums[mid]){
                if(isEven){
                    hi = mid - 1;
                }else{
                    lo = mid + 2;
                }
            }else if(nums[mid] == nums[mid-1]){
                if(!isEven){
                    lo  = mid + 1;
                }else{
                    hi = mid -2;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[lo];
    }
    @org.junit.jupiter.api.Test
    void test(){
        singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
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
