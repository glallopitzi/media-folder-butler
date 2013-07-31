package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="recording-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongSearchResultList {
	
	private List<SongSearchResultItem> searchResultItems;

	public List<SongSearchResultItem> getSearchResultItems() {
		return searchResultItems;
	}
	
	@XmlElement(name="recording", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setSearchResultItems(List<SongSearchResultItem> searchResultItems) {
		this.searchResultItems = searchResultItems;
	}

}
