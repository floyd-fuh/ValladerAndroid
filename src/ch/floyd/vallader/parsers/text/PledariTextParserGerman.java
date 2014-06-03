package ch.floyd.vallader.parsers.text;

import android.widget.TextView;
import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.R;

public class PledariTextParserGerman extends PledariTextParser{
		
	public PledariTextParserGerman(MainActivity a) {
		super(a);
		tv = (TextView) a.findViewById(R.id.pledari_german_results);
	}

}
