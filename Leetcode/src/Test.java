import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        int[] nums = {1,2,5,9};
        smallestDivisor(nums,6);
    }

    public static void main(String[] args) {
        Integer[] tmp = {1,2,3};
        List<Integer> list = Arrays.asList(tmp);
    }
    public int smallestDivisor(int[] nums, int threshold) {
        long right = getDivison(nums,1) + 1;
        long left = 1;
        while(left < right){
            long mid = left + (right - left)/2;
            long res = getDivison(nums,mid);
            if(res > threshold){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int) left;
    }
    public long getDivison(int[] nums, long divide){
        long sum = 0;
        for(int num : nums){
            sum += Math.ceil(num / (divide*1.0d));
        }
        return sum;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}