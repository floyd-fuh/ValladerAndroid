package ch.floyd.vallader.parsers;

import ch.floyd.vallader.MainActivity;

public abstract class Parser {
	
	protected MainActivity a;
	
	public Parser(MainActivity a){
		this.a = a;
	}
	
	public abstract void parseResult(String result, Searcher s);
}
