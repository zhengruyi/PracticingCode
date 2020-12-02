package Chapter13_二叉树.Q94_二叉树的中序遍历;

import Chapter13_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/12/2020 22:45
 **/

public class SolutionIteration {
    public List <Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList <Integer>();
        Stack<TreeNode> stack = new Stack <TreeNode>();
        if(root == null){
            return list;
        }
        //和Q114基本一样，只不过由于中序遍历，所以输出顺序是左节点，根节点，右节点
        //所以要在左子节点都压入栈，这是从栈中取出节点，表示左子节点都处理过了，这时栈中
        //节点就是按照左节点和根节点顺序排列的，所以按弹出顺序遍历结果就行
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;

    }
}
