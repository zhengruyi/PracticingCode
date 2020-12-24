import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
    @org.junit.jupiter.api.Test
    void test(){
        triangleNumber(new int[]{2,2,3,4});
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
