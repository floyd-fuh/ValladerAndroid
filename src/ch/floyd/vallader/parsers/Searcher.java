package ch.floyd.vallader.parsers;

import ch.floyd.vallader.MainActivity;

public abstract class Searcher {
	
	protected MainActivity a;
	private Parser[] p;
	public String results_found_string = null;
	public String results_not_found_string = null;
	public boolean results_found = true;
	public boolean results_not_found = false;
	public String searchUrl;
	
	public Searcher(MainActivity a, Parser[] p){
		this.a = a;
		this.p = p;
	}
	
	public abstract void search(String query);
	public void parseResult(String result){
		String result_lower = result.toLowerCase();
		if(results_found_string != null){
			results_found = result_lower.contains(results_found_string.toLowerCase());
		}
		if(results_not_found_string != null){
			results_not_found = result_lower.contains(results_not_found_string.toLowerCase());
		}
		for(Parser parser : p){
			parser.parseResult(result, this);
		}
	}
}
