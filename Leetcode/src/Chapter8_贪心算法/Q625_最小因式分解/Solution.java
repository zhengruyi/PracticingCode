package Chapter8_贪心算法.Q625_最小因式分解;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/01/2021 19:45
 **/

public class Solution {
    /**
     * 首先固定哪些因数的乘积等于目标值，从9开始搜索一直递减到2,并且放置顺序是从低位到高位
     * 因为题目要求这些因数组成的数字最小，另外如果数字的因子中有超过10的质数比如11,13时
     * 返回0,因为题目要求用一个数位来表示一个因数也就是说因数只能等于2 ~ 9
     * @param a
     * @return
     */
    public int smallestFactorization(int a) {
        if(a < 2){
            return a;
        }
        long res = 0;
        long mul = 1;
        //因数从2..9，优先尽可能求出较大的因数放置在末尾
        for(int i = 9; i >= 2; i--){
            while( a % i == 0){
                a /= i;
                //计算因数数位组成的数字
                res = i * mul + res;
                mul *= 10;
            }
        }
        //检测数字中是否有包含很大的质数因子，以及结果是否超出int范围
        return a < 2 && res <= Integer.MAX_VALUE ? (int) res : 0;
    }
}
