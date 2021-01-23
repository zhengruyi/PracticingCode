package Chapter0_其他.Q822_翻转卡片游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:14
 **/

public class Solution {
    /**
     * 由于不限制开篇的翻转次数，所以只要不是卡片的正反面的数字相同
     * 那么一定可以通过有限次的翻转来将较小的数字翻转到背面
     * @param fronts
     * @param backs
     * @return
     */
    public int flipgame(int[] fronts, int[] backs) {
        int[] res = new int[2001];
        for(int i = 0; i < fronts.length; i++){
            //排除正反面相同的数字
            if(fronts[i] == backs[i]){
                res[fronts[i]] = Integer.MIN_VALUE;
            }
            //统计数字出现的频率
            res[fronts[i]]++;
            res[backs[i]] ++;

        }
        //最小的数字就是答案
        for(int i = 0; i < res.length; i++){
            if(res[i] > 0){
                return i;
            }
        }
        return 0;
    }
}
