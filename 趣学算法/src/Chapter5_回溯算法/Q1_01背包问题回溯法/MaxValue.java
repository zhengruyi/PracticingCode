package Chapter5_回溯算法.Q1_01背包问题回溯法;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/07/2020 16:33
 **/

public class MaxValue {
    static int cp = 0;
    static int bestValue = 0;
    static int cw = 0;
    static int volume = 0;
    static int[] weights;
    static int[] values;
    static int[] x;
    static int[] bestX;
    static int nums;
    public static void maxValue() {
        backTrack(1);
        System.out.println("Max Value : "+ bestValue);
        for (int i = 1; i <= nums; i++) {
            if(bestX[i] == 1){
                System.out.println("choose "+ i);
            }
        }
    }

    public static void backTrack(int t) {
        if(t >nums){
            for (int j = 0; j <= nums; j++) {
                bestX[j] = x[j];
            }
            bestValue = cp;
            return;
        }
        if(cw+weights[t] <= volume){
            x[t] = 1;
            cw += weights[t];
            cp += values[t];
            backTrack(t+1);
            cw -= weights[t];
            cp -= values[t];
        }
        if(bound(t+1) > bestValue){
            x[t] = 0;
            backTrack(t+1);
        }
    }

    public static int bound(int t) {
        int rp = 0;
        while (t <= nums) {
            rp += values[t];
            t++;
        }
        return cp +rp;
    }

    public static void main(String[] args) {
        weights = new int[]{0,2,5,4,2};
        values = new int[]{0,6,3,5,4};
        x = new int[weights.length];
        bestX = new int[weights.length];
        nums = 4;
        volume = 10;
        maxValue();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
