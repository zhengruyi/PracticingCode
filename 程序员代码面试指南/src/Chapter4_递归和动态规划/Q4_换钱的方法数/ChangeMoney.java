package Chapter4_递归和动态规划.Q4_换钱的方法数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/06/2020 10:42
 **/

public class ChangeMoney {
    public int changeWithRecursive(int[] arr, int aim) {
        if (arr == null || aim < 0 || arr.length == 0) {
            return 0;
        }
        return processRecursive(arr, 0, aim);
    }

    public int processRecursive(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * arr[index] <= aim; i++) {
                res += processRecursive(arr, index + 1, aim - i * arr[index]);
            }
        }
        return res;
    }

    public int changeWithMemorySearch(int[] arr, int aim) {
        if (arr == null || aim < 0 || arr.length == 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];

        return processWithMemorySearch(arr, 0, aim, map);
    }

    public int processWithMemorySearch(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; i * arr[index] <= aim; i++) {
                mapValue = map[index][aim - i * arr[index]];
                if(mapValue != 0){
                    res += mapValue == -1 ? 0 : mapValue;
                }else{
                    res += processWithMemorySearch(arr, index + 1, aim - i * arr[index], map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    public int changeWithDynamicPlan(int[] arr, int aim){
        if (arr == null || aim < 0 || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i*arr[0] < dp[0].length; i++) {
            dp[0][i*arr[0]] =1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j-arr[i] >=0 ?dp[i][j-arr[i]] : 0;
            }
        }
        return dp[arr.length -1][aim];
    }

    @Test
    void test() {
        Assertions.assertEquals(6, changeWithRecursive(new int[]{5, 10, 25, 1}, 15));
        Assertions.assertEquals(0, changeWithRecursive(new int[]{5, 3}, 2));
    }

    @Test
    void testWithMemorySearch() {
        Assertions.assertEquals(6, changeWithRecursive(new int[]{5, 10, 25, 1}, 15));
        Assertions.assertEquals(0, changeWithRecursive(new int[]{5, 3}, 2));
    }

    @Test
    void testWithDynamicPlan(){
        Assertions.assertEquals(6, changeWithDynamicPlan(new int[]{5, 10, 25, 1}, 15));
        Assertions.assertEquals(0, changeWithDynamicPlan(new int[]{5, 3}, 2));
    }
}
