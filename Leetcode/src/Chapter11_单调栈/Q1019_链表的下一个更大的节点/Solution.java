package Chapter11_单调栈.Q1019_链表的下一个更大的节点;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 00:01
 **/

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack <Integer> stack = new Stack<>();
        List <Integer> list = new ArrayList <>();
        ListNode h1 = head;
        //将链表转化成数组
        while(h1 != null){
            list.add(h1.val);
            h1 = h1.next;
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            //单调栈来寻找下一个更大的元素，栈中存放的是元素的下标索引
            if(stack.isEmpty() || list.get(stack.peek()) >= list.get(i)){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)){
                    res[stack.pop()] = list.get(i);
                }
                stack.push(i);
            }
        }
        //未找到更大元素的值的元素，统一设置成0
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
