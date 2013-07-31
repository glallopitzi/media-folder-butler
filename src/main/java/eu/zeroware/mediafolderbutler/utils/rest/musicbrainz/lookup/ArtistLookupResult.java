package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistLookupResult {

	private ArtistLookupResultArtist artist;

	public ArtistLookupResultArtist getArtist() {
		return artist;
	}

	@XmlElement(name="artist", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtist(ArtistLookupResultArtist artist) {
		this.artist = artist;
	}
	
}
