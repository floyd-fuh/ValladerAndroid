package ch.floyd.vallader.searcher;

import ch.floyd.vallader.MainActivity;
import ch.floyd.vallader.parsers.Parser;

public class UdgWebviewSearcherVallader extends UdgWebviewSearcher{

	public UdgWebviewSearcherVallader(MainActivity a, Parser[] p){
		super(a, p);
		searchUrl = "http://www.udg.ch/dicziunari/vallader/idx_nor_rm/q:";
	}
	
}
