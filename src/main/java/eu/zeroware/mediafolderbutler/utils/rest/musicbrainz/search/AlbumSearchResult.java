package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumSearchResult {

	private AlbumSearchResultReleaseList albumSearchResultReleaseList;

	@XmlElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setAlbumSearchResultReleaseList(
			AlbumSearchResultReleaseList albumSearchResultReleaseList) {
		this.albumSearchResultReleaseList = albumSearchResultReleaseList;
	}

	public AlbumSearchResultReleaseList getAlbumSearchResultReleaseList() {
		return albumSearchResultReleaseList;
	}
}
