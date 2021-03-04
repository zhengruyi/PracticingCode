package Chapter0_其他.Q575_分糖果;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/03/2021 23:41
 **/

public class Solution {
    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set <Integer> set = new HashSet();
        for(int num : candyType){
            set.add(num);
        }
        //糖果种类最多是数组长度的一半,较少时就是全部的种类
        return set.size() >= len/2 ? len /2 : set.size();
    }
}
