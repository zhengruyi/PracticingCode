package Chapter0_其他.Q707_设计链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/01/2021 22:08
 **/

public class MyLinkedList {
    ListNode dummy;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.dummy = new ListNode(-1);
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        int step = 0;
        ListNode curr = dummy;
        //这里是等于号因为要指向当前节点
        while(step <= index){
            curr = curr.next;
            step++;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        ListNode tmp = new ListNode(val);
        int step = 0;
        ListNode pre = dummy;
        //这里是小于号因为要定位到index对应节点的前一个节点
        while(pre.next != null && step < index){
            pre = pre.next;
            step++;
        }
        tmp.next = pre.next;
        pre.next = tmp;
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        int step = 0;
        ListNode pre = dummy;
        while(step < index){
            pre = pre.next;
            step++;
        }
        pre.next = pre.next.next;
        this.size--;
    }
}
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
