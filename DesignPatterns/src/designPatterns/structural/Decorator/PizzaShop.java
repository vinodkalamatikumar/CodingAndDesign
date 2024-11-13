package designPatterns.structural.Decorator;


/*
Imagine a pizza shop where customers can customize their pizzas with various toppings like cheese,
pepperoni, mushrooms, and olives. The goal is to create a flexible system that allows you to dynamically
add any combination of toppings to a base pizza without modifying the existing pizza classes or creating
numerous subclasses.
*/
public class PizzaShop {
    public static void main(String[] args) {

        Pizza orderedPizza = new MushroomDecorator(new AlpinoDecorator(new CheeseDecorator(new BasePizza())));
        System.out.println(orderedPizza.getDescription() + " cost " + orderedPizza.cost());

    }
}
