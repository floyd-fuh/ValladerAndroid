package ch.floyd.vallader.parsers.text;

import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;

public class PledariTextParserVallader extends PledariTextParser{
		
	public PledariTextParserVallader(MainActivity a) {
		super(a);
		tv = (TextView) a.findViewById(R.id.pledari_vallader_results);
	}
	
}
