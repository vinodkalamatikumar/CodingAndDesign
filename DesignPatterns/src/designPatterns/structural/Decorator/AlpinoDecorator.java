package designPatterns.structural.Decorator;

public class AlpinoDecorator extends PizzaDecorator{
    public AlpinoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "added Alpino";
    }

    @Override
    public int cost() {
        return super.cost() + 6;
    }
}
