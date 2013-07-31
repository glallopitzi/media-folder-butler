package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="artist-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistSearchResultList {
	
	private List<ArtistSearchResultItem> artistSearchResultItems;

	public List<ArtistSearchResultItem> getArtistSearchResultItems() {
		return artistSearchResultItems;
	}
	
	@XmlElement(name="artist", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtistSearchResultItems(List<ArtistSearchResultItem> artistSearchResultItems) {
		this.artistSearchResultItems = artistSearchResultItems;
	}

}
