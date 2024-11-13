package designPatterns.structural.Decorator;

public abstract class PizzaDecorator implements Pizza{

    Pizza decoratedPizza;

    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public int cost() {
        return decoratedPizza.cost();
    }
}
