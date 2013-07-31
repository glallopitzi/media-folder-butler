package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongBrowseResult {
	private SongBrowseResultReleaseList songBrowseResultReleaseList;

	public SongBrowseResultReleaseList getSongBrowseResultReleaseList() {
		return songBrowseResultReleaseList;
	}
	@XmlElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setSongBrowseResultReleaseList(
			SongBrowseResultReleaseList songBrowseResultReleaseList) {
		this.songBrowseResultReleaseList = songBrowseResultReleaseList;
	}
}
