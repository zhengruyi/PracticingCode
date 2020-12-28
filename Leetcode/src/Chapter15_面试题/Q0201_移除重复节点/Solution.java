package Chapter15_面试题.Q0201_移除重复节点;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 23:28
 **/

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        Set <Integer> set = new HashSet <>();
        //利用集合去重，很简单的方式
        while(head!= null){
            if(!set.contains(head.val)){
                set.add(head.val);
                pre.next = head;
                pre = head;
            }
            head = head.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
