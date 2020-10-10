package Chapter3_二叉树问题.Q8_找到二叉树中符合搜索二叉树条件的最大拓扑结构;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/05/2020 17:22
 **/

public class FindMaxTopologyStructure {
    /**
     * 时间复杂度为O(N^2),不是很好
     * @param root
     * @return
     */
    public int findMaxTopology(Tree root){
        ArrayList<Tree> array = new ArrayList <>();
        postOrder(root,array);
        int max = 0;
        for (int i = 0; i < array.size(); i++) {
            max = Math.max(max,findTopologyNumber(array.get(i)));
        }
        return max;
    }

    /**
     * 返回树的后续遍历
     * @param root
     * @param array
     */
    public void postOrder(Tree root, ArrayList<Tree> array){
        if(root == null){
            return;
        }
        postOrder(root.left,array);
        postOrder(root.right,array);
        array.add(root);
    }

    /**
     * 找出当前节点的最大拓扑结构的节点数目
     * @param root
     * @return
     */
    public int findTopologyNumber(Tree root){
        if(root == null){
            return 0;
        }
        Deque<Tree> deque = new ArrayDeque <>();
        deque.addLast(root);
        int number = 0;
        while (!deque.isEmpty()){
            Tree temp = deque.removeFirst();
            if(checkNode(root,temp)){
                number ++;
                if(temp.left != null){
                    deque.addLast(temp.left);
                }
                if(temp.right != null){
                    deque.addLast(temp.right);
                }
            }
        }
        return number;
    }

    /**
     * 检查当前节点是否在拓扑节结构中
     * @param root
     * @param target
     * @return
     */
    public boolean checkNode(Tree root, Tree target){
        if(root == target){
            return true;
        }
        while (root != null && root != target){
            root = target.value < root.value ? root.left : root.right;
        }
        return root == target;
    }

    @Test
    void test(){
        Tree t0 = new Tree(0);
        Tree t3 = new Tree(3);
        Tree t2 = new Tree(2);
        Tree t5 = new Tree(5);
        Tree t11 = new Tree(11);
        Tree t15 = new Tree(15);
        Tree t20 = new Tree(20);
        Tree t16 = new Tree(16);
        Tree t1 = new Tree(1,t0,t3);
        Tree t4 = new Tree(4,t2,t5);
        Tree t14 = new Tree(14,t11,t15);
        Tree t10 = new Tree(10,t4,t14);
        Tree t13 = new Tree(13,t20,t16);
        Tree t12 = new Tree(12,t10,t13);
        Tree t6 = new Tree(6,t1,t12);


        Assertions.assertEquals(8,findMaxTopology(t6));
    }
}
