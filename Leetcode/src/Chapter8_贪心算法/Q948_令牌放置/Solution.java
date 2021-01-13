package Chapter8_贪心算法.Q948_令牌放置;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 16:47
 **/

public class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        //对所有令牌进行排序
        Arrays.sort(tokens);
        int lo = 0;
        int hi = tokens.length - 1;
        int points = 0;
        int ans = 0;
        //重要能量还可以翻牌子或者还有point就可以继续遍历
        while(lo <= hi && (points > 0 || P >= tokens[lo])){
            while(lo <= hi && P >= tokens[lo]){
                //由于前面的牌子能量都小序偶一尽可能翻出来或得点数
                P -= tokens[lo++];
                points++;
            }
            //由于最后是看point最多的，所以在尽可能获得点数后取全局最大值
            ans = Math.max(ans,points);
            //从末尾翻用最少的点数获取最多的能量
            if(lo <= hi && points > 0){
                P += tokens[hi--];
                points--;
            }
        }
        return ans;
    }
}
