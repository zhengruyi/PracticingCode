package Chapter14_深度搜索和广度搜索.Q797_所有可能的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/02/2021 22:31
 **/

public class Solution {
    public List<List <Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList <>();
        dfs(graph,0,new ArrayList(),res);
        return res;
    }

    /**
     * 深度遍历去走过所有的路劲,如果路劲到达了目标点,就添加进结果集中
     * @param graph
     * @param node
     * @param path
     * @param res
     */
    public void dfs(int[][] graph,int node,List<Integer> path, List<List<Integer>> res){
        path.add(node);
        //到达终点，就将走过的路径加入结果集中
        if(node == graph.length - 1){
            res.add(new ArrayList(path));
            //加入后回退一步
            path.remove(path.size() - 1);
            return;
        }
        //找出所有可能的下一步路劲,进行深度遍历
        for(int next : graph[node]){
            dfs(graph,next,path,res);
        }
        //回退一步，返回上一个节点
        path.remove(path.size() - 1);
    }
}
