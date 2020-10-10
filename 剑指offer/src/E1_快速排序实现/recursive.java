package E1_快速排序实现;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/04/2020 21:54
 **/

public class recursive {
    private static int partion(int[] nums, int left, int right) {
        //现在起始点挖个坑
        int temp = nums[left];
        //退出条件是两个搜索点相遇，也是我们埋下中间值的地点
        while (left < right) {
            //因为坑在开头，要埋下一个比中间值要小的数字，所以从右边开始搜索
            while (nums[right] >= temp && left < right)
                right--;
            //退出条件可能有找到一个比中间值还要小的值或者两个搜索节点相遇,所以需要明确交换条件
            if (left < right) {
                nums[left] = nums[right];
                //埋下新值后,这个坑就不需要再搜索范围内了，所以加一
                left++;
            }
            // 填完左边的坑后，右边空出来一个坑，所以要从左边找一个值填进去
            while (nums[left] <= temp && left < right)
                left++;
            if (left < right) {
                nums[right] = nums[left];
                //填完后右边的值一定满足条件,不用在考虑了
                right--;
            }
        }
        //左右索引相遇的点就是最终的坑位置，把开头的中间值埋下去就完成这次操作，返回中间值在数组中的位置
        nums[left] = temp;
        return left;
    }

    public static void quickSort(int[] nums, int left, int right) {
        //当left==right时数组只有一个元素要排序直接返回
        if (nums == null || left >= right || nums.length == 1)
            return;
        int mid = partion(nums, left, right);
        quickSort(nums, left, mid);
        quickSort(nums, mid+1, right);

    }


    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,6,8,12,45,61,4,6,-12};
        quickSort(nums,0,nums.length-1);
        printArr(nums);
    }
}
