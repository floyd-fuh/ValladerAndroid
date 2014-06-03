package ch.floyd.vallader.parsers.text;

import android.view.View;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;

public abstract class PledariTextParser extends Parser{
	
	TextView tv;
	
	public PledariTextParser(MainActivity a) {
		super(a);
	}

	@Override
	public void parseResult(String result, Searcher s) {
		tv.setVisibility(View.GONE);
		if(s.results_found && !s.results_not_found){
			tv.setVisibility(View.VISIBLE);
			tv.setText(result);
		}
	}
}
