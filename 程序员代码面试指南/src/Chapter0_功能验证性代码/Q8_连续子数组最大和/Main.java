package Chapter0_功能验证性代码.Q8_连续子数组最大和;

import java.util.Scanner;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/07/2020 15:52
 **/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        int index = 0;
        while (sc.hasNext()) {
            nums[index++] = Integer.parseInt(sc.nextLine());
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}

