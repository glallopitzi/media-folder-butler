package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongBrowseResultReleaseItem {
	private String id;
	private String title;
	private String status;
	private String date;
	private String country;
	
	public String getId() {
		return id;
	}
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setDate(String date) {
		this.date = date;
	}
	public String getCountry() {
		return country;
	}
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
