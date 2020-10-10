package Others.Q1吃葡萄;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/10/2020 22:46
 * @url https://www.nowcoder.com/questionTerminal/14c0359fb77a48319f0122ec175c9ada
 **/
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    /**
     * 注意多组数据和数据量很大的情况用long代替Int
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        while(sc.hasNextLong()){
            long[] nums = new long[3];
            nums[0] = sc.nextLong();
            nums[1] = sc.nextLong();
            nums[2] = sc.nextLong();
            Arrays.sort(nums);
            long x = (nums[0] + nums[1] + nums[2] + 2) / 3;
            if(nums[0]+nums[1] > nums[2]){
                System.out.println(x);
            }else if(nums[2] <= 2*(nums[0]+nums[1])){
                System.out.println(x);
            }else{
                System.out.println((nums[2]+1)/2);
            }
        }

    }
}
