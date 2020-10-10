package Q14_调整数组顺序使得期数位于偶数数组前面;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 21:17
 **/

public class Partition {
    public void partition(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && !isEvent(nums[start]))
                start++;
            while (start < end && isEvent(nums[end]))
                end--;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }

    public boolean isEvent(int n) {
        return (n & 0x1) == 0;
    }
}

class SubPartion extends Partition {
    @Override
    public boolean isEvent(int n) {
        return n >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 1, 3, 5, 7};
        new Partition().partition(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        int[] list = {3, 5, 7, -12, -5};
        new SubPartion().partition(list);
        System.out.println();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
        }
    }
}
