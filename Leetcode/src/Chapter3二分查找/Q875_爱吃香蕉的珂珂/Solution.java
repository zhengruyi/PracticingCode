package Chapter3二分查找.Q875_爱吃香蕉的珂珂;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/10/2020 17:08
 **/

public class Solution {
    /**
     * getHours()方法用来判断当前方法是否满足原来的条件
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int left = 1 ;
        int right = piles[piles.length - 1];
        while(left <= right){
            int mid = left + (right - left )/2;
            int hours = getHours(piles,mid);
            if(hours == H){
                right = mid -1;
            }else if(hours < H){
                right = mid - 1;
            }else if(hours > H){
                left = mid +1;
            }
        }
        return left;
    }
    public int getHours(int[] piles, int K){
        int count = 0;
        for(int i: piles){
            if(K > i){
                count++;
            }else{
                //求解上限的小技巧
                count+= (i+K-1)/K;
            }
        }
        return count;
    }
}
