package E2_归并排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/04/2020 18:35
 **/

public class MergeSort {

    public static void mergeSort(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] temp = new int[nums.length];
        sort(nums, start, end, temp);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (right + left) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }

        while (j <= right) {
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 5, 3, 6, 8, 10, 14, -5};
        mergeSort(nums);
    }
}
