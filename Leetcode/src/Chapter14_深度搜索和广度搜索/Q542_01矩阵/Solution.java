package Chapter14_深度搜索和广度搜索.Q542_01矩阵;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 16:54
 **/

public class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};

    /**
     * 这题的优点在于在援助证上进行修改，所以不需要额外空间复杂度
     * 另外为了避免把已经遍历过的1和为遍历过的1区分开，所以这里
     * 在便利时把原始的1变成-1，然后在把这个点加入宽度遍历序列
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[][]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue <int[]> queue = new LinkedList <>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //遍历矩阵0点入队列，1变成-1
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < dx.length; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                //计算四个方向的遍历,碰到未遍历1，也加入队列
                if(newX >= 0 && newX < m && newY >=0 && newY < n && matrix[newX][newY] == -1){
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return matrix;
    }
}
