package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="artist-credit", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongSearchResultItemArtistCredit {
	
	private String name;

	@XmlElement(name="name", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
