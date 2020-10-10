package Q40_数组中只出现一次的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/04/2020 13:33
 **/

public class FindNumbers {
    public static void find(int[] nums){
        if(nums == null || nums.length < 2)
            throw  new RuntimeException();
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int index = 1;
        int threshold = index & xor;
        while(threshold == 0){
            index = index << 1;
            threshold = index & xor;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = threshold & nums[i];
            if(temp == 0){
                num1 = num1 ^ nums[i];
            }else{
                num2 = num2 ^ nums[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,5,2,5,7};
        find(nums);
        nums = new int[]{1, 2, 3, 4};
        find(nums);
    }
}
