package Chapter0_其他.Q708_循环有序列表的插入;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/03/2021 22:44
 **/

public class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }
        Node pointer = head;
        boolean flag = true;
        while(pointer != head || flag){
            flag = false;
            //找到了插入位置
            if(pointer.val <= insertVal && insertVal <= pointer.next.val){
                addNode(pointer,insertVal);
                return head;
                //插入的值是列表最大挥着最小时触发
            }else if(pointer.next.val < pointer.val && (insertVal >= pointer.val || insertVal <= pointer.next.val)){
                addNode(pointer,insertVal);
                return head;
            }
            pointer = pointer.next;
        }
        //在列表只有一个节点时会遇到这种情况
        addNode(pointer,insertVal);
        return head;
    }
    public Node addNode(Node pointer, int insertVal){
        Node tmp = new Node(insertVal);
        tmp.next = pointer.next;
        pointer.next = tmp;
        return  pointer;
    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}