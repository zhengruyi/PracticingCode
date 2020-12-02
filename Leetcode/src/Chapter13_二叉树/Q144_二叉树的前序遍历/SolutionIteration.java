package Chapter13_二叉树.Q144_二叉树的前序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:30
 **/

public class SolutionIteration {
    public List <Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList <Integer>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack <TreeNode>();
        //前序遍历顺序是根节点，左节点，最后是右节点
        while(root != null || !stack.isEmpty()){
            //遍历所有左子节点，因为左子节点也是一个子树的根节点，所以可以直接存入栈
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //表明栈顶节点就是左子树的尽头，而且当前节点已经输出过，那么切换到栈顶节点的右子树
            //右子节点作为根节点，开始新的遍历过程
            if(!stack.isEmpty()){
                root = stack.pop().right;
            }
        }
        return list;
    }
}
