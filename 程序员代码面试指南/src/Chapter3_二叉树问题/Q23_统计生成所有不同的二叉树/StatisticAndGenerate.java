package Chapter3_二叉树问题.Q23_统计生成所有不同的二叉树;

import Chapter3_二叉树问题.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/06/2020 17:36
 **/

public class StatisticAndGenerate {
    public int statistic(int n){
        int[] statistic = new int[n+1];
        statistic[0] = 1;
        for (int i = 1; i <statistic.length; i++) {
            for (int j = 1; j <= i; j++) {
                //动态规划 以i为头结点的二叉树有 nums[i-1] * nums[N-i]种，其中N表示序列总长度
                statistic[i] += statistic[j-1] * statistic[i - j];
            }
        }
        return statistic[n];
    }
    @Test
    void test(){
        Assertions.assertEquals(2,statistic(2));
        Assertions.assertEquals(5,statistic(3));
    }

    /**
     * 根据序列生成二叉搜索树，很难理解，看不懂
     * @param n
     * @return
     */
    public static List <Tree> generateTree(int n){
        if(n < 0){
            return null;
        }
        List<Tree> list = generate(1,n);
        return list;
    }
    public static List<Tree> generate(int start, int end){
        List<Tree> res = new LinkedList <>();
        if(start > end){
            res.add(null);
        }
        Tree head = null;
        for (int i = start; i < end + 1; i++) {
            head = new Tree(i);
            List<Tree> lSubs = generate(start,i-1);
            List<Tree> rSubs = generate(i+1,end);
            for (Tree l : lSubs){
                for(Tree r : rSubs){
                    head.left = l;
                    head.right = r;
                    res.add(cloneTree(head));
                }
            }
        }
        return res;
    }
    public static Tree cloneTree(Tree head){
        if(head == null){
            return null;
        }
        Tree res = new Tree(head.value);
        res.left = cloneTree(head.left);
        res.right = cloneTree(head.right);
        return res;
    }

    public static void main(String[] args) {
        generateTree(3);
    }
}
