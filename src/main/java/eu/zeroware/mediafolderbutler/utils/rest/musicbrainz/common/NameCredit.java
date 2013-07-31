package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="name-credit", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class NameCredit {
	
	private Artist artist;

	@XmlElement(name="artist", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Artist getArtist() {
		return artist;
	}

}
