package Chapter0_其他.Q817_链表组件;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/02/2021 18:04
 **/

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashMap<Integer,Integer> map = new HashMap <>();
        //统计出现次数
        for(int num : G){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count = 0;
        int res = 0;
        while(head != null){
            //如果链表的值没出现在链表中,说明上一个链表组件已经结束,所以加上count
            if(!map.containsKey(head.val)){
                res += count;
                count = 0;
            }else{
                //当前值出现在G中,说明当前链表节点就是一个链表组件
                count = 1;
            }
            head = head.next;
        }
        //防止最后一个链表节点出现在G中，而没有被统计到,所以最后加上count
        res += count;
        return res;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}