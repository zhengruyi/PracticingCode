import Chapter13_二叉树.TreeNode;
import java.util.*;


/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/11/2020 12:55
 **/

public class Test {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        dfs(nums,Integer.MIN_VALUE,0);
        return res;
    }
    public void dfs(int[] nums,int last, int curr){
        if(curr == nums.length){
            if(tmp.size() >= 2){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if(nums[curr] >= last){
            tmp.add(nums[curr]);
            dfs(nums,nums[curr],curr+1);
            tmp.remove(tmp.size()-1);
        }
        if(nums[curr] != last){
            dfs(nums,last,curr+1);
        }
    }
    @org.junit.jupiter.api.Test
    void test(){
        int[] nums = {4,6,7,7};
        findSubsequences(nums);
    }

    public static void main(String[] args) {
        int x = 46339;
        System.out.println(x*x);
    }
}
