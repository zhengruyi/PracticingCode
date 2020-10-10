package Q3_二维数组查找;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/04/2020 22:05
 **/
// 从二维有序数组中查找某个数字，重点需要找到右上角这个点来缩小查询范围.
public class FoundInMatrix {

    public static boolean find(int[][] matrix, int rows, int columns, int target) {
        boolean found = false;
        if (matrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (matrix[row][column] == target) {
                    found = true;
                    break;
                } else if (matrix[row][column] > target)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }

    @Test
    void test() {
        int[][] list = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int rows = 4;
        int columns = 4;

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(list, 4, 4, 1)),
                () -> Assertions.assertTrue(find(list, 4, 4, 15)),
                () -> Assertions.assertTrue(find(list, 4, 4, 10)),
                () -> Assertions.assertFalse(find(list, 4, 4, -2)),
                () -> Assertions.assertFalse(find(list, 4, 4, 17)),
                () -> Assertions.assertFalse(find(list, 4, 4, 14)),
                () -> Assertions.assertFalse(find(null, 4, 4, 1))
        );
    }
}



