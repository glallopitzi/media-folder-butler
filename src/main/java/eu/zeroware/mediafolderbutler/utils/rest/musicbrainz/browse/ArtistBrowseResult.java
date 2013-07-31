package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistBrowseResult {
	
	
	private ArtistBrowseResultReleaseList artistBrowseResultReleaseList;

	public ArtistBrowseResultReleaseList getArtistBrowseResultReleaseList() {
		return artistBrowseResultReleaseList;
	}
	
	@XmlElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtistBrowseResultReleaseList(
			ArtistBrowseResultReleaseList artistBrowseResultReleaseList) {
		this.artistBrowseResultReleaseList = artistBrowseResultReleaseList;
	}
}
