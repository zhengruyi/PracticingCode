package Chapter0_其他.Q771_宝石与石头;

import java.util.HashSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/03/2021 23:30
 **/

public class Solution {
    /**
     * 简单的搜索
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        HashSet <Character> set = new HashSet();
        for(int i = 0; i < jewels.length(); i++){
            set.add(jewels.charAt(i));
        }
        int res = 0;
        for(int j = 0; j < stones.length(); j++){
            if(set.contains(stones.charAt(j))){
                res++;
            }
        }
        return res;
    }
}
