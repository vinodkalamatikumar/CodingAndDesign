package designPatterns.structural.Decorator;

public class BasePizza implements Pizza{

    @Override
    public String getDescription() {
        return "Base pizza";
    }

    @Override
    public int cost() {
        return 10;
    }
}
