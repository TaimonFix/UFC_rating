package elo;

import java.util.List;

public class EventRoot {

    private List<Event> event;

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Root{" +
                "event=" + event +
                '}';
    }
}
