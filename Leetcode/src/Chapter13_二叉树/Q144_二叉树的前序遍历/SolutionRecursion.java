package Chapter13_二叉树.Q144_二叉树的前序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:30
 **/

public class SolutionRecursion {
    List<Integer> list = new ArrayList <Integer>();
    public List <Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
}
