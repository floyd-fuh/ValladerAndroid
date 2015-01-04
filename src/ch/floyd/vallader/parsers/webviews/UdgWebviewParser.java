package ch.floyd.vallader.parsers.webviews;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public abstract class UdgWebviewParser extends Parser{
	
	WebView wv;
	TextView label;
	
	public UdgWebviewParser(MainActivity a){
		super(a);
	}

	@Override
	public void parseResult(String result, Searcher s) {
		wv.setVisibility(View.GONE);
		label.setVisibility(View.GONE);
		if(s.results_found){
			String new_result = result.substring(result.indexOf(s.results_found_string));
			wv.setVisibility(View.VISIBLE);
			label.setVisibility(View.VISIBLE);
			wv.loadData(new_result, "text/html; charset=utf-8", "utf-8");
		}
	}
}
