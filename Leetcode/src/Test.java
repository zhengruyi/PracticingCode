import Chapter13_二叉树.TreeNode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    @org.junit.jupiter.api.Test
    void test() {
       int[] position = {-2,0,1,3};
       threeSumSmaller(position,2);
    }

    public static void main(String[] args) {
        System.out.println(IntStream.range(0,4).sum());
    }
    int[] dx = {-2,-2,-1,-1,1,1,2,2};
    int[] dy = {1,-1,2,-2,2,-2,1,-1};
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int sum = target - nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = nums.length - 1; k > j; k--){
                    if(nums[j] + nums[k] < sum){
                        res += k - j;
                    }
                }
            }
        }
        return res;
    }
}
class Car{
    int position;
    double time;
    public Car(int position, double time){
        this.position = position;
        this.time = time;
    }
}