package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="medium", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class Medium {

	private Integer position;
	
	@XmlElement(name="position", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getPosition() {
		return position;
	}
	
}
