package Chapter14_深度搜索和广度搜索.Q247_中心对称数II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/02/2021 23:11
 **/

public class Solution {
    String[] left = {"1","6","8","9"};
    String[] right = {"1","9","8","6"};

    /**
     * 用到了分治的思想,将问题化解成更小的问题,然后在小问题的基础上构造出最终的答案
     * @param n
     * @return
     */
    public List <String> findStrobogrammatic(int n) {
        List<String> res = dfs(n,n);
        return res;
    }
    public List<String> dfs(int n, int total){
        //处理边界的特殊情况
        if(n == 0){
            return Arrays.asList("");
        }
        //1位时只能取对称数字
        if(n == 1){
            return Arrays.asList("0","1","8");
        }
        List<String> res = new ArrayList();
        //取出左边和右边的数字，将问题花城较小的问题
        for(String s : dfs(n-2,total)){
            //然后在小问题的基础上组合出答案
            for(int i = 0; i < left.length; i++){
                res.add(left[i] + s + right[i]);
            }
            //如果不是最左和最右，那么可以在两边各自添加一个"0"
            if(n != total){
                res.add("0" + s + "0");
            }
        }
        return res;
    }
}
