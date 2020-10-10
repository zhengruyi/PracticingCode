package Q9_两数相加;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 15:50
 **/

public class GetSum {
    /*
    难点在于要考虑全部情况
    leetcode : https://leetcode-cn.com/problems/add-two-numbers/submissions/
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp;
        temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 == null){
                int num = (l2.val+ carry)%10;
                carry = (l2.val+ carry) / 10;
                temp.next = new ListNode(num);
                l2 = l2.next;
            }else if(l2 == null){
                int num = (l1.val + carry)%10;
                carry = (l1.val + carry) / 10;
                temp.next = new ListNode(num);
                l1 = l1.next;
            }else{
                int num = (l1.val + l2.val+ carry)%10;
                carry = (l1.val + l2.val+ carry) / 10;
                temp.next = new ListNode(num);
                l1 = l1.next;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
