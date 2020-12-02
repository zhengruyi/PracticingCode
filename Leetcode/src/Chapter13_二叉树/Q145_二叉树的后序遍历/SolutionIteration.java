package Chapter13_二叉树.Q145_二叉树的后序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:57
 **/

public class SolutionIteration {
    public List <Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList <Integer>();
        if(root == null){
            return list;
        }
        Stack <TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode curr = null;
        stack.push(root);
        while(!stack.isEmpty()){
            curr = stack.peek();
            //如果当前节点没有左右子树或者左右子树已经遍历过，就可以直接弹栈，输出对应的值
            if((curr.left == null && curr.right == null)||(pre != null && (pre == curr.left || pre == curr.right))){
                list.add(curr.val);
                pre = curr;
                stack.pop();
            }else{
                //按照左节点，右节点，根节点顺序压栈
                if(curr.right != null){
                    stack.push(curr.right);
                }
                if(curr.left != null){
                    stack.push(curr.left);
                }
            }
        }
        return list;
    }
}
