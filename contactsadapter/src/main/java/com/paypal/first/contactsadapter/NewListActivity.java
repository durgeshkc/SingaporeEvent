package com.paypal.first.contactsadapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;


public class NewListActivity extends Activity {
    ListView listView = null;
    List<Person> listPerson = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        listView = (ListView) findViewById(R.id.newList);
        listPerson = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            Person person = new Person("first " + i, "last " + i, 20 + i);
            listPerson.add(person);
        }

        final NewListAdapter adapter = new NewListAdapter(this, R.layout.new_list_layout, listPerson);
        listView.setAdapter(adapter);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            private volatile ScheduledFuture<?> self;
            int counter = 0;

            @Override
            public void run() {
                Random random = new Random();
                Person person = new Person("RR " + random.nextInt() % 100, "Bla " + counter, 20);
                listPerson.add(person);

                counter += 1;
                Log.i("Timer", "Add person: " + counter);
                if (counter == 20) {
                    cancel();
                }
            }
        }, 100, 1000);

        Button button = (Button) findViewById(R.id.refreshButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_list, menu);
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
