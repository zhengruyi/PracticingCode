package Chapter9_并查集.Q130_被围绕的区域;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/10/2020 21:44
 **/

public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(m * n+1);
        int dumy = m * n;
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                uf.union(i*n,dumy);
            }
            if(board[i][n-1] == 'O'){
                uf.union(i*n+n-1,dumy);
            }
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                uf.union(j,dumy);
            }
            if(board[m-1][j] == 'O'){
                uf.union((m-1) * n+j, dumy);
            }
        }
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                if(board[i][j] == 'O'){
                    for(int k = 0; k < 4; k++){
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if(board[x][y] == 'O'){
                            uf.union(x*n+y, i * n + j);
                        }
                    }
                }

            }
        }
        for(int i = 1; i < m -1; i++){
            for(int j =1; j < n-1; j++){
                if(board[i][j] =='O' && !uf.connected(dumy,i*n +j)){
                    board[i][j] = 'X';
                }
            }
        }

    }
}
class UF{
    private int count;
    private int[] size;
    private int[] parent;
    public UF(int n){
        size = new int[n];
        parent = new int[n];
        count = n;
        for(int i =0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        while(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty){
            return;
        }
        if(size[rootx] < size[rooty]){
            parent[rootx] = rooty;
            size[rooty] += size[rootx];
        }else{
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        }
        count--;
    }
    public int count(){
        return count;
    }
    public boolean connected(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        return rootx == rooty;
    }
}
