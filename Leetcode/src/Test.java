import Chapter13_二叉树.TreeNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        int[][] workers = {{0,0},{2,1}};
        int[][] bikes = {{1,2},{3,3}};
        assignBikes(workers,bikes);
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    int[] dx = {-2,-2,-1,-1,1,1,2,2};
    int[] dy = {1,-1,2,-2,2,-2,1,-1};
    public int assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Allocation> pq = new PriorityQueue<>((a,b) ->{
            if(a.distance != b.distance){return a.distance - b.distance;}
            if(a.workerId != b.workerId){return a.workerId - b.workerId;}
            return a.bikeId - b.bikeId;
        });
        int len1 = workers.length;
        int len2 = bikes.length;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                pq.add(new Allocation(i,j,getDistance(workers[i],bikes[j])));
            }
        }
        int res = 0;
        boolean[] usedWorker = new boolean[len1];
        boolean[] usedBike = new boolean[len2];
        while(!pq.isEmpty()){
            Allocation a = pq.poll();
            if(!usedWorker[a.workerId] && !usedBike[a.bikeId]){
                usedWorker[a.workerId] = true;
                usedBike[a.bikeId] = true;
                res += a.distance;
            }
        }
        return res;
    }
    public int getDistance(int[] x1, int[] y1){
        return Math.abs(x1[0] - y1[0]) + Math.abs(x1[1] - y1[1]);
    }
}
class Allocation{
    public int workerId;
    public int bikeId;
    public int distance;
    public Allocation(int workerId, int bikeId, int distance){
        this.workerId = workerId;
        this.bikeId = bikeId;
        this.distance = distance;
    }
}