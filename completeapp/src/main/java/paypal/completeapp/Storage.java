package paypal.completeapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhtnguyen on 4/2/15.
 */
public class Storage {
    public static List<Event> events = new ArrayList<>();

    public static void addEvent(String name, String location, String time) {
        Event event = new Event(name, location, time);
        events.add(event);
    }
}
