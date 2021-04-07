package Q37_序列化二叉树;

import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/04/2021 23:14
 **/

public class Solution {
    /**
     * 重点是:
     * 1.记得采用分隔符来将各个节点的值分隔开
     * 2.采用前序遍历来作为序列化方式,因为这种方式反序列化也很容易
     * 3.这种方式反序列化采用链表作为结构,这样每次移除头结点的效率更高
     */
    StringBuilder builder  = new StringBuilder();
    //这里的重点是考虑序列化有多位数字或者负数，所以要采用分隔符来分割每个节点的值
    final String NULL = "#";
    final String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialize(root,builder);
        return builder.toString();
    }
    //前序遍历来序列化二叉树,必须要采用分隔符，因为数字可能是负数，而-3算两个字符
    public void serialize(TreeNode root, StringBuilder builder){
        if(root == null){
            builder.append(NULL).append(SEP);
            return;
        }
        builder.append(root.val).append(SEP);
        serialize(root.left,builder);
        serialize(root.right,builder);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        //采用linkedList就不用记录当前处理到的数组序号，而且可以快速删除元素
        LinkedList <String> list = new LinkedList<>();
        for(String s : strs){
            list.addLast(s);
        }
        return deserialize(list);
    }
    public TreeNode deserialize(LinkedList<String> list){
        String s = list.removeFirst();
        if(s.equals(NULL)){
            return null;
        }
        //如同前序遍历一样，先处理当前节点再处理左右子节点
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}