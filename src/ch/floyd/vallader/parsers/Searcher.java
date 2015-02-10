package ch.floyd.vallader.parsers;

import android.os.Handler;
import ch.floyd.vallader.MainActivity;

public abstract class Searcher {
	
	protected MainActivity a;
	private Parser[] p;
	public String results_found_string = null;
	public String results_not_found_string = null;
	public boolean results_found = true;
	public boolean results_not_found = false;
	public boolean stillCareAboutResults = true;
	public String searchUrl;
	
	public Searcher(MainActivity a, Parser[] p){
		this.a = a;
		this.p = p;
	}
	
	public abstract void search(String query);
	public void parseResult(String result){
		if(!stillCareAboutResults)
			return;
		
		(new Handler()).post(new Runnable() {
            public void run() {
        		a.updateProgress();
            }
        });


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
	
	public void setStillCareAboutResults(boolean value){
		stillCareAboutResults = value;
	}
	
	
	
}
