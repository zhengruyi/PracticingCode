package Q43_n个骰子的点数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 22:14
 **/

public class DiceSumWithLoop {
    static final int MAX_VALUE = 6;
    public static void getProbability(int n){
        if( n < 1)
            return;
        int[][] prob = new int[2][MAX_VALUE * n + 1];
        int flag = 0;
        for (int i = 1; i <= MAX_VALUE; i++) {
            prob[flag][i] = 1;
        }
        //除去第一个用于初始化的骰子之外 还有n-1要计算
        for (int i = 2; i <= n; i++) {
            // 第n个骰子的和范围是i~i*MAX_VALUE
            for (int j = i; j <= MAX_VALUE*i ; j++) {
                // 计算 f(n) = f(n-1)+f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(n-6);但是要注意 f(2)~f(5)的边界情况
                for (int k = 1; k <= j && k <= MAX_VALUE; k++) {
                    prob[1-flag][j] += prob[flag][j - k];
                }
            }
            flag = 1 - flag;
        }
        double total =  Math.pow(6,n);
        for (int i = n; i <= n* MAX_VALUE; i++) {
            System.out.printf("sum = %d, times = %d, prob = %f \n", i, prob[flag][i], prob[flag][i]/total);
        }

    }

    public static void main(String[] args) {
        getProbability(2);
    }
}
