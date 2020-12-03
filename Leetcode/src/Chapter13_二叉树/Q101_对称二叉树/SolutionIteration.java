package Chapter13_二叉树.Q101_对称二叉树;

import Chapter13_二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/12/2020 22:58
 **/

public class SolutionIteration {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode p, TreeNode q){
        //使用队列来存储同一层的数据节点
        Queue <TreeNode> queue = new LinkedList <TreeNode>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            p = queue.poll();
            q = queue.poll();
            if(p == null && q == null){
                continue;
            }
            if(p == null || q == null ||(p.val != q.val)){
                return false;
            }
            //因为镜像关系，左子树的左子节点等于右子树的右子节点，所以这里的添加关系
            //先添加左子树的左子节点在添加右子树的右子节点
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
