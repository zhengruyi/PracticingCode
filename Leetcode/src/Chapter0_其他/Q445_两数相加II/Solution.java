package Chapter0_其他.Q445_两数相加II;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/12/2020 16:12
 **/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //两个解决方案，可以分别把两个链表反转，然后对两个链表求和
        //第二种就是在不破坏原链表的情况下，可以用栈来完成反转的目的，然后对栈顶元素相加来求和
        Stack <Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode root = null;
        ListNode head = null;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int x1 = 0;
            if(!st1.isEmpty()){
                x1 = st1.pop();
            }
            int x2 = 0;
            if(!st2.isEmpty()){
                x2 = st2.pop();
            }
            int val = x1 + x2 + carry;
            carry = val /10;
            if(root == null){
                root = new ListNode(val % 10);
                head = root;
            }else{
                head = new ListNode(val%10);
                head.next = root;
                root = head;
            }
        }
        //最后要特已处理一下进位的问题，防止出现88+99 = 00的情况
        if(carry != 0){
            head = new ListNode(carry);
            head.next = root;
            root = head;
        }
        return root;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
