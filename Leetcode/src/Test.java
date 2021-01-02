import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public int longestWPI(int[] hours) {
        int[] score = new int[hours.length];
        for(int i = 0; i < hours.length; i++){
            score[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] preSum = new int[hours.length+1];
        for(int i =1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + score[i-1];
        }
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < preSum.length; i++){
            if(stack.isEmpty() || preSum[i] < preSum[stack.peek()]){
                stack.push(i);
            }
        }
        int res = 0;
        int i = preSum.length -1;
        while(i > res){
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]){
                res = Math.max(res, i - stack.peek());
                stack.pop();
            }
            i--;
        }
        return res;
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[] nums = {9,9,6,0,6,6,9};
        longestWPI(nums);
    }

    public static void main(String[] args) {
        System.out.println((char)('b'+'A' - 'a'));
        System.out.println('A' - 'a');
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}