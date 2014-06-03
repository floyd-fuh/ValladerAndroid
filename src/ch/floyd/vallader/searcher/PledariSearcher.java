package ch.floyd.vallader.searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.protocol.HTTP;

import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.PostRequest;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public abstract class PledariSearcher extends Searcher{
	
	protected static String direction;
	
	public PledariSearcher(MainActivity a, Parser[] p){
		super(a, p);
		results_found_string = "Treffer:";
		results_not_found_string = "0              / Dieser Begriff:";
		searchUrl = "http://www.pledari.ch/meinpledari/index.php";
	}
	
	public void search(String query){
		String post_data;
		try {
			post_data = direction+"&modus=entschatta&pled="+URLEncoder.encode(query, "utf-8")+"&tschertgar=5.+Tschertgar+%2F+suchen";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		new PostRequest(this).execute(searchUrl, post_data, HTTP.ISO_8859_1);
	}

}
