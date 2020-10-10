package Chapter3_二叉树问题.Q14_根据后序数组重建二叉搜索树;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/06/2020 21:56
 **/

public class CheckPostArray {
    public boolean isPostArray(int[] array){
        return checkPostArray(array,0,array.length -1);
    }
    public boolean checkPostArray(int[] array, int start, int end){
        if(start == end){
            return true;
        }
        //初始化左子树的终点
        int leftEnd = -1;
        //初始化右子树的起点
        int rightStart = end;
        for (int i = start; i < end; i++) {
            if(array[i] < array[end]){
                //动态更新左子树的终点
                leftEnd = i;
            }else{
                //只更新一次右子树的起点
                rightStart = rightStart == end ? i : rightStart;
            }
        }
        //表示左子树和右子树中只存在一个
        if(rightStart == end || leftEnd == -1){
            return checkPostArray(array,start, end -1);
        }
        //一般情况下左子树终点和右子树的起点相邻
        if(rightStart != leftEnd +1){
            return false;
        }
        //分别检验其左子树和右子树的是否是二叉搜索树
        return checkPostArray(array,start,leftEnd) && checkPostArray(array,rightStart,end -1);
    }
    @Test
    void test(){
        int[] array = {1,4,3,6,8,7,5};
        Assertions.assertTrue(isPostArray(array));
        array = new int[]{1,7,3,2,7,5,4};
        Assertions.assertFalse(isPostArray(array));
    }
}
