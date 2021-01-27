package Chapter0_其他.Q1057_校园自行车分配;

import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:36
 **/

public class Solution {
    /**
     * 就是简单的将所有可能性放入队列中，然后定义排序规则
     * @param workers
     * @param bikes
     * @return
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        //定义堆的排序规则
        PriorityQueue <WorkerBike> pq = new PriorityQueue<>((a, b) ->{
            if(a.distance != b.distance){return a.distance - b.distance;}
            if(a.workerId != b.workerId){return a.workerId - b.workerId;}
            return a.bikeId - b.bikeId;
        });
        int len = workers.length;
        int[] res = new int[len];
        //定义数组来标记工人和自行车是否分配了
        boolean[] hasWorker = new boolean[workers.length];
        boolean[] hasBike = new boolean[bikes.length];
        //求出所有工人和车的组合，放入优先队列中
        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                pq.offer(new WorkerBike(i,j,workers[i],bikes[j]));
            }
        }
        while(pq.size() > 0){
            //获取工人和自行车中距离最小的组合，检查工人和车是否都已经分配过
            WorkerBike w = pq.poll();
            //分配自行车给工人
            if(!hasWorker[w.workerId] && !hasBike[w.bikeId]){
                hasWorker[w.workerId] = true;
                hasBike[w.bikeId] = true;
                res[w.workerId] = w.bikeId;
            }
        }
        return res;
    }

    public int getDistance(int[]x, int[] y){
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
    class WorkerBike{
        public int workerId;
        public int bikeId;
        public int distance;
        public WorkerBike(int workerId, int bikeId, int[] x, int[] y){
            this.workerId = workerId;
            this.bikeId = bikeId;
            this.distance = getDistance(x,y);
        }
    }
}
