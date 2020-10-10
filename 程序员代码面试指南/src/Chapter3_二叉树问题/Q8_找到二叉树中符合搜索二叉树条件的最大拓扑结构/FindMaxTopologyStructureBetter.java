package Chapter3_二叉树问题.Q8_找到二叉树中符合搜索二叉树条件的最大拓扑结构;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/05/2020 19:09
 **/

public class FindMaxTopologyStructureBetter {
    public int findMaxTopologyBetter(Tree root){
        HashMap<Tree,Record> map = new HashMap <>();
        //拓扑贡献录需要在叶子节点的基础上进行操作，所以采用后续遍历的方式
        return postOrder(root,map);
    }

    public int postOrder(Tree head, HashMap<Tree,Record> map){
        if(head == null){
            return 0;
        }
        //后序遍历从叶子节点开始处理
        int ls = postOrder(head.left,map);
        int rs = postOrder(head.right,map);
        //对当前节点的左子树和右子树进行调整
        modifyMap(head.left,head.value,map,true);
        modifyMap(head.right,head.value,map,false);
        //调整过后返回左右子树各自的拓扑贡献录，然后计算出当前最大的二叉搜索树拓扑的节点数目
        Record lr = map.get(head.left);
        Record rr = map.get(head.right);
        //计算出左右子树对当前节点作为头结点的拓扑贡献录
        int lbst = lr == null ? 0 : lr.left + lr.right +1;
        int rbst = rr == null ? 0 : rr.left + rr.right + 1;
        //存入当前节点
        map.put(head,new Record(lbst,rbst));
        //返回当前节点作为头结点的最大二叉搜索树拓扑的节点数目
        return Math.max(lbst + rbst + 1, Math.max(ls,rs));
    }

    public int modifyMap(Tree root,int target, HashMap<Tree,Record> map ,boolean left){
        //当前节点为null或者当前节点是叶子节点，可以直接返回
        if(root == null || !map.containsKey(root)){
            return 0 ;
        }
        //去当当前节点的拓扑贡献录
        Record r = map.get(root);
        //如果当前节点在目标节点的左子树但是值却比目标节点大或者 当前节点在目标节点的右子树但是值却比目标节点小
        //则不构成二叉搜索树，进行贡献录的清除操作
        if((left && root.value > target)|| (!left && root.value < target)){
            //移除当前节点
            map.remove(root);
            //返回所有该节点的父节点和祖先节点应该减去的值
            return r.left + r.right +1;
        }else{
            //当前节点符合要求，但需要验证所有左子树的右边界和右子树中的左边界是由有违反规律的节点，有的话则需要进行更新
            int minus = modifyMap(left ? root.right : root.left, target, map, left);
            if(left){
                //左子树的右边界中更新右子树的拓扑贡献录
                r.right = r.right - minus;
            }else{
                //右子树的左边界中更新右子树的拓扑贡献录
                r.left = r.left - minus;
            }
            //更新当前节点
            map.put(root,r);
            //返回所有当前节点的父节点和祖先节点需要更新的值
            return minus;
        }
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


        Assertions.assertEquals(8,findMaxTopologyBetter(t6));
    }
}
class Record{
    public int left;
    public int right;

    public Record(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
