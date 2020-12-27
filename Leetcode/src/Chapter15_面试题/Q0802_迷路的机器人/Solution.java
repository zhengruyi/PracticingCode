package Chapter15_面试题.Q0802_迷路的机器人;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:57
 **/

public class Solution {
    public List<List <Integer>> pathWithObstacles(int[][] obstacleGrid) {
        //因为最后是反向找到路劲，所以需要用到addFirst()方法
        LinkedList <List<Integer>> res = new LinkedList<>();
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return res;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        //简单的动态规划来计算从起点到终点总共能有几种方法
        for(int i = 0;i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(j-1 >= 0){
                    dp[i][j] += dp[i][j-1];
                }
                if(i-1 >= 0){
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        //如果最终目的地的结果为0,那么表示无法到达终点，那么直接返回空列表
        if(dp[rows-1][cols-1] == 0){
            return res;
        }
        //从终点反向找到一条路径，根据这个点的dp值是否大于0来判断这个点能否到达
        int x = rows-1;
        int y = cols-1;
        while(x != 0 || y != 0){
            //判断应该往上还是往左走
            if((x - 1 >= 0 && dp[x-1][y] > 0) || (y-1 >= 0 && dp[x][y-1] > 0)){
                List<Integer> tmp = new ArrayList <>();
                tmp.add(x);
                tmp.add(y);
                res.addFirst(tmp);
                //优先往上走
                if(x - 1 >= 0 && dp[x-1][y] > 0){
                    x--;
                }else{
                    y--;
                }
            }
        }
        //加入起始点
        List<Integer> tmp = new ArrayList<>();
        tmp.add(x);
        tmp.add(y);
        res.addFirst(tmp);
        return res;
    }
}
