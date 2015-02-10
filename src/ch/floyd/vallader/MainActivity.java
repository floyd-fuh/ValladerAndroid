package ch.floyd.vallader;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import ch.floyd.vallader.parsers.Parser;
import ch.floyd.vallader.parsers.Searcher;
import ch.floyd.vallader.parsers.webviews.LehrpersonenWebviewParser;
import ch.floyd.vallader.parsers.webviews.PledariWebviewParserGerman;
import ch.floyd.vallader.parsers.webviews.PledariWebviewParserVallader;
import ch.floyd.vallader.parsers.webviews.UdgWebviewParserGerman;
import ch.floyd.vallader.parsers.webviews.UdgWebviewParserVallader;
import ch.floyd.vallader.searcher.LehrpersonenSearcher;
import ch.floyd.vallader.searcher.PledariSearcherGerman;
import ch.floyd.vallader.searcher.PledariSearcherVallader;
import ch.floyd.vallader.searcher.UdgSearcherGerman;
import ch.floyd.vallader.searcher.UdgSearcherVallader;

public class MainActivity extends Activity {
	
	ArrayList<Searcher> list = null;
	
	private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after){
        	
        }
        public void onTextChanged(CharSequence s, int start, int before, int count){
        }

		@Override
		public void afterTextChanged(Editable s) {
			boolean doSearch = false;
			for(int i = s.length(); i > 0; i--){
                if(s.subSequence(i-1, i).toString().equals("\n")){
                     s.replace(i-1, i, "");
                     doSearch = true;
                }
            }
			if(doSearch){
				search();
			}
		}
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search();
            }
        });
        
        EditText search_field = (EditText) findViewById(R.id.search_field);
        search_field.addTextChangedListener(mTextEditorWatcher);
        
        /*search_field.setOnEditorActionListener( new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
                	search();
                return false;
            }
        });
        */
        /*
        search_field.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == EditorInfo.IME_ACTION_SEARCH ||
				    keyCode == EditorInfo.IME_ACTION_DONE ||
				    event.getAction() == KeyEvent.ACTION_DOWN &&
				    event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
						if (!event.isShiftPressed()) {
							Log.v("AndroidEnterKeyActivity","Enter Key Pressed!");
							search();
						}
						return true;
				 }	   
				return false; // pass on to other listeners. 
			}
        });
        */
	}

	
	private void search(){
		if(list != null){
			for(Searcher s : list){
				s.setStillCareAboutResults(false);
			}
		}
		
		final EditText search_field = (EditText) findViewById(R.id.search_field);
		String query = search_field.getText().toString().trim();
		if(!query.equals("")){
			list = new ArrayList<Searcher>();
			list.add(new LehrpersonenSearcher(this, new Parser[]{new LehrpersonenWebviewParser(this)}));
			
			list.add(new PledariSearcherGerman(this, new Parser[]{
						//new PledariTextParserGerman(this), 
						new PledariWebviewParserGerman(this)
					}));
			list.add(new PledariSearcherVallader(this, new Parser[]{
						//new PledariTextParserVallader(this), 
						new PledariWebviewParserVallader(this)
					}));
			
			list.add(new UdgSearcherGerman(this, new Parser[]{new UdgWebviewParserGerman(this)}));
			list.add(new UdgSearcherVallader(this, new Parser[]{new UdgWebviewParserVallader(this)}));
			
			((TextView) findViewById(R.id.progress)).setText(R.string.progress_start);
			
			for(Searcher s : list){
				// we don't want to crash just because one parser doesn't work
				try{
					s.search(query);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateProgress(){
		//LayoutInflater v = a.getLayoutInflater(); 
		//TextView progress = (TextView) v.inflate(R.id.progress, null);
		TextView progress = (TextView) findViewById(R.id.progress);
		if(progress != null){
			String progressText = progress.getText().toString();
			int i = progressText.indexOf("/");
			int done = Integer.parseInt(progressText.substring(0, i));
			int total = Integer.parseInt(progressText.substring(i+1));
			done++;
			progress.setText(done+"/"+total);
		}
	}
	
	
	
	
}
