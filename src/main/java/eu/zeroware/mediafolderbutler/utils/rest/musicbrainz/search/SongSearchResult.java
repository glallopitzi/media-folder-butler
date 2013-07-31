package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongSearchResult {

	private SongSearchResultList songSearchResultList;

	public SongSearchResultList getSongSearchResultList() {
		return songSearchResultList;
	}
	
	@XmlElement(name="recording-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setSongSearchResultList(SongSearchResultList songSearchResultList) {
		this.songSearchResultList = songSearchResultList;
	}
	
}
