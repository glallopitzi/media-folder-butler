package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumBrowseResult {
	private AlbumBrowseResultRecordingList albumBrowseResultRecordingList;

	public AlbumBrowseResultRecordingList getAlbumBrowseResultRecordingList() {
		return albumBrowseResultRecordingList;
	}
	@XmlElement(name="recording-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setAlbumBrowseResultRecordingList(
			AlbumBrowseResultRecordingList albumBrowseResultRecordingList) {
		this.albumBrowseResultRecordingList = albumBrowseResultRecordingList;
	} 
}
