package designPatterns.structural.Decorator;

public class MushroomDecorator extends PizzaDecorator {


    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"added mushroom";
    }

    @Override
    public int cost() {
        return super.cost() + 5;
    }
}
