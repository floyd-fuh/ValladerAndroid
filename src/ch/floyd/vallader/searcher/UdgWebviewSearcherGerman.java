package ch.floyd.vallader.searcher;

import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;

public class UdgWebviewSearcherGerman extends UdgWebviewSearcher{

	public UdgWebviewSearcherGerman(MainActivity a, Parser[] p){
		super(a, p);
		searchUrl = "http://www.udg.ch/dicziunari/vallader/idx_nor_de/q:";
	}
	
}
