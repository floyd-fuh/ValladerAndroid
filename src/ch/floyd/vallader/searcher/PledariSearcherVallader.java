package ch.floyd.vallader.searcher;

import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;

public class PledariSearcherVallader extends PledariSearcher{

	public PledariSearcherVallader(MainActivity a, Parser[] p) {
		super(a, p);
		direction = "direcziun=6";
	}

}
