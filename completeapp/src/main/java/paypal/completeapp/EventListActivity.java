package paypal.completeapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EventListActivity extends Activity {
    static final String TAG = "EVENT_LIST_ACTIVITY";

    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        String url = "https://www.eventbrite.sg/d/singapore--singapore/events/";
        new RetrieveEventTask().execute(url);

        listView = (ListView) findViewById(R.id.event_list);
        final EventAdapter adapter = new EventAdapter(this, R.layout.event_row, Storage.events);
        listView.setAdapter(adapter);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int currentListSize = 0;

            @Override
            public void run() {
                if (currentListSize < Storage.events.size()) {
                    Log.i(TAG, "Refresh list");
                    currentListSize = Storage.events.size();
                    EventListActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        }, 2000, 3000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
