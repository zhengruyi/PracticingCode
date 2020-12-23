package Chapter0_其他.Q307_区域和检索_数组可修改;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/12/2020 20:53
 **/

public class NumArray {

    int[] nums;
    FenwickTree tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new FenwickTree(nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            tree.update(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        tree.update(i + 1, delta);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int s1 = tree.queryUntil(i);
        int s2 = tree.queryUntil(j + 1);
        return s2 - s1;
    }
}

/**
 * 树状数组，可以在olog(n)的时间复杂度求得区间和，也可以在o(logn)的时间复杂度内
 * 更新区间和，相比于前缀和数组做大的优势在于可以更快地更新区间和
 */
class FenwickTree {
    private int[] tree;
    private int len;

    public FenwickTree(int len) {
        tree = new int[len];
        this.len = len;
    }

    /**
     * 更新区间
     * @param index
     * @param delta
     */
    public void update(int index, int delta) {
        for (int i = index; i < len; i += lowBit(i)) {
            tree[i] += delta;
        }
    }

    /**
     * 区间和，求解从[0,i)的区间和
     * @param i
     * @return
     */
    public int queryUntil(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }

    /**
     * 返回最低位1的位置代表的数字
     * @param n
     * @return
     */
    public int lowBit(int n) {
        return n & (-n);
    }
}

