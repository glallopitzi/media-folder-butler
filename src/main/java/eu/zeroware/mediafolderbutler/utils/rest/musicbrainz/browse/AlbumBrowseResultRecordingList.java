package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="recording-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumBrowseResultRecordingList {
	private List<AlbumBrowseResultRecordingItem> albumBrowseResultRecordingItems;

	public List<AlbumBrowseResultRecordingItem> getAlbumBrowseResultRecordingItems() {
		return albumBrowseResultRecordingItems;
	}
	@XmlElement(name="recording", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setAlbumBrowseResultRecordingItems(
			List<AlbumBrowseResultRecordingItem> albumBrowseResultRecordingItems) {
		this.albumBrowseResultRecordingItems = albumBrowseResultRecordingItems;
	}
}
