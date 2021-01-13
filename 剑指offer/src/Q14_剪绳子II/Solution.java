package Q14_剪绳子II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 19:39
 **/

public class Solution {
    public int cuttingRope(int n) {
        int mod = 1_000_000_000 + 7;
        //由于必须切一次，所以长度小于3时需要特殊处理
        if(n <= 3){
            return n-1;
        }
        //由于3是最优解，所以这里计算出长度是3的多少倍
        int times = n / 3;
        int remainder = n % 3;
        //用long来保存乘积结果，防止溢出
        long ans = 1;
        for(int i = 1; i < times; i++){
            ans = ans * 3;
            ans = ans % mod;
        }
        //根据余下的长度进行不同的处理,如果剩下1由于3*1 <2 * 2所以最后一部分切成2 * 2
        if(remainder == 0){
            return (int)(ans * 3 % mod);
        }else if(remainder == 1){
            return (int)(ans * 4 % mod);
        }else{
            return (int)(ans * 3 * 2 % mod);
        }
    }
}
