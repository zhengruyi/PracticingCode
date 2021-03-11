package Chapter14_深度搜索和广度搜索.Q1034_边框着色;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/03/2021 23:15
 **/

public class Solution {
    int m;
    int n;
    int oldColor;
    boolean[][] visited;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    /**
     * DFS计数法，因为只用给边框着色,所以采用计数法，即对四个方向进行统计，如果四个方向上都是和自己颜色
     * 一样的元素,说明自己不是边界，不用着色
     * @param grid
     * @param r0
     * @param c0
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        m = grid.length;
        n = grid[0].length;
        oldColor = grid[r0][c0];
        visited = new boolean[m][n];
        dfs(grid,r0,c0,color);
        return grid;
    }
    public int dfs(int[][] grid, int x, int y, int newColor){
        //超出边界
        if(!area(x,y)){
            return 0;
        }
        //当前点已经遍历过,那么当前点是一个同类型的点
        if(visited[x][y]){
            return 1;
        }
        //外部节点不用着色
        if(grid[x][y] != oldColor){
            return 0;
        }
        visited[x][y] = true;
        int cnt = 0;
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            //统计四个方向上有几个节点和自己的颜色相同
            cnt += dfs(grid,newX,newY,newColor);
        }
        //如果四个方向不是都满足那么当前节点就是边界节点,需要着色
        if(cnt < 4){
            grid[x][y] = newColor;
        }
        return 1;
    }
    public  boolean area(int r, int c){
        return  r >=0 && r < m && c >= 0 && c < n;
    }
}
