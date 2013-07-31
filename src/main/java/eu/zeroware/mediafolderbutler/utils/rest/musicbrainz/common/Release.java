package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class Release {
	
	private String id;
	private String title;
	private MediumList mediumList;
	
	
	public String getTitle() {
		return title;
	}
	
	@XmlElement(name="title", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTitle(String title) {
		this.title = title;
	}
	public MediumList getMediumList() {
		return mediumList;
	}
	
	@XmlElement(name="medium-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setMediumList(MediumList mediumList) {
		this.mediumList = mediumList;
	}

	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

}
