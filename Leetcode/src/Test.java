import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test(){
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        search(arr,5);
    }
    public int search(int[] arr, int target) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            if(arr[left] == target){
                return left;
            }
            int mid = left + (right - left) /2;
            if(arr[mid] == target){
                right = mid;
            }else if(arr[left] < arr[mid]){
                if(arr[left] <= target && target <= arr[mid]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }else if(arr[mid] < arr[right]){
                if(arr[mid] <= target && target <= arr[right]){
                    left = mid;
                }else{
                    right = mid -1;
                }
            }else{
                left++;
            }
        }
        return -1;
    }

}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}