package Chapter3_二叉树问题.Q6_在二叉树中找到累加和为指定值的最长路劲长度;

import Chapter3_二叉树问题.Tree;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/05/2020 13:07
 **/

public class MaxLength {
    public static int getMaxLength(Tree root, int sum) {
        HashMap <Integer, Integer> sumMap = new HashMap <>();
        sumMap.put(0, 0);
        return preOrder(root, sum, 0, 1, 0, sumMap);
    }

    public static int preOrder(Tree head, int sum, int preSum, int level, int maxLen, HashMap <Integer, Integer> sumMap) {
        if (head == null) {
            return maxLen;
        }
        int curSum = preSum + head.value;
        //因为可能是父节点计算出来的值，当父节点往上返回时需要自己删除，所以子节点不可以更新父节点的值
        //当然父节点不存在化的话就可以添加
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum, level);
        }
        //计算当前是否存在等于sum的路劲，总的节点长度是用两个节点之间对应的level差来计算的，从根节点
        //开始的路径，可以有由事先加入的(0,0)来进行计算
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
        //由于下一步要进行返回当前节点的父节点，所以不可能在出现以当前节点为父节点的情况，为避免后面出错，要删除以当前节点的路径和

        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Tree t6 = new Tree(6);
        Tree t111 = new Tree(1);
        Tree t2 = new Tree(2);
        Tree t11 = new Tree(1);
        Tree t1 = new Tree(1);
        Tree t0 = new Tree(0, t11, t6);
        Tree t3 = new Tree(3, t1, t0);
        Tree m9 = new Tree(-9,t2,t111);
        Tree m3 = new Tree(-3, t3, m9);
        //System.out.println(getMaxLength(m3,6));
        System.out.println(getMaxLength(m3,-9));
    }
}
