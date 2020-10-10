package DataStructure.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/07/2019 19:39
 * problem not solve
 **/

public class StaticLinkedList {
    class Node {
        private int data;
        private int next;

        public Node(int data, int next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }
    }

    private int MAX_SIZE;
    private int length = 0;
    private Node[] list;

    public StaticLinkedList(int length) {
        this.MAX_SIZE = length;
        list = new Node[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE - 1; i++)
            list[i] = new Node(0, i + 1);
        list[MAX_SIZE - 1] = new Node(0, 0);
    }

    public void insert(int location, int data) {
        if (location < 1 || location > length + 1)
            throw new RuntimeException("location is illegal");
        int freeLocation = getFree();

        if (freeLocation > 0) {
            list[freeLocation].setData(data);
            int before = MAX_SIZE - 1;
            for (int i = 1; i < location; i++)
                before = list[before].getNext();

            list[freeLocation].setNext(list[before].getNext());
            list[before].setNext(freeLocation);
            length++;
        } else
            throw new RuntimeException("Array is full");
    }

    private int getFree() {
        int location = list[0].getNext();
        if (location > 0)
            list[0].setNext(list[location].getNext());

        return location;
    }

    public void delete(int location) {
        if (length == 0)
            throw new RuntimeException("LinkedList is empty");
        if (location < 1 || location > length)
            throw new RuntimeException("location is illegal");
        int before = MAX_SIZE - 1;
        for (int l = 1; l < location; l++)
            before = list[before].getNext();
        list[before].setNext(list[location].getNext());
        list[location].setNext(list[0].getNext());
        list[0].setNext(location);
        length--;
    }

    @Override
    public String toString() {
        int begin = list[MAX_SIZE - 1].getData();
        for (int i = 0; i < length; i++)
            System.out.println(list[begin].getData());
        System.out.println("length = " + length);
        System.out.println("--------------");
        return "";
    }

    public static void main(String[] args) {
        StaticLinkedList list = new StaticLinkedList(20);
        for (int i = 1; i <= 10; i++)
            list.insert(i, i);
        System.out.println(list);
        list.delete(5);
        list.delete(3);
        list.insert(2, 11);
        list.insert(6, 15);
        System.out.println(list);
    }
}
