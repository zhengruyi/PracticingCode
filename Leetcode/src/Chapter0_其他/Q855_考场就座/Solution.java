package Chapter0_其他.Q855_考场就座;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/10/2020 21:43
 **/

public class Solution {
    Map <Integer,int[]> startMap;
    Map<Integer,int[]> endMap;
    TreeSet <int[]> set;
    int N;
    public Solution(int N) {
        startMap = new HashMap <Integer,int[]>();
        endMap = new HashMap<Integer,int[]>();
        this.N = N;
        this.set = new TreeSet<>((a,b)->{
            int distanceA = distance(a);
            int distanceB = distance(b);
            if(distanceA == distanceB){
                return b[0] - a[0];
            }
            return distanceA - distanceB;
        });
        set.add(new int[]{-1,N});
    }

    public int seat() {
        int[] nums = set.last();
        int x = nums[0];
        int y = nums[1];
        int mid;
        if(x == -1){
            mid = 0;
        }else if(y == N){
            mid = N -1;
        }else{
            mid = (y - x)/2 +x ;
        }

        removeInternal(nums);
        addInterval(new int[]{nums[0],mid});
        addInterval(new int[]{mid,nums[1]});
        return mid;
    }

    public void leave(int p) {
        int[] left = endMap.get(p);
        int[] right = startMap.get(p);
        removeInternal(left);
        removeInternal(right);
        addInterval(new int[]{left[0],right[1]});
    }
    public void addInterval(int[] nums){
        set.add(nums);
        startMap.put(nums[0],nums);
        endMap.put(nums[1],nums);
    }
    public void removeInternal(int[] nums){
        startMap.remove(nums[0]);
        endMap.remove(nums[1]);
        set.remove(nums);
    }
    public int distance(int[] nums){
        int x = nums[0];
        int y = nums[1];
        if(x == -1){
            return y;
        }else if(y == N){
            return N - x -1;
        }else{
            return (y - x)/2;
        }
    }
}
