package Chapter0_其他.Q172_阶乘后的零;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/10/2020 20:27
 **/

public class Solution {
    public int trailingZeroes(int n) {
        if(n < 0){
            return 0;
        }
        int res = 0;
        int index = 5;
        //计算阶乘后有多少个0，其实就是看有多少个5，因为2的倍数远比5的倍数多，
        //首先计算有多少个5，然后有多少是25的倍数，需要额外多一个0，有多少是125的倍数，
        //在额外多一个0，以此类推.
        while(index <= n){
            res+= n/index;
            index = index * 5;
        }
        return res;
    }
}
