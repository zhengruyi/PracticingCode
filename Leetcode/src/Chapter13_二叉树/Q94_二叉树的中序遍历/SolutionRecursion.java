package Chapter13_二叉树.Q94_二叉树的中序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:43
 **/

public class SolutionRecursion {
    List<Integer> list = new ArrayList <Integer>();
    public List <Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
