package ch.floyd.vallader.searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.protocol.HTTP;

import ch.floyd.vallader.GetRequest;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public class LehrpersonenSearcher extends Searcher{
		
	public LehrpersonenSearcher(MainActivity a, Parser[] p){
		super(a, p);
		results_found_string = " Resultate gefunden (";
	}
	
	public void search(String query){
		try {
			searchUrl = "https://www.lehrpersonen.ch/vallader/v0.1/index.php?q="+URLEncoder.encode(query, "utf-8")+"&action=Suchen";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		new GetRequest(this).execute(searchUrl, HTTP.UTF_8);
	}
}
