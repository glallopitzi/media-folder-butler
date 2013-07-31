package eu.zeroware.mediafolderbutler.utils.rest;

import com.sun.jersey.api.client.Client;

public class JerseyRESTClient {
	
	protected Client c;

	public JerseyRESTClient(){
		c = new Client();
	}
	
}
