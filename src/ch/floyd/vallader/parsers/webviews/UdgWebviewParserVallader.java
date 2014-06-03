package ch.floyd.vallader.parsers.webviews;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;

public class UdgWebviewParserVallader extends UdgWebviewParser{

	public UdgWebviewParserVallader(MainActivity a){
		super(a);
		wv = (WebView) a.findViewById(R.id.udg_web_view_vallader);
		label = (TextView) a.findViewById(R.id.udg_web_view_vallader_label); 
		wv.setVisibility(View.GONE);
		label.setVisibility(View.GONE);
	}
	
}
