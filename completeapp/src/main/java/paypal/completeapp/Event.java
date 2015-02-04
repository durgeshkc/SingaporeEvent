package paypal.completeapp;

/**
 * Created by thanhtnguyen on 4/2/15.
 */
public class Event {
    private String name;
    private String location;
    private String dateTime;

    public Event(String name, String location, String dateTime) {
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
