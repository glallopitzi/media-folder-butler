package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumLookupResultRelease {
	
	private String id;
	private String title;
	private String date;
	private AlbumLookupResultReleaseMediumList albumLookupResultReleaseMediumList;

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
	
	@XmlElement(name="title", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	@XmlElement(name="date", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setDate(String date) {
		this.date = date;
	}

	public AlbumLookupResultReleaseMediumList getAlbumLookupResultReleaseMediumList() {
		return albumLookupResultReleaseMediumList;
	}
	@XmlElement(name="medium-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setAlbumLookupResultReleaseMediumList(
			AlbumLookupResultReleaseMediumList albumLookupResultReleaseMediumList) {
		this.albumLookupResultReleaseMediumList = albumLookupResultReleaseMediumList;
	}
	
}
