package Chapter15_面试题.Q1708_马戏团人塔;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/01/2021 20:57
 **/

public class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if(height.length == 0){
            return 0;
        }
        int length = height.length;
        int[][] nums = new int[length][2];
        //将体重和身高组合咋一起重构数据
        for(int i = 0; i < height.length; i++){
            nums[i] = new int[]{height[i],weight[i]};
        }
        //排序规则，按照身高升序排列，不用严格相等，然后按照体重降序排列
        //如果身高相同，那么按体重降序排列的原因是因为防止出现身高相同体重递增
        //那么就会求解错误，这时问题就转化成求解最长自增子序列
        Arrays.sort(nums,(o1, o2)-> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        //O(n)的求解最长递增子序列的方法
        int piles = 0;
        int[] table = new int[length];
        for(int i = 0; i < nums.length; i++){
            //要放入的数字
            int poker = nums[i][1];
            int left = 0;
            int right = piles;
            //找到最左边可以放置的数字，当poker大于所有牌堆顶部的元素时，就需要开一个新的牌堆
            //来放置元素
            while(left < right){
                int mid = left + (right - left)/2;
                if(table[mid] < poker){
                    left = mid + 1;
                } else{
                    right = mid;
                }
            }
            //开放一份新堆来放元素
            if(left == piles){
                piles++;
            }
            table[left] = poker;
        }
        //最后的牌堆数目就是最长的递增子序列
        return piles;
    }
}
