package Chapter14_深度搜索和广度搜索.Q216_组合总和III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 20:44
 **/

public class Solution {
    List<List <Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs(k,0,n,new ArrayList <>(),1);
        return res;
    }

    /**
     * 采用单向递增的遍历模式来避免重复解
     * @param k
     * @param sum
     * @param n
     * @param path
     * @param start
     */
    public void dfs(int k, int sum, int n, List<Integer> path, int start){
        if(sum > n){
            return;
        }
        if(path.size() == k && sum == n){
            res.add(new ArrayList<>(path));
        }
        for(int i = start; i <= 9; i++){
            if(sum + i > n){
                return;
            }
            path.add(i);
            dfs(k,sum+i,n,path,i+1);
            path.remove(path.size() - 1);
        }
    }
}
