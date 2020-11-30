package Chapter12_数组和字符串.Q27_移除元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 22:26
 **/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        //双指针法,slow指向要删除的val元素，fast指向不需要删除的元素
        //最后交换，把所有要删除的元素移到数组末尾，返回slow作为数组长度
        while (fast < nums.length) {
            while (slow < nums.length) {
                if (nums[slow] != val) {
                    slow++;
                    continue;
                }
                break;
            }
            fast = slow;
            while (fast < nums.length && nums[fast] == val) {
                fast++;
            }
            if (fast == nums.length) {
                return slow;
            }
            nums[slow] = nums[fast];
            nums[fast] = val;
            fast++;
            slow++;
        }
        return slow;
    }
}
