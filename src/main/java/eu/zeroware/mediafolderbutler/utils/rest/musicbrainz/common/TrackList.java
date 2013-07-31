package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="track-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class TrackList {
	private List<Track> tracks;

	public List<Track> getTracks() {
		return tracks;
	}
	
	@XmlElement(name="track", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
}
