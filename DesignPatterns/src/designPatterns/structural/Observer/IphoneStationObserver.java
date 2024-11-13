package designPatterns.structural.Observer;

public class IphoneStationObserver implements Observer{

    float temp;
    @Override
    public void update(float temp) {
        this.temp=temp;
        display();
    }
    void display(){
        System.out.println("the currenttemperature in iphone " + temp);
    }
}
