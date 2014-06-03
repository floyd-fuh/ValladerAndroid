package ch.floyd.vallader.parsers.webviews;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;

public class UdgWebviewParserGerman extends UdgWebviewParser{

	public UdgWebviewParserGerman(MainActivity a){
		super(a);
		wv = (WebView) a.findViewById(R.id.udg_web_view_german);
		label = (TextView) a.findViewById(R.id.udg_web_view_german_label); 
		wv.setVisibility(View.GONE);
		label.setVisibility(View.GONE);
	}
	
}
