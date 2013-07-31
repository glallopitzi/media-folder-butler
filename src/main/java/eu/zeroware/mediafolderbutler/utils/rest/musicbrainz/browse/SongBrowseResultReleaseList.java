package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongBrowseResultReleaseList {
	private List<SongBrowseResultReleaseItem> songBrowseResultReleaseItems;

	public List<SongBrowseResultReleaseItem> getSongBrowseResultReleaseItems() {
		return songBrowseResultReleaseItems;
	}
	@XmlElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setSongBrowseResultReleaseItems(
			List<SongBrowseResultReleaseItem> songBrowseResultReleaseItems) {
		this.songBrowseResultReleaseItems = songBrowseResultReleaseItems;
	}
}
