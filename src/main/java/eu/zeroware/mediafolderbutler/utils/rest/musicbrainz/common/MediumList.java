package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="medium-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class MediumList {
	
	private Integer trackCount;
	private Medium medium;
	
	@XmlElement(name="medium", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public Medium getMedium() {
		return medium;
	}

	@XmlElement(name="track-count", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}

	public Integer getTrackCount() {
		return trackCount;
	}
	
	
}
