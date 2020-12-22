package Chapter14_深度搜索和广度搜索.Q254_因子的组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:39
 **/

public class Solution {
    public List<List <Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList <>();
        if(n == 1){
            return list;
        }
        return dfs(2,n);
    }
    public List<List<Integer>> dfs(int start, int n){
        int end = (int)Math.sqrt(n);
        List<List<Integer>> res = new ArrayList<>();
        //这里采用升序的方式避免结果重复的问题
        for(int mulNum = start; mulNum <= end; mulNum++){
            if(n % mulNum == 0){
                //将两数乘积的结果放入结果集中
                ArrayList<Integer> sim = new ArrayList<>();
                sim.add(mulNum);
                sim.add(n/mulNum);
                res.add(sim);
                //查看其中一个因数是否可以由大于mulNum继续分解
                List<List<Integer>> tmp = dfs(mulNum,n/mulNum);
                //装入mulNum，则是最终结果集的一部分
                for(List<Integer> l : tmp){
                    l.add(mulNum);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
