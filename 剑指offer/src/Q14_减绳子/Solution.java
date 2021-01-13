package Q14_减绳子;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:18
 **/

public class Solution {
    /**
     * 具体的证明在如下链接:https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     * 可以在减出的绳子长度为3时，可以证明乘积最大
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int a = n /3;
        int b = n %3;
        if( b == 0){
            return (int) Math.pow(3,a);
        }else if(b == 1){
            //因为1*3  < 2 * 2，所以当剩下一段绳子长度为1时，则可以变成2 * 2
            return (int)Math.pow(3,a-1) * 4;
        }else{
            return (int)Math.pow(3,a) * 2;
        }
    }
}
