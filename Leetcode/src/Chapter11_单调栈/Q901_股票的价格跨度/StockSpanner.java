package Chapter11_单调栈.Q901_股票的价格跨度;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/12/2020 23:21
 **/

public class StockSpanner {

    int index;
    Stack <Integer> stack;
    Stack<Integer> indice;

    /**
     * 总体思路就是单调栈，只存储第一个大于当前元素的值，这样两者的索引相减就是小于等于当前元素
     * 的连续元素个数,这里用两个栈一个储存具体元素，一个存放索引
     */
    public StockSpanner() {
        index = 1;
        stack = new Stack<>();
        indice = new Stack<>();
    }

    public int next(int price) {
        if(stack.isEmpty()){
            stack.add(price);
            indice.add(index);
            index++;
            return 1;
        }else{
            //更新栈知道栈顶元素大于当前元素
            while(!stack.isEmpty() && price >= stack.peek()){
                stack.pop();
                indice.pop();
            }
            //计算两者之间的连续元素个数
            int res = indice.isEmpty() ? index :index - indice.peek();
            stack.push(price);
            indice.push(index++);
            return res;
        }
    }
}
