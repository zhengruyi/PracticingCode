import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    public static void main(String[] args) {
        nthUglyNumber(10);
    }
    public static int nthUglyNumber(int n){
            int i2 = 0;
            int i3 = 0;
            int i5 = 0;
            int times = 1;
            int index = 0;
            int[] nums = new int[1690];
            nums[0] = 1;
            for(int i = 1; i < n; ++i) {
                int ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;
                if (ugly == nums[i2] * 2) ++i2;
                if (ugly == nums[i3] * 3) ++i3;
                if (ugly == nums[i5] * 5) ++i5;
            }
            return nums[n-1];
        }
}
