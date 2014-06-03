package ch.floyd.vallader.parsers.webviews;

import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;

public class PledariWebviewParserGerman extends PledariWebviewParser{

	public PledariWebviewParserGerman(MainActivity a) {
		super(a);
		wv = (WebView) a.findViewById(R.id.pledari_web_view_german_vallader);
		label = (TextView) a.findViewById(R.id.pledari_web_view_german_vallader_label);
	}
	

}
