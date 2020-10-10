package Q12_打印1到最大的n位数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 17:40
 **/

public class Recursive {
    public static void getNumbers(int n){
        if (n <= 0)
            return;
        char[] nums = new char[n];
        for (int i = 0; i < 10; i++) {
            nums[0] = (char)(i + '0');
            printToMax(nums, n, 0);
        }
    }

    public static void printToMax(char[] nums, int length, int index){
        if( index == length - 1){
            System.out.println(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[index + 1] = (char)(i + '0');
            printToMax(nums, length,index+1);
        }
    }

    public static void main(String[] args) {
        getNumbers(2);
    }
}
