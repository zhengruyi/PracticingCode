package Chapter14_深度搜索和广度搜索.Q417_太平洋大西洋水流问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 23:02
 **/

public class Solution {
    int m;
    int n;
    //四个方向搜索的偏移量
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public List<List <Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList <>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        //用于统计大西洋和太平洋水流能流到的地方，能流到的地方就设置成1
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        for(int i = 0; i < m; i++){
            //上是太平洋，下是大西洋
            dfs(matrix,i,0,pacific);
            dfs(matrix,i,n-1,atlantic);
        }
        for(int j = 0; j < n; j++){
            //左是太平洋，右是大西洋
            dfs(matrix,0,j,pacific);
            dfs(matrix,m-1,j,atlantic);
        }
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                //如果大西洋和太平洋都可以流到这个地方就是这个坐标放入答案中
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] matrix, int x, int y, int[][] tmp){
        tmp[x][y] = 1;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            //如果下一个要搜索的左边不合法或者比当前值小(因为是从目的往源头搜索)或者已经遍历过了
            if(!inArea(newX,newY) || matrix[x][y] > matrix[newX][newY] || tmp[newX][newY] == 1){
                continue;
            }
            dfs(matrix,newX,newY,tmp);
        }
    }
    public boolean inArea(int i, int j){
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}
