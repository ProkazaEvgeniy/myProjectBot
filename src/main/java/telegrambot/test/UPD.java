package telegrambot.test;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class UPD {

	public static void main(String[] args) {
	    try {
	        Parser parser = new Parser("http://bash.im/best");
	        parser.setEncoding("windows-1251");

	        NodeFilter atrb1 = new TagNameFilter("text");
	        NodeList nodeList = parser.parse(atrb1);

	        for(int i=0; i<nodeList.size(); i++) {
	            Node node = nodeList.elementAt(i);
	            System.out.println(node.toHtml());
	        }

	    } catch (ParserException e) {
	        e.printStackTrace();
	    }
	}
}
