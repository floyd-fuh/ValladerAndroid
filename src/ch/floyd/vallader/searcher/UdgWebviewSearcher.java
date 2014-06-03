package ch.floyd.vallader.searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.protocol.HTTP;

import ch.floyd.vallader.GetRequest;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public abstract class UdgWebviewSearcher extends Searcher{
		
	public UdgWebviewSearcher(MainActivity a, Parser[] p){
		super(a, p);
		results_found_string = "Glista dals resultats";
	}
	
	public void search(String query){
		String url;
		try {
			url = searchUrl+URLEncoder.encode(query, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		new GetRequest(this).execute(url, HTTP.UTF_8);
	}

}
