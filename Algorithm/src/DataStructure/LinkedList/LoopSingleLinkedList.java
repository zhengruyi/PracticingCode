package DataStructure.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/07/2019 14:16
 **/

public class LoopSingleLinkedList {
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = this;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = new Node(0);
    private Node tail = head;

    public void insert(int location, int data) {
        int length = head.getData();
        if (location < 1 || location > length + 1)
            throw new RuntimeException("Location is illegal");
        int i = 1;
        Node before = head;
        Node newTarget = new Node(data);
        while (i < location) {
            i++;
            before = before.getNext();
        }
        // if the location is the tail of list, update the Node tail
        if (location == length + 1) {
            this.tail = newTarget;
        }

        newTarget.setNext(before.getNext());
        before.setNext(newTarget);
        head.setData(head.getData() + 1);
    }

    public int delete(int location) {
        int length = head.getData();
        if (length == 0)
            throw new RuntimeException("LinkedList is empty");
        if (location < 1 || location > length)
            throw new RuntimeException("Location is illegal");
        int i = 1;
        Node before = head;
        while (i < location) {
            i++;
            before = before.getNext();
        }

        Node data = before.getNext();
        before.setNext(before.getNext().getNext());
        head.setData(head.getData()- 1);
        return data.getData();
    }

    @Override
    public String toString() {
        Node p = head.getNext();
        while (p != null) {
            System.out.println(p.getData());
            p = p.getNext();
        }
        System.out.println("length= " + head.getData());
        System.out.println("-----------");
        return "";
    }


    public static void main(String[] args) {
        LoopSingleLinkedList list = new LoopSingleLinkedList();
        for (int i = 1; i <= 10; i++)
            list.insert(i, i);
        list.delete(4);
        list.delete(5);
        System.out.println(list);
    }
}
