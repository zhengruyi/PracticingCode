package Chapter0_其他.Q877_石子游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/10/2020 12:51
 **/

public class Solution {
    public boolean stoneGame(int[] piles) {
        //可以将piles分成奇数堆和偶数堆，先手的人可以选择要奇数还是偶数堆，所以先手必胜
        return true;
        /*
        if(piles == null || piles.length == 0){
            return false;
        }
        int len = piles.length;
        Tuple[] dp = new Tuple[len];
        for(int i = 0; i < len; i++){
            dp[i] = new Tuple(piles[i],0);
        }
        for(int i = len-1; i>= 0; i--){
            for(int j = i+1; j < len; j++){
                int fir = Math.max(dp[j].second+piles[i], dp[j-1].second+piles[j]);
                int sec = fir == dp[j].second+piles[i]? dp[j].first : dp[j-1].first;
                dp[j] = new Tuple(fir,sec);
            }
        }
        return dp[len-1].first > dp[len-1].second;
        */
    }
}
class Tuple{
    int first;
    int second;
    public Tuple(int i, int j){
        first = i;
        second = j;
    }
}
