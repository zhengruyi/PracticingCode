package Chapter0_其他.Q354_俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/10/2020 22:39
 **/

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        // int[wide,height]
        //首先对数组的宽度进行升序排列，如果宽度相等，对高度进行降序排列
        Arrays.sort(envelopes, new Comparator <int[]>(){
            @Override
            public int compare(int[] t1, int[] t2){
                if(t1[0] != t2[0]){
                    return t1[0] - t2[0];
                }else{
                    return t2[1] - t1[1];
                }
            }
        });
        //创建牌堆数组
        int[] top = new int[envelopes.length];
        //牌堆数组数目一开始为0
        int piles = 0;
        for(int i = 0; i < envelopes.length; i++){
            int left = 0;
            // right = top.length - 1
            int right = piles - 1;
            //要插入的数字
            int pocker = envelopes[i][1];
            //找到数子的最左边界
            while(left <= right){
                int mid = left + (right - left)/2;
                if(top[mid] == pocker){
                    right = mid -1;
                }else if(top[mid] < pocker){
                    left = mid + 1;
                }else if(top[mid] > pocker){
                    right = mid -1;
                }
            }
            //如果比所有数字都大，则新建一个牌堆
            if(left == piles){
                piles++;
            }
            //更新牌堆顶部的值
            top[left] = pocker;
        }
        //牌堆数目就是最长递增子序列
        return piles;

    }
}
