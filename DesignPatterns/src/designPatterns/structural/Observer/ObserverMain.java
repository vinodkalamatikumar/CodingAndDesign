package designPatterns.structural.Observer;

public class ObserverMain {
    public static void main(String[] args) {
        WeatherStationObservable weatherStationObservable = new WeatherStationObservable();

        IphoneStationObserver iphoneStationObserver = new IphoneStationObserver();
        TVObserver tvObserver = new TVObserver();

        weatherStationObservable.add(iphoneStationObserver);
        weatherStationObservable.add(tvObserver);
        weatherStationObservable.setTemperature(30f);

        weatherStationObservable.delete(tvObserver);
        weatherStationObservable.setTemperature(40f);
    }
}
