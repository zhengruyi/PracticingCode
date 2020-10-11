package Chapter2回溯算法.Q51_N皇后问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/10/2020 14:19
 **/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queue = new int[n];
        //将数组默认值设为-1
        Arrays.fill(queue, -1);
        backTrack(res,0,n,queue);
        return res;
    }
    public void backTrack(List<List<String>> res, int row, int n, int[] queue){
        //到达结束条件生成最终结果
        if(row == n){
            res.add(generateAnswer(queue));
            return;
        }
        for(int i = 0; i < n ; i++){
            if(!isValid(row, i,queue)){
                continue;
            }
            //做出选择把皇后放在第i+1列
            queue[row] = i;
            backTrack(res,row+1,n,queue);
            //撤销选择，恢复默认状态
            queue[row] = -1;
        }
    }
    public boolean isValid(int row, int column, int[] queue){
        for(int i = 0; i < queue.length; i++){
            if(queue[i] == -1){
                break;
            }
            //同一列上是否有皇后
            if(queue[i] == column){
                return false;
                //左上角和右上角上是否有皇后
            }else if(Math.abs(i - row) == Math.abs(queue[i] - column)){
                return false;
            }
        }
        return true;
    }

    /**
     * 根据皇后位置生成结果
     * @param queue
     * @return
     */
    public List<String> generateAnswer(int[] queue){
        List<String> tmp = new ArrayList<String>(queue.length);
        char[] chars = new char[queue.length];
        for(int i = 0;i < queue.length; i++){
            Arrays.fill(chars,'.');
            chars[queue[i]] = 'Q';
            tmp.add(new String(chars));
        }
        return tmp;
    }
}