package Q45_圆圈中最后剩下的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 21:19
 **/

public class Solution {
    //https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for(int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }
        return ans;
    }
}
