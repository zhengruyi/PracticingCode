package Chapter0_其他.Q1561_你可以获得的最大硬币数目;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/02/2021 21:12
 **/

public class Solution {
    /**
     * 由于最大的一堆会被别人拿走，所以要想自己拿的比较多,那么就需要自己的这堆是剩下的堆中最大的一个
     * 所以先对所有数组元素排序,然后将每次取两个最大值，一个最小值，那么就嫩恶搞保证自己拿到的硬币总数最多
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int left = 0;
        int right = piles.length - 1;
        int res = 0;
        while(left < right - 1){
            res += piles[right - 1];
            right -= 2;
            left++;
        }
        return res;
    }
}
