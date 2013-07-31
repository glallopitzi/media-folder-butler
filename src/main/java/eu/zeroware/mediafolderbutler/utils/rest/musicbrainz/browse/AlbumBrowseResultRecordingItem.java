package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="recording", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumBrowseResultRecordingItem {
	private String id;
	private String title;
	private Long length;
	
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
	public Long getLength() {
		return length;
	}
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setLength(Long length) {
		this.length = length;
	}
	
	
}
