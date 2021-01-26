package Q4_建造者模式;

import Q4_建造者模式.Item.*;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/01/2021 19:44
 **/

public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
