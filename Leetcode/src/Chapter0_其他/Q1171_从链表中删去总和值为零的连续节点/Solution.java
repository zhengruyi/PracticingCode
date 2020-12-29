package Chapter0_其他.Q1171_从链表中删去总和值为零的连续节点;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:09
 **/

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap <>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int sum = 0;
        //第一遍遍历，按照从起点到现在的和来安排节点,由于put自带的更新特性
        //只会保留最后一次出现的节点
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            //即使开头就是和为0的部分，也会因为dummy节点的存在顺利运行
            //不然的话会出现Bug
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}