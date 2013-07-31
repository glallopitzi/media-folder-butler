package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongSearchResultItemReleaseItem {
	
	private String title;
	private String date;
	
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
}
