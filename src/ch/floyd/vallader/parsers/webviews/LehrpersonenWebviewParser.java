package ch.floyd.vallader.parsers.webviews;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public class LehrpersonenWebviewParser extends Parser{
	
	final WebView wv;
	final TextView label;
	
	public LehrpersonenWebviewParser(MainActivity a){
		super(a);
		wv = (WebView) a.findViewById(R.id.lehrpersonen_web_view);
		label = (TextView) a.findViewById(R.id.lehrpersonen_web_view_label); 
		wv.setVisibility(View.GONE);
		label.setVisibility(View.GONE);
	}
	
	@Override
	public void parseResult(String result, Searcher s) {
		wv.setVisibility(View.GONE);
		label.setVisibility(View.GONE);
		if(s.results_found){
			wv.setVisibility(View.VISIBLE);
			label.setVisibility(View.VISIBLE);
			wv.loadDataWithBaseURL(s.searchUrl, result, "text/html; chartset=utf-8", "utf-8", null);
		}
	}

}
