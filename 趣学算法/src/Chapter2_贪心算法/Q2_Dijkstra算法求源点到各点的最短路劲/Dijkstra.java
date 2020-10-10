package Chapter2_贪心算法.Q2_Dijkstra算法求源点到各点的最短路劲;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/07/2020 18:47
 **/

public class Dijkstra {
    public static void shortestPath(int[][] graph, int location, int cities){
        PriorityQueue<Node> pq = new PriorityQueue <>(new Comparator <Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)(o1.distance - o2.distance);
            }
        });
        pq.add(new Node(location,0));
        boolean[] flags = new boolean[cities + 1];
        long[] dist = new long[cities + 1];
        for (int i = 1; i <= cities; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[location] = 0;
        while (!pq.isEmpty()){
            Node t = pq.poll();
            //由于堆不好更新，所以采用标志位进行去重处理
            if(flags[t.location]){
                continue;
            }
            flags[t.location] = true;
            for (int i = 1; i <= cities; i++) {
                //检查目标节点是否被遍历过
                if(!flags[i] && graph[t.location][i] < Integer.MAX_VALUE){
                    //检查以t节点作为中转接点，是否可以缩短距离
                    if(dist[i] > dist[t.location]+graph[t.location][i]){
                        dist[i] = dist[t.location]+graph[t.location][i];
                        pq.add(new Node(i,dist[i]));
                    }
                }
            }
        }
        for (int i = 1; i <=cities ; i++) {
            System.out.println("小明在 : "+location +" 想去 "+ i+ " 的最短距离为: "+dist[i]);
        }
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] graph = {{m,m,m,m,m,m},{m,0,2,3,m,m},{m,m,0,5,6,m},{m,m,m,0,7,1},{m,m,m,m,0,4},{m,m,m,m,m,0}};
        shortestPath(graph,1,5);
    }
}
