package Chapter1_栈和队列.Q5_构造数组的MaxTree;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/05/2020 21:56
 **/

public class MaxTree {
    public Node constructMaxTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i]);
        }
        Stack <Node> stack = new Stack <>();
        HashMap <Node, Node> leftMap = new HashMap <>();
        HashMap <Node, Node> rightMap = new HashMap <>();
        for (int i = 0; i < nodes.length; i++) {
            Node curr = nodes[i];
            while ((!stack.isEmpty()) && stack.peek().value < curr.value) {
                setHashMap(stack, leftMap);
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            setHashMap(stack, leftMap);
        }
        for (int i = nodes.length - 1; i >= 0; i--) {
            Node curr = nodes[i];
            while ((!stack.isEmpty()) && stack.peek().value < curr.value) {
                setHashMap(stack, rightMap);
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            setHashMap(stack, rightMap);
        }
        Node head = null;
        for (int i = 0; i < nodes.length; i++) {
            Node temp = nodes[i];
            Node left = leftMap.get(temp);
            Node right = rightMap.get(temp);
            if (left == null && right == null) {
                head = temp;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = temp;
                } else {
                    right.right = temp;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = temp;
                } else {
                    left.right = temp;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = temp;
                } else {
                    parent.right = temp;
                }
            }
        }
        return head;
    }

    public void setHashMap(Stack <Node> stack, HashMap <Node, Node> map) {
        Node temp = stack.pop();
        if (stack.isEmpty()) {
            map.put(temp, null);
        } else {
            map.put(temp, stack.peek());
        }
    }

    @Test
    void test() {
        Node head = constructMaxTree(new int[]{3, 4, 5, 1, 2});
        Assertions.assertEquals(5,head.value);
        Assertions.assertEquals(4,head.left.value);
        Assertions.assertEquals(2,head.right.value);
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}