package ch.floyd.vallader;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import ch.floyd.vallader.parsers.Searcher;

import android.os.AsyncTask;
import android.util.Log;

public class GetRequest extends AsyncTask<String, Void, String>{
	
	Searcher s;
	
	public GetRequest(Searcher s){
		this.s = s;
	}

    protected String doInBackground(String... urls) {
    	HttpClient client = new DefaultHttpClient();  
	    String getURL = urls[0];
	    String encoding = urls[1];
	    HttpGet get = new HttpGet(getURL);
	    HttpResponse responseGet = null;
		try {
			responseGet = client.execute(get);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	    HttpEntity resEntityGet = responseGet.getEntity();  
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
