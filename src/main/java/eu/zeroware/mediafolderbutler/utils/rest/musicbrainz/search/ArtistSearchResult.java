package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistSearchResult {
	
	private ArtistSearchResultList artistSearchResultList;

	public ArtistSearchResultList getArtistSearchResultList() {
		return artistSearchResultList;
	}

	@XmlElement(name="artist-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtistSearchResultList(ArtistSearchResultList artistSearchResultList) {
		this.artistSearchResultList = artistSearchResultList;
	}
	
}



