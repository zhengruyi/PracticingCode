package Chapter0_其他.Q423_从英文中重建数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:25
 **/

/**
 * 因此，我们需要寻找一些独特的标志。注意到，所有的偶数都包含一个独特的字母：
 * “z” 只在 “zero” 中出现。
 * “w” 只在 “two” 中出现。
 * “u” 只在 “four” 中出现。
 * “x” 只在 “six” 中出现。
 * “g” 只在 “eight” 中出现。
 * 因此，从偶数开始是一个很好的思路。
 * <p>
 * 这也是计算 3，5 和 7 的关键，因为有些单词只在一个奇数和一个偶数中出现（而且偶数已经被计算过了）：
 * <p>
 * “h” 只在 “three” 和 “eight” 中出现。
 * “f” 只在 “five” 和 “four” 中出现。
 * “s” 只在 “seven” 和 “six” 中出现。
 * 接下来只需要处理 9和 0，思路依然相同。
 * <p>
 * “i” 在 “nine”，“five”，“six” 和 “eight” 中出现。
 * “n” 在 “one”，“seven” 和 “nine” 中出现。
 **/
public class Solution {

    public String originalDigits(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        int[] count = new int[10];
        count[0] = nums['z' - 'a'];
        count[2] = nums['w' - 'a'];
        count[4] = nums['u' - 'a'];
        count[6] = nums['x' - 'a'];
        count[8] = nums['g' - 'a'];
        count[3] = nums['h' - 'a'] - count[8];
        count[5] = nums['f' - 'a'] - count[4];
        count[7] = nums['s' - 'a'] - count[6];
        count[9] = nums['i' - 'a'] - count[5] - count[6] - count[8];
        count[1] = nums['n' - 'a'] - count[7] - count[9] * 2;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}

