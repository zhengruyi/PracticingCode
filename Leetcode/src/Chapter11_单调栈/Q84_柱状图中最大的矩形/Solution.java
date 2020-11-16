package Chapter11_单调栈.Q84_柱状图中最大的矩形;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/11/2020 22:16
 **/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1){
            return heights[0];
        }
        int len = heights.length;
        //这里采用哨兵优化的思想申请一个更大的数组，在开头和结尾各自放置一个哨兵
        //这样的好处是可以不用单独考虑栈中没有元素的情况，应为肯定存在一个元素(哨兵)
        //并且也不用考虑原数组遍历完毕后，栈不空需要特殊处理的情况，应为后哨兵的存在
        //所有'修饰后'的数组遍历完后就可以直接算出来
        int[] newHeights = new int[len+2];
        System.arraycopy(heights,0,newHeights,1,len);
        newHeights[0] = 0;
        newHeights[len+1] = 0;
        Stack <Integer> stack = new Stack<Integer>();
        stack.push(0);
        heights = newHeights;
        len+=2;
        int area = 0;
        for(int i = 1; i < len; i++){
            //采用单调增数组，因为如果当前元素比栈顶元素还小，那么对于栈顶元素来说它的右边界
            //就已经找到了，而他的左边界在栈中，为了方便的计算出矩形的宽度，所以栈中存储的都是数组的下标
            //而栈顶元素所代表的的矩形已经找到了右边界，而左边界就在栈中，所以可以很方便的计算出面积
            while(heights[i] < heights[stack.peek()]){
                int h = heights[stack.pop()];
                area = Math.max(area, (i - stack.peek() -1) * h);
            }
            stack.push(i);
        }
        return area;
    }
}
