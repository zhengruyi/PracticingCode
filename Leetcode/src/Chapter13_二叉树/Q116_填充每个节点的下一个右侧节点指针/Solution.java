package Chapter13_二叉树.Q116_填充每个节点的下一个右侧节点指针;

import Chapter13_二叉树.Node;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/12/2020 22:03
 **/

public class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        //完美二叉树，所以最左边的节点肯定是左子节点
        Node leftMost = root;
        while(leftMost.left != null){
            Node head = leftMost;
            while(head != null){
                //左子节点的next指针指向指向当前父节点的右子节点
                head.left.next = head.right;
                //当前节点右子节点指向下一个节点的左子节点，这里通过上一层的已经搭建好的父节点next
                //指针来找到下一个节点的左子节点
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            //这一层已经全部构建完毕，循环到下一层
            leftMost = leftMost.left;
        }
        return root;
    }
}
