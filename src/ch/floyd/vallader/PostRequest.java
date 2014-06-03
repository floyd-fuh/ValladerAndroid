package ch.floyd.vallader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;
import ch.floyd.vallader.parsers.Searcher;

public class PostRequest extends AsyncTask<String, Void, String>{
	
	Searcher s;
	
	public PostRequest(Searcher s){
		this.s = s;
	}

    protected String doInBackground(String... args) {
    	HttpClient client = new DefaultHttpClient();  
	    String url = args[0];
	    String encoding = args[2];
	    HttpPost post = new HttpPost(url);
	    try {
	    	StringEntity stringEntity = new StringEntity(args[1]);
	    	stringEntity.setContentType("application/x-www-form-urlencoded");
			post.setEntity(stringEntity);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "";
		}
	    HttpResponse responsePost = null;
		try {
			responsePost = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    HttpEntity resEntityGet = responsePost.getEntity();  
	    if (resEntityGet != null) {  
	        // do something with the response
	        String response;
			try {
				response = EntityUtils.toString(resEntityGet, encoding);
				Log.v("GET RESPONSE", response.substring(0, 30)+"...");
				return response;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
	    return "";
    }

    protected void onPostExecute(String response) {
        s.parseResult(response);
    }
}
