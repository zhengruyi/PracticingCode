package Chapter0_功能验证性代码.Q10_考试策略;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/07/2020 13:48
 **/
/*
小明同学在参加一场考试，考试时间2个小时。试卷上一共有n道题目，小明要在规定时间内，完成一定数量的题目。  考试中不限制试题作答顺序，对于 i 第道题目，小明有三种不同的策略可以选择:  (1)直接跳过这道题目，不花费时间，本题得0分。

(2)只做一部分题目，花费pi分钟的时间，本题可以得到ai分。  (3)做完整个题目，花费qi分钟的时间，本题可以得到bi分。

小明想知道，他最多能得到多少分。

输入描述:
第一行输入一个n数表示题目的数量。

接下来n行，每行四个数p_i，a_i，q_i，b_i。(1≤n≤100，1≤p_i≤q_i≤120，0≤a_i≤b_i≤1000
)。
输出描述:
输出一个数，小明的最高得分。
示例1
输入
4
20 20 100 60
50 30 80 55
100 60 110 88
5 3 10 6

输出
94
 */
public class Solution {
    int n = 4;
    int[] p = new int[125];
    int[] q = new int[125];
    int[] a = new int[125];
    int[] b = new int[125];
    int[] dp = new int[125];

    public int getMaxScore() {
        p[0] = 20;
        a[0] = 20;
        q[0] = 100;
        b[0] = 60;

        p[1] = 50;
        a[1] = 30;
        q[1] = 80;
        b[1] = 55;

        p[2] = 100;
        a[2] = 60;
        q[2] = 110;
        b[2] = 88;

        p[3] = 5;
        a[3] = 3;
        q[3] = 10;
        b[3] = 6;
        int i;
        for (i = 0; i < n; i++) {
            for (int j = 120; j >= 0; j--) {
                if (p[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - p[i]] + a[i]);
                }
                if (q[i] <= j)   //考虑这一题只做一半
                    dp[j] = Math.max(dp[j], dp[j - q[i]] + b[i]);
            }
        }
        return dp[120];

    }

    @Test
    void test() {
        Assertions.assertEquals(94, getMaxScore());
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,54,65,234};
        Arrays.sort(nums);

    }

}
