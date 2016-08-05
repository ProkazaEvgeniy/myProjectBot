package telegrambot.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {

	public static void main(String[] args) {
		Elements text = null;
		Document doc;
		try {
			doc = (Document) Jsoup.connect("http://bash.im/best").get();
			// text = doc.select(".text");
			for (Element element : doc.select("div.text")) {
				System.out.println(element.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(text);

	}

}
