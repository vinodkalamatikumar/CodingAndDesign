package designPatterns.structural.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservable {

    List<Observer> observerList = new ArrayList<>();
    float temp;

    void add(Observer obs){
        this.observerList.add(obs);
    }

    void delete(Observer obs){
        this.observerList.remove(obs);
    }

    void setTemperature(float t){
        this.temp=t;
        notifyObserver();
    }

    void notifyObserver(){
        for(Observer obs : observerList){
            obs.update(temp);
        }
    }


}
