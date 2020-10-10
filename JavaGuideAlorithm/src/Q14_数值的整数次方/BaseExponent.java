package Q14_数值的整数次方;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/05/2020 21:59
 **/

public class BaseExponent {
    public static double myPow(double x, int n) {
        /*
        //普通计算方法，速度慢
        if(x == 0 && n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int flag = n > 0 ? 1 : -1;
        n = n > 0 ? n : -1 * n;
        int gap = n;
        double result = 1.0;
        while(gap > 0){
            int times = 1;
            double temp = x;
            while(times + times <= gap){
                temp *= temp;
                times += times;
            }
            gap = gap - times;
            result *= temp;
        }
        if(flag > 0){
            return result;
        }else{
            return 1.0/result;
        }

         */
        //快速幂极速方法，解释:https://zhuanlan.zhihu.com/p/95902286
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.00001,2147483647));
    }
}
