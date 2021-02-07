package Chapter14_深度搜索和广度搜索.Q894_所有可能的满二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/02/2021 22:39
 **/

public class Solution {
    HashMap<Integer, List <TreeNode>> map = new HashMap <>();
    public List<TreeNode> allPossibleFBT(int N) {
        //检查这个是否已经求过了
        if(!map.containsKey(N)){
            //创建空的列表
            List<TreeNode> res = new ArrayList <>();
            //只有一个节点,那么就直接返回
            if(N == 1){
                res.add(new TreeNode(0));
                //偶数的话无法构成满二叉树,因为左右子树都是奇数,在加上根节点,那么总结点数一定是奇数
            }else if(N % 2 == 1){
                //左节点数是从0..N-1
                for(int x = 0; x < N; x++){
                    //左右总结点数和是N-1
                    int y = N - 1 - x;
                    //获取左子树总结点数为x的所有可能情况,和右子树总数为Y的情况
                    List<TreeNode> lefts = allPossibleFBT(x);
                    List<TreeNode> rights = allPossibleFBT(y);
                    //拼接答案
                    for(TreeNode left : lefts){
                        for(TreeNode right : rights){
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            res.add(root);
                        }
                    }
                }

            }
            //这里这么设置是可以顺利处理N = 0的情况
            map.put(N,res);
            return res;
        }
        return map.get(N);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}