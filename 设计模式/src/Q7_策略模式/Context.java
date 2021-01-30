package Q7_策略模式;

import Q7_策略模式.Strategy.Strategy;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 00:04
 **/

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public int executeStrategy(int num1, int num2){
        return this.strategy.doOperation(num1,num2);
    }
}
