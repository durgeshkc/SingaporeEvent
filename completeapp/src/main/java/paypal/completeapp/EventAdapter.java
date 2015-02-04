package paypal.completeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by thanhtnguyen on 4/2/15.
 */
public class EventAdapter extends ArrayAdapter<Event> {
    private Context context;
    private int row;
    private List<Event> events;

    public EventAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);

        this.context = context;
        this.row = resource;
        this.events = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);
        }
        Event event = events.get(position);

        TextView nameView = (TextView) view.findViewById(R.id.event_name);
        nameView.setText(event.getName());

        TextView timeView = (TextView) view.findViewById(R.id.event_time);
        timeView.setText(event.getDateTime());

        return view;
    }
}
