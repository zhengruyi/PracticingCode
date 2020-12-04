package Chapter13_二叉树.Q117_填充每个节点的下一个右侧节点指针II;

import Chapter13_二叉树.Node;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/12/2020 22:10
 **/

public class Solution {
    Node last = null;
    Node nextStart = null;
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node start = root;
        while(start != null){
            last = null;
            nextStart = null;
            //从一层的的最左边节点开始，往右逐个遍历，分别处理当前节点的左子节点和右子节点
            for(Node p = start; p != null; p = p.next){
                if(p.left != null){
                    handle(p.left);
                }
                if(p.right != null){
                    handle(p.right);
                }
            }
            //更新到下一行重新开始
            start = nextStart;
        }
        return root;
    }
    public void handle(Node p){
        //通过全局的last和nextStart指针来找到上一个未确定next指针的节点
        //完成上一个last节点的赋值,然后更新last
        if(last != null){
            last.next = p;
        }
        //保留下一层的最左边的节点，作为下一层的起始节点
        if(nextStart == null){
            nextStart = p;
        }
        last = p;
    }
}
