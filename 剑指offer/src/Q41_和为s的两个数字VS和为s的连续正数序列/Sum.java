package Q41_和为s的两个数字VS和为s的连续正数序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 16:44
 **/

public class Sum {
    //在排序好的数组中找到两个数的和为给定的值
    public static void findTwoNumber(int[] nums, int n){
        if(nums == null || nums.length <2)
            return;
        int small = 0;
        int big = nums.length - 1;
        while( small < big){
            if(nums[small] + nums[big] == n){
                System.out.printf(" n1: %d n2: %d", nums[small], nums[big]);
                System.out.println();
                small++;
            }else if(nums[small] + nums[big] < n){
                small++;
            }else{
                big -- ;
            }
        }
    }
    // 给定一个正整数n,打印出所有和为n的连续正正数序列
    public static void findLotsOfNumbers(int n){
        if(n < 3)
            return;
        int sum;
        int big = 2;
        int small = 1 ;
        sum = big + small;
        while(small < (n+1) / 2){
            if(sum == n){
                for (int i = small; i <= big; i++) {
                    System.out.print(i);
                }
                System.out.println();
                big++;
                sum += big;
            }else if(sum < n){
                big++;
                sum += big;
            }else{
                sum -= small;
                small++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15};
        findTwoNumber(nums,15);
        findLotsOfNumbers(15);
        findLotsOfNumbers(100);
    }
}
