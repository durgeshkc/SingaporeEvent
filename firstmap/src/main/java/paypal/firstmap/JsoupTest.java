package paypal.firstmap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by thanhtnguyen on 4/2/15.
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.worldtravelguide.net/singapore-city/events").get();
        Elements eventDivs = doc.select("div[class=poi-list]");
        for (Element eventDiv : eventDivs) {
            System.out.print(eventDiv.child(1).child(0).text());
            System.out.print("   (" + eventDiv.child(2).ownText() + ")    ");
            System.out.println(eventDiv.child(4).child(1).ownText());
        }
    }
}
