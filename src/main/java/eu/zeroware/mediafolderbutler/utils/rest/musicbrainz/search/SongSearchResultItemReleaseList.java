package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongSearchResultItemReleaseList {
	
	private List<SongSearchResultItemReleaseItem> songSearchResultItemReleaseItems;
	
	@XmlElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setSongSearchResultItemReleaseItems(
			List<SongSearchResultItemReleaseItem> songSearchResultItemReleaseItems) {
		this.songSearchResultItemReleaseItems = songSearchResultItemReleaseItems;
	}

	public List<SongSearchResultItemReleaseItem> getSongSearchResultItemReleaseItems() {
		return songSearchResultItemReleaseItems;
	}

}
