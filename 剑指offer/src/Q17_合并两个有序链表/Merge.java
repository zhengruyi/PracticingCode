package Q17_合并两个有序链表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/04/2020 12:58
 **/

public class Merge {
    public static Node mergeSortedLinkdList(Node h1, Node h2) {
        Node head;
        Node next;

        if (h1 == null)
            return h2;
        else if (h2 == null)
            return h1;
        else {
            head = h1.value <= h2.value ? h1 :h2;
            next = head;
            if(next == h1) h1 = h1.next; else h2 = h2.next;

        }
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                next.next = h2;
                next = h2;
                h2 = h2.next;
            } else if (h2 == null) {
                next.next = h1;
                next = h1;
                h1 = h1.next;
            } else {
                next.next = h1.value < h2.value ? h1 : h2;
                next = next.next;
                if(next == h1) h1 = h1.next; else h2 = h2.next;
            }
        }
        return head;

    }

    static void print(Node head){
        while (head != null){
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n4 = new Node(7, null);
        Node n3 = new Node(5, n4);
        Node n2 = new Node(3, n3);
        Node n1 = new Node(1, n2);

        Node m4 = new Node(8, null);
        Node m3 = new Node(6, m4);
        Node m2 = new Node(4, m3);
        Node m1 = new Node(2, m2);
        Node head = mergeSortedLinkdList(m1,n1);
        print(head);
        //Node h1 = mergeSortedLinkdList(m1,null);
        //print(h1);
        //Node h2 = mergeSortedLinkdList(null,n1);
        //print(h2);
        Node s1 = new Node(5,null);
        Node s2 = new Node(6,null);
        Node h3 = mergeSortedLinkdList(s1,s2);
        print(h3);
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
