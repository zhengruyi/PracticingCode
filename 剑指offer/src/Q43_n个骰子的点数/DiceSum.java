package Q43_n个骰子的点数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 21:52
 **/

public class DiceSum {
    static final int MAX_VALUE = 6;

    public static void getProbability(int n) {
        if(n < 1)
            return;

        int[] probability = new int[MAX_VALUE * n - n + 1];
        for (int i = 1; i <= MAX_VALUE; i++) {
            calculateProbability(n, n, i, probability);
        }
        double total =  Math.pow(6,n);
        for (int i = 0; i < probability.length; i++) {
            System.out.printf("sum = %d, times = %d, prob = %f \n", i+n, probability[i], probability[i]/total);
        }
    }
    public static void calculateProbability(int origin, int current, int sum, int[] prob){
        if(current == 1){
            prob[sum - origin] +=  1;
            return;
        }
        for (int i = 1; i <= MAX_VALUE; i++) {
            calculateProbability(origin,current - 1, sum+i,prob);
        }
    }

    public static void main(String[] args) {
        getProbability(2);
    }
}
