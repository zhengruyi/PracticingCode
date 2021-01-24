package Chapter0_其他.Q373_查找和最小的K对数字;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/01/2021 18:51
 **/

public class Solution {
    /**
     * 遇到取前k小或者前k大的元素,优先考虑用堆来进行操作因为堆的更新效率是O(logn)
     * 获取元素的效率是O(1)
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List <Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //可能存在 k < len1 * len2的情况
        k = Math.min(k, len1 * len2);
        List<List<Integer>> res = new ArrayList <>();
        if(k == 0){
            return res;
        }
        //创建一个小顶堆，对立面的排序规则就是nums1里面的元素值和num2索引随影的值的和
        PriorityQueue<Node> queue = new PriorityQueue <>((o1, o2) -> o1.v + nums2[o1.index] - o2.v - nums2[o2.index]);
        //初始化堆大小
        for(int i = 0; i < nums1.length; i++){
            queue.offer(new Node(nums1[i],0));
        }
        int i = 0;
        while(i < k){
            Node node = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(node.v);
            tmp.add(nums2[node.index]);
            res.add(tmp);
            //跟新在num2的索引
            node.index++;
            //如果为超出num2的边界，由于值已经改变所以需要再次加进去
            if(node.index < len2){
                queue.offer(node);
            }
            i++;
        }
        return res;
    }
}
class Node{
    public int v;
    public int index;
    public Node(int v, int index){
        this.v = v;
        this.index = index;
    }
}