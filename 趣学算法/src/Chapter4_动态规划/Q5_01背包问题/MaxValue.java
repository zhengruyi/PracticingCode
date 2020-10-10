package Chapter4_动态规划.Q5_01背包问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/07/2020 20:11
 **/

public class MaxValue {
    public static void maxValue(int[] weights, int[] values, int volume) {
        int len = weights.length;
        int[][] maxValue = new int[len + 1][volume + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= volume; j++) {
                if (j >= weights[i - 1]) {
                    maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    maxValue[i][j] = maxValue[i - 1][j];
                }
            }
        }
        System.out.println("Max values: " + maxValue[len][volume]);
        int v = volume;
        for (int i = len; i >= 1; i--) {
            if (maxValue[i][v] > maxValue[i - 1][v]) {
                System.out.println("choose " + i);
                v -= weights[i-1];
            }
        }
    }

    public static void main(String[] args) {
        int[] weights = {2, 5, 4, 2, 3};
        int[] values = {6, 3, 5, 4, 6};
        maxValue(weights, values, 10);
    }
}
