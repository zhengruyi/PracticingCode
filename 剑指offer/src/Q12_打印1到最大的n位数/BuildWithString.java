package Q12_打印1到最大的n位数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 16:10
 **/

public class BuildWithString {
    public static void getNumber(int n) {
        if (n <= 0)
            return;
        char[] nums = new char[n + 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = '0';
        }

        while (!increment(nums)) {
            printNumber(nums);
        }
    }

    public static boolean increment(char[] nums) {
        boolean isOverFlow = false;
        int takeOver = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = nums[i] - '0' + takeOver;
            if (i == nums.length - 1)
                sum++;

            if (sum >= 10) {
                takeOver = 1;
                nums[i] = (char) (sum - 10 + '0');
            } else {
                nums[i] = (char) (sum + '0');
                break;
            }
        }
        if (nums[0] == '1')
            return true;
        else
            return false;

    }

    public static void printNumber(char[] nums) {
        System.out.println(nums);
    }

    public static void main(String[] args) {
         getNumber(2);
    }
}
