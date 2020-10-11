package Chapter2回溯算法.Q77_组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/10/2020 16:49
 **/

public class Solution {
    public List<List <Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> track = new ArrayList<Integer>();
        backTrack(res,track,1,n,k);
        return res;

    }
    public void backTrack(List<List<Integer>> res,List<Integer> track, int start, int n, int k){
        if(track.size() == k){
            res.add(new ArrayList(track));
            return;
        }
        for(int i = start; i<= n; i++){
            track.add(i);
            backTrack(res,track,i+1,n,k);
            track.remove(track.size()-1);
        }
    }
}
