package eu.zeroware.mediafolderbutler.utils.rest.lastfm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="lfm")
public class TokenRequestResult {
	
	private String token;

	public String getToken() {
		return token;
	}
	
	@XmlElement(name="token")
	public void setToken(String token) {
		this.token = token;
	}

}
