package Chapter14_深度搜索和广度搜索.Q386_字典序排数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:02
 **/

public class Solution {
    /**
     * 本质就是一个九叉树，然后前序遍历的结果就是字典排序
     * 这道题优点讨巧
     */
    List <Integer> res = new ArrayList <>();
    public List<Integer> lexicalOrder(int n) {
        //这里注意首数字不能为0
        for(int i = 1; i < 10; i++){
            dfs(n,i);
        }
        return res;
    }

    /**
     * 深度遍历
     * @param n
     * @param num
     */
    public void dfs(int n, int num){
        if(num > n){
            return;
        }
        res.add(num);
        for(int i = 0; i < 10; i++){
            dfs(n,num * 10 + i);
        }
    }
}
