package eu.zeroware.mediafolderbutler.utils.rest;

import com.sun.jersey.api.client.Client;

public class JerseyRESTClient {
	
	protected Client c;

	public JerseyRESTClient(){
		c = new Client();
	}
	
	public String getRealUserAgent(){
		return "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.4 (KHTML, like Gecko) Chrome/22.0.1229.79 Safari/537.4";
	}
}
