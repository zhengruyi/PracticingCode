package Chapter7_位运算.Q2_不用任何比较判断找出两个数中较大的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/06/2020 14:02
 **/

public class GetMaxNumber {
    /**
     * 存在问题是a-b可能会出现溢出，导致出现问题
     * @param a
     * @param b
     * @return
     */
    public int get(int a, int b){
        int c = a -b;
        //判断c的最高位是0或者1，0表示c是正数，即a>b,反之 1表示c是负数，最高位是1
        int scA = (c >> 31) & 1;
        //scB取scA的反码
        int scB = scA ^ 1;
        //scA和scB必然有一个是0另外一个是1，通过这样来
        return scA * a + scB * b;

    }

    /**
     * 把ab分成符号相同和符号不同两种情况来讨论
     * @param a
     * @param b
     * @return
     */
    public int getMax2(int a, int b){
        int c = a - b;
        //分别求a，b，c最高为的符号位是0或者1
        int sa = (a >> 31) & 1;
        int sb = (b >> 31) & 1;
        int sc = (c >> 31) & 1;
        //如果sa和sb的符号位不同，那么表示a和b中有一个正数
        int diffSab = sa ^ sb;
        //如果sa和sb符号位相同，那么sameSab那么为1
        int sameSab = diffSab ^ 1;
        //如果sameSab为1，表示符号相同，那么sc就是最终结果
        int returnA = diffSab*sa + sameSab*sc;
        int returnB = returnA ^1;
        return a*returnA + b * returnB;
    }
}
