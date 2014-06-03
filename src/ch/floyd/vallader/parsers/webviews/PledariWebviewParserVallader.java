package ch.floyd.vallader.parsers.webviews;

import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;

public class PledariWebviewParserVallader extends PledariWebviewParser{

	public PledariWebviewParserVallader(MainActivity a) {
		super(a);
		wv = (WebView) a.findViewById(R.id.pledari_web_view_vallader_german);
		label = (TextView) a.findViewById(R.id.pledari_web_view_vallader_german_label);
	}
	

}
