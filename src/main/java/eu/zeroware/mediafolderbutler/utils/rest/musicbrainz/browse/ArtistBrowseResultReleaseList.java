package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistBrowseResultReleaseList {
	private List<ArtistBrowseResultReleaseItem> artistBrowseResultReleaseItems;

	public List<ArtistBrowseResultReleaseItem> getArtistBrowseResultReleaseItems() {
		return artistBrowseResultReleaseItems;
	}
	@XmlElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtistBrowseResultReleaseItems(
			List<ArtistBrowseResultReleaseItem> artistBrowseResultReleaseItems) {
		this.artistBrowseResultReleaseItems = artistBrowseResultReleaseItems;
	}
}
