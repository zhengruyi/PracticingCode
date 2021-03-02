package Chapter15_面试题.Q1619_水域大小;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/03/2021 23:14
 **/

public class Solution {
    int[] dx = {0,0,1,-1,1,1,-1,-1};
    int[] dy = {1,-1,0,0,1,-1,1,-1};
    int m;
    int n;
    int padding = -1;
    public int[] pondSizes(int[][] land) {
        m = land.length;
        n = land[0].length;
        //将连通的水域赋值成同一个负值
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 0){
                    dfs(land,i,j,padding--);
                }
            }
        }
        HashMap <Integer,Integer> map = new HashMap();
        //统计各个水域的面积大小
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(land[i][j] < 0){
                    map.put(land[i][j],map.getOrDefault(land[i][j],0)+1);
                }
            }
        }
        //将水域面积转化成数组
        int[] res = new int[-1 - padding];
        int index = 0;
        for(int num : map.values()){
            res[index++] = num;
        }
        Arrays.sort(res);
        return res;

    }

    /**
     * 八个方向上进行遍历,将所有的连通的水域都赋值成同一个值,后续方便统计有多少片连通的水域
     * @param land
     * @param x
     * @param y
     * @param padding
     */
    public void dfs(int[][]land,int x, int y, int padding){
        land[x][y] = padding;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && land[newX][newY] == 0){
                dfs(land,newX,newY,padding);
            }
        }
    }
}
