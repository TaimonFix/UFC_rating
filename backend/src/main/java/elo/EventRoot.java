package elo;

import java.util.HashMap;
import java.util.List;

public class EventRoot {

    private List<Event> eventList;

    public List<Event> getEvent() {
        return eventList;
    }

    public void setEvent(List<Event> eventList) {
        this.eventList = eventList;
    }

    public HashMap<String, Integer> getFightersMap() {
        HashMap<String, Integer> fightersMap = new HashMap<>();
        for (Event eventObject: eventList) {
            eventObject.putFighters(fightersMap);
        }
        return fightersMap;
    }

    public List<String> getWeightClasses(List<String> weightClassList) {
        for (Event eventObject: eventList) {
            if (!weightClassList.contains(eventObject.getWeightClass())) {
                weightClassList.add(eventObject.getWeightClass());
            }
        }
        return weightClassList;
    }

    public HashMap<String, Integer> ratingELO() {
        HashMap<String, Integer> ratingMap = new HashMap<>();
        HashMap<String, Integer> fightersMap = new HashMap<>();

        for (Event event: eventList) {
            event.putFighters(fightersMap);

            ratingMap = event.rating(fightersMap, ratingMap);
        }
        return ratingMap;
    }
    @Override
    public String toString() {
        return "Root{" +
                "eventList=" + eventList +
                '}';
    }
}
