package Chapter0_其他.Q1431_拥有最多糖果的孩子;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/02/2021 19:24
 **/

public class Solution {
    /**
     * 获取最大值，然后逐个比较
     * @param candies
     * @param extraCandies
     * @return
     */
    public List <Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList();
        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
