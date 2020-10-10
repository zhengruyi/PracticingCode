package Q16_翻转链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 22:57
 **/

public class ReverseLinkedList {
    public static Node reverse(Node head) {
        print(head);
        if (head == null)
            return null;
        else if (head.next == null)
            return head;
        else {
            Node front = head;
            Node mid = head.next;
            Node back = mid.next;
            front.next = null;
            while (mid != null) {
                mid.next = front;
                front = mid;
                mid = back;
                if(back != null)
                    back = back.next;
            }
            print(front);
            return front;
        }
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node n4 = new Node(4, null);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        reverse(n1);
        reverse(n1);
        reverse(null);
    }


}

class Node {
    public Node next;
    public int value;

    public Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }
}
