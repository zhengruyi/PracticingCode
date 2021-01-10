package Chapter0_其他.Q973_最接近原点K个数;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 21:26
 **/

public class Solution {
    /**
     * 整体原理就是用小顶堆保存元素，里面的排序规则就是坐标到原点的距离
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue <int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1]);
        for(int[] point : points){
            pq.add(point);
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < res.length; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
