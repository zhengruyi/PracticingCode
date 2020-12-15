package Chapter14_深度搜索和广度搜索.Q815_公交车线路;

import java.util.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/12/2020 00:16
 **/

public class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T){
            return 0;
        }
        int n = routes.length;
        //采用邻接表来表示图
        List<List <Integer>> graph = new ArrayList<>();
        //把每条公交线路的站点排序,方便查询公交线路的链接情况
        for(int i = 0; i < n; i++){
            Arrays.sort(routes[i]);
            //创建公交线路图
            graph.add(new ArrayList <>());
        }
        //保存其实点所在的公交线路
        Set <Integer> seen = new HashSet <Integer>();
        //保存终点坐在的公交线路
        Set<Integer> targets = new HashSet<Integer>();
        //队列用于广度遍历
        Queue<Point> queue = new ArrayDeque<>();
        //两两搜索公交线路，如果有连接点，就在两条公交线路之间创建边
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                //判断两条公交线路是否相连
                if(intersect(routes[i],routes[j])){
                    //用连接表来表示图
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        //抖索哪些公交线路上存在起点和终点
        for(int i = 0; i < n; i++){
            //保存哪些公交线路上有起点，并且将对应公交线路入队
            if(Arrays.binarySearch(routes[i],S) >= 0){
                seen.add(i);
                queue.offer(new Point(i,0));
            }
            //保存哪些公交线路上有终点，并在集合中保存终点所在的公交线路
            if(Arrays.binarySearch(routes[i],T) >= 0){
                targets.add(i);
            }
        }
        while(!queue.isEmpty()){
            Point info = queue.poll();
            int node = info.x;
            int depth = info.y;
            //检查该公交线路上是否存在终点，存在就直接返回最少的次数
            if(targets.contains(node)){
                return depth+1;
            }
            //检查所有和该公交线路相连的公交线路
            for(Integer nei : graph.get(node)){
                //如果触发集合中不包含，那么久在触发集合中添加出发线路
                if(!seen.contains(nei)){
                    seen.add(nei);
                    //将新的公交线路添加到出发集合中
                    queue.offer(new Point(nei,depth+1));
                }
            }
        }
        return -1;
    }

    /**
     * 由于两个线路所有节点都已经有序，所以采用指针法来判断两条公交线路来判断是否相连
     * @param A
     * @param B
     * @return
     */
    public boolean intersect(int[] A, int[] B){
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            if(A[i] == B[j]){
                return true;
            }
            if(A[i] < B[j]){
                i++;
            }else{
                j++;
            }
        }
        return false;
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
