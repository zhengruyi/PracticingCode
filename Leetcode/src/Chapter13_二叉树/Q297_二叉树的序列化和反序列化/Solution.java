package Chapter13_二叉树.Q297_二叉树的序列化和反序列化;

import Chapter13_二叉树.TreeNode;

import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/12/2020 22:24
 **/

public class Solution {
    StringBuilder builder  = new StringBuilder();
    final String NULL = "#";
    final String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialize(root,builder);
        return builder.toString();
    }
    public void serialize(TreeNode root,StringBuilder builder){
        if(root == null){
            builder.append(NULL).append(SEP);
            return;
        }
        //前序遍历，不过对于Null节点，也保存特殊的值
        builder.append(root.val).append(SEP);
        serialize(root.left,builder);
        serialize(root.right,builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(SEP);
        //切分成字符后转化成链表，因为后续要对数据左频繁修改
        LinkedList<String> list = new LinkedList <String>();
        for(String str : datas){
            list.add(str);
        }
        return deserialize(list);
    }
    public TreeNode deserialize(LinkedList<String> list) {
        String s = list.removeFirst();
        if(s.equals(NULL)){
            return null;
        }
        //按照前序遍历的方式来反过来求二叉树
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
