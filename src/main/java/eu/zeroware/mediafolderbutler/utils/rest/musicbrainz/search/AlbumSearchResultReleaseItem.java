package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.ArtistCredit;

@XmlRootElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumSearchResultReleaseItem {
	
	private String id;
	private String title;
	private String date;
	private String country;
	private ArtistCredit artistCredit;
	
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

	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return country;
	}
	
	@XmlElement(name="artist-credit", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}
	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}
	public String getId() {
		return id;
	}
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}
	
}
