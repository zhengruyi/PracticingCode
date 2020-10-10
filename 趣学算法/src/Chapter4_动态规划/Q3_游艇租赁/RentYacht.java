package Chapter4_动态规划.Q3_游艇租赁;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/07/2020 19:31
 **/

public class RentYacht {
    public static void miniCost(int[][] costs, int nums) {
        int[][] record = new int[nums][nums];
        int[][] miniCost = new int[nums][nums];
        for (int i = 1; i < nums; i++) {
            for (int j = 0; j + i < nums; j++) {
                miniCost[j][j + i] = costs[j][j + i];
            }
        }
        for (int i = 2; i < nums; i++) {
            for (int j = 0; j + i < nums; j++) {
                int min = costs[j][j + i];
                for (int k = j + 1; k < j + i; k++) {
                    int sum = miniCost[j][k] + miniCost[k][j + i];
                    if(min > sum){
                        min = sum;
                        record[j][j + i] = k;
                    }
                }
                miniCost[j][j + i] = min;
            }
        }
        System.out.println(miniCost[0][nums - 1]);

    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] costs = {
                {0, 2, 6, 9, 15, 20},
                {m, 0, 3, 5, 11, 18},
                {m, m, 0, 3, 6, 12},
                {m,m,m,0,5,8},
                {m, m, m, m, 0, 6},
                {m, m, m, m, m, 0}
        };
        miniCost(costs, 6);
    }
}
