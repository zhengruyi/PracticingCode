package Q12_合并两个排序的链表;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 20:33
 **/

public class MergeSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            head = l1.val < l2.val ? l1 : l2;
            if (l1.val < l2.val) {
                head.next = mergeTwoLists(l1.next, l2);
            } else {
                head.next = mergeTwoLists(l1, l2.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n2 = new ListNode(2,n4);
        ListNode n3 = new ListNode(3,n5);
        ListNode l1 = new ListNode(1,n3);
        ListNode l2 = new ListNode(1,n2);
        ListNode head = mergeTwoLists(l1,l2);
        while (head != null){
            System.out.print(head.val);
            head = head.next;
        }

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}