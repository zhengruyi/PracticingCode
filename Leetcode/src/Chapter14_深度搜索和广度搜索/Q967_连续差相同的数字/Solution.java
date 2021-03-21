package Chapter14_深度搜索和广度搜索.Q967_连续差相同的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/03/2021 23:35
 **/

public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List <Integer> tmp = new ArrayList();
        //首字母不能等于0，所以可能性从1..9开始遍历
        for(int i = 1; i <= 9; i++){
            dfs(n,k,tmp,i,1);
        }
        int[] res = new int[tmp.size()];
        //将list转换成数组
        for(int i = 0; i < tmp.size(); i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
    public void dfs(int n, int k, List<Integer> res, int num, int len){
        //达到要求的长度，则直接压入结果列表中
        if(len == n){
            res.add(num);
            return;
        }
        for(int i = 0; i <= 9; i++){
            //获取尾部数字
            int last = num % 10;
            //从0..9中找到和last绝对值为k的数字,重新计算数字和数字长度
            //进入下一轮循环长度
            if(Math.abs(i - last) == k){
                dfs(n,k,res,num * 10 + i, len + 1);
            }
        }
    }
}
