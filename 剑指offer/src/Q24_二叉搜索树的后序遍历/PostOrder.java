package Q24_二叉搜索树的后序遍历;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/04/2020 19:53
 **/

public class PostOrder {
    public boolean verifyPostOrder(int[] nums, int start, int end){
        if(nums == null || nums.length == 0 || start < 0 || end >= nums.length)
            return false;

        int root = nums[end];

        int leftStart = start;
        int leftEnd;
        int rightStart;
        int rightEnd = end -1;
        while (start <= end - 1){
            if(nums[start] > root)
                break;
            start++;
        }
        leftEnd = start - 1;
        rightStart = start;
        while(start <= end - 1){
            if(nums[start] < root)
                return false;
            start++;
        }

        boolean left = true;
        boolean right = true;
        if(leftEnd > leftStart)
            left = verifyPostOrder(nums, leftStart , leftEnd);
        if(rightEnd > rightStart)
            right = verifyPostOrder(nums, rightStart, rightEnd);

        return  left && right;


    }

    @Test
    void test(){
        int[] correct = {5, 7, 6, 9, 11, 10, 8};
        int[] wrong = {7, 4, 6, 5};
        Assertions.assertTrue(verifyPostOrder(correct,0,correct.length-1));
        Assertions.assertFalse(verifyPostOrder(wrong,0,wrong.length-1));
        int[] w2 = {10, 12, 11, 8};
        Assertions.assertTrue(verifyPostOrder(w2,0,w2.length-1));
    }
}
