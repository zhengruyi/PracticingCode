import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static void main(String[] args) {
        numSquares(12);
    }
    public static int numSquares(int n) {
        int len = (int)Math.sqrt(n) + 1;
        int[] nums = new int[len+1];
        for(int i =1; i <= len; i++){
            nums[i] = i * i;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        for(int i = 1; i<=n; i++){
            for(int j =1; j <= len; j++){
                if(i < nums[j]){
                    break;
                }
                dp[i] = Math.min(dp[i],dp[i-nums[j]]+1);
            }
        }
        return dp[n];
    }
}
