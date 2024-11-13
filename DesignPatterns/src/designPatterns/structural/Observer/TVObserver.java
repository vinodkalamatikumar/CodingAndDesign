package designPatterns.structural.Observer;

public class TVObserver implements Observer{

    float temp;
    @Override
    public void update(float temp) {
        this.temp= temp;
        display();

    }

    void display(){
        System.out.println("from TV " + temp);
    }
}
