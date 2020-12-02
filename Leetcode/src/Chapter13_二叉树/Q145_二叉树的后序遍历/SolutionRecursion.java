package Chapter13_二叉树.Q145_二叉树的后序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:57
 **/

public class SolutionRecursion {
    List<Integer> list = new ArrayList <Integer>();
    public List <Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
