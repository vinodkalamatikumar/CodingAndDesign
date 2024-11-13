package designPatterns.structural.Decorator;

public class CheeseDecorator extends PizzaDecorator{


    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + "added cheese";
    }

    @Override
    public int cost() {
        return decoratedPizza.cost()+5;
    }
}
