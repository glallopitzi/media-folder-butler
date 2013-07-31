package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="artist", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class Artist {

	private String id;
	private String name;
	
	@XmlAttribute(name="id", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@XmlElement(name="name", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
