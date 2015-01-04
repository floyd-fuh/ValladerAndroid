package ch.floyd.vallader.parsers.webviews;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public abstract class PledariWebviewParser extends Parser{
	
	WebView wv;
	TextView label;
	
	public PledariWebviewParser(MainActivity a){
		super(a);
	}

	@Override
	public void parseResult(String result, Searcher s) {
		wv.setVisibility(View.GONE);
		label.setVisibility(View.GONE);
		if(s.results_found && !s.results_not_found){
			wv.setVisibility(View.VISIBLE);
			label.setVisibility(View.VISIBLE);
			wv.loadData(result, "text/html; charset=iso-8859-1", "iso-8859-1");
		}
	}
}
