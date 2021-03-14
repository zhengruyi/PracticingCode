package Chapter8_贪心算法.Q1564_把箱子放进仓库里I;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/03/2021 22:01
 **/

public class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        //创建大顶堆,堆顶的元素值是最大值
        PriorityQueue <Integer> pq = new PriorityQueue(new Comparator <Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        //将所偶遇箱子体积放入堆中
        for(int num : boxes){
            pq.offer(num);
        }
        int res = 0;
        for(int i = 0; i < warehouse.length; i++){
            //从左到右进行扫描仓库空间,找到最大的箱子可以放进这个位置
            //将所有大于这个高度的箱子全部废弃
            while(!pq.isEmpty() && pq.peek() > warehouse[i]){
                pq.poll();
            }
            if(pq.isEmpty()){
                break;
            }
            pq.poll();
            res++;
        }
        return res;
    }
}
