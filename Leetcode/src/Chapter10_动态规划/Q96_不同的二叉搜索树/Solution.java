package Chapter10_动态规划.Q96_不同的二叉搜索树;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 20:50
 **/

public class Solution {
    /**
     * 题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
     *
     * G(n)G(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数。
     *
     * F(i, n)F(i,n): 以 ii 为根、序列长度为 nn 的不同二叉搜索树个数 (1 \leq i \leq n)(1≤i≤n)。
     *
     * 可见，G(n)G(n) 是我们求解需要的函数。
     *
     * 稍后我们将看到，G(n)G(n) 可以从 F(i, n)F(i,n) 得到，而 F(i, n)F(i,n) 又会递归地依赖于 G(n)G(n)。
     *
     * 首先，根据上一节中的思路，不同的二叉搜索树的总数 G(n)G(n)，是对遍历所有 ii (1 \le i \le n)(1≤i≤n) 的 F(i, n)F(i,n) 之和。换言之：
     *
     * G(n) = i=1∑n F(i,n)
     * G(n)= i=1∑n G(i−1)⋅G(n−i)
     * G(i-1)表示左边可以构成的二叉搜索树数目, G(n-i)表示右边可以构成的二叉搜索树数目,则总共可以表示的种类数是两者的乘积
     **/
    public int numTrees(int n) {
        if( n == 0 || n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            int tmp = 0;
            for(int j = 1; j <= i; j++){
                tmp += dp[j-1] * dp[i-j];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
}
