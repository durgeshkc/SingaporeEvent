package paypal.completeapp;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhtnguyen on 4/2/15.
 */
public class RetrieveEventTask extends AsyncTask<String, Void, List<Event>> {
    public final String TAG = "RETRIEVE_EVENT";

    @Override
    protected List<Event> doInBackground(String... urls) {
        String url = urls[0];
        ArrayList<Event> events = new ArrayList<>();

        // Get the list of events
        Log.i(TAG, "Get data from: " + url);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(doc.toString());
        Elements elements = doc.getElementsByAttributeValue("itemprop","startDate");
        Elements elementsLocation = doc.getElementsByAttributeValue("itemprop","location");
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            String dateValue = element.text();
            Element elementLocation = elementsLocation.get(i);
            String locationValue = elementLocation.text();
            String name = element.parent().parent().parent().child(0).ownText();

            Log.i(TAG, "Retrieved: " + name + "    " + locationValue + "    " + dateValue);

            Storage.addEvent(name, locationValue, dateValue);
        }

        Log.i(TAG, "Fetched " + elements.size() + " events");
        Log.i(TAG, Storage.events.size() + "");
        return events;
    }

    protected void onPostExecute(List<Event> events) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
