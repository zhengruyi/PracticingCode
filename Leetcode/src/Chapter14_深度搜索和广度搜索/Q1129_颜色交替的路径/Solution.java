package Chapter14_深度搜索和广度搜索.Q1129_颜色交替的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:10
 **/

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        //创建两个链表用来保存所有的相同颜色构建的图
        List<List <Integer>> rg = new ArrayList <>();
        List<List<Integer>> bg = new ArrayList<>();
        for(int i = 0; i < n; i++){
            rg.add(new ArrayList<>());
            bg.add(new ArrayList<>());
        }
        //应为是有向图，所以只单向保存
        for(int[] edge : red_edges){
            rg.get(edge[0]).add(edge[1]);
        }
        for(int[] edge : blue_edges){
            bg.get(edge[0]).add(edge[1]);
        }
        //ans[i][0]表示从0到i最后一条为红色路线时所经过的路径长度
        //ans[i][1]表示从0到i最后一条为蓝色路线时所经过的路径长度
        int[][] ans = new int[n][2];
        for(int i = 0; i < n; i++){
            ans[i][0] = Integer.MAX_VALUE;
            ans[i][1] = Integer.MAX_VALUE;
        }
        //初始值无论红蓝路径都为0
        ans[0][0] = 0;
        ans[0][1] = 0;
        dfs(rg,bg,0,0,ans);
        dfs(rg,bg,1,0,ans);
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            //选择两条路径中较小的一条
            res[i] = Math.min(ans[i][0],ans[i][1]);
            if(res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        return res;
    }
    public void dfs(List<List<Integer>> rg,List<List<Integer>> bg, int color, int i, int[][] ans){
        List<List<Integer>> graph = color == 0 ? rg : bg;
        //红蓝交替进行深度搜索
        for(int j : graph.get(i)){
            if(ans[i][color] + 1 < ans[j][Math.abs(color-1)]){
                //如果o->i->j的路径长度小于0->j，那么就需要更新
                ans[j][Math.abs(color-1)] = ans[i][color] + 1;
                dfs(rg,bg,Math.abs(color-1),j,ans);
            }
        }
    }
}
