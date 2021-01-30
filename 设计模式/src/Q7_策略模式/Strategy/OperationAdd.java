package Q7_策略模式.Strategy;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 00:02
 **/

public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
