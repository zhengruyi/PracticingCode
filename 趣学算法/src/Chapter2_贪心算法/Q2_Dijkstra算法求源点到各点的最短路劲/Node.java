package Chapter2_贪心算法.Q2_Dijkstra算法求源点到各点的最短路劲;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/07/2020 19:12
 **/

public class Node {
    public int location;
    public long distance;

    public Node(int location, long distance) {
        this.location = location;
        this.distance = distance;
    }
}
