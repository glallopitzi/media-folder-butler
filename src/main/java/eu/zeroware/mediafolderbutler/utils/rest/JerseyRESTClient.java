package eu.zeroware.mediafolderbutler.utils.rest;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.sun.jersey.api.client.Client;

public class JerseyRESTClient {
	
	protected Client c;
	
	private Date lastCallTimestamp;
	private int DELAY = 1000;
	
	
	public JerseyRESTClient(){
		c = new Client();
	}
	
	public String getRealUserAgent(){
		return "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.4 (KHTML, like Gecko) Chrome/22.0.1229.79 Safari/537.4";
	}
	
	protected void checkForRequestBound() {
		if (null == getLastCallTimestamp()) {
			setLastCallTimestamp(new Date());
			return;
		}
		Date now = new Date();
		if ( now.after( DateUtils.addMilliseconds(getLastCallTimestamp(), DELAY) ) ) {
			setLastCallTimestamp( now );
			return;
		}
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLastCallTimestamp( new Date() );
		return;
	}

	public Date getLastCallTimestamp() {
		return lastCallTimestamp;
	}

	public void setLastCallTimestamp(Date lastCallTimestamp) {
		this.lastCallTimestamp = lastCallTimestamp;
	}
}
