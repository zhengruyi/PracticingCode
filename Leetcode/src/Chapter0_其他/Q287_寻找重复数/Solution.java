package Chapter0_其他.Q287_寻找重复数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/12/2020 22:56
 **/

public class Solution {
    /**
     * 本方法需要读者对 「Floyd 判圈算法」（又称龟兔赛跑算法）有所了解，它是一个检测链表是否有环的算法，
     * 我们以下标i和nums[i]来构成图，由于存在重复的数字那么
     * 我们对 nums[] 数组建图，每个位置 ii 连一条 i→nums[i] 的边。
     * 由于存在的重复的数字 target，因此 target 这个位置一定有起码两条指向它的边，
     * 因此整张图一定存在环，且我们要找到的 target 就是这个环的入口，
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        //快指针每次走两步，慢指针每次走一步
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        //相遇后，慢指针回到开始，然后快慢指针每次走一步，那么他们再次相遇的点
        //就是环的入口，也就是所求的目标
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
