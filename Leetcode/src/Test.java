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
        int[] nums1 = {1,2,3,4,5,6};
        int[] nums2 = {1,1,2,2,2,2};
        minOperations(nums1,nums2);
    }

    public static void main(String[] args) {
    }
    public int minOperations(int[] nums1, int[] nums2) {
        int dist = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        int len = Math.max(nums1.length,nums2.length);
        for(int i = 0; i < len; i++){
            int n1 = 0, n2 = 0;
            if(i < nums1.length){n1 = nums1[i];}
            if(i < nums2.length){n2 = nums1[i];}
            dist += n1 - n2;
            int d1 = Math.max(6 - n1, n1 - 1);
            int d2 = Math.max(6 - n2, n2 - 1);
            pq.add(Math.max(d1,d2));
        }
        dist = Math.abs(dist);
        int res = 0;
        while(dist > 0){
            dist -= pq.poll();
            res++;
        }
        return res;
    }
}