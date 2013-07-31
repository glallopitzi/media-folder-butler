package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="track", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class Track {
	private Integer position;
	private Integer number;
	private Long length;
	private Recording recording;
	
	public Integer getPosition() {
		return position;
	}
	@XmlElement(name="position", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getNumber() {
		return number;
	}
	@XmlElement(name="number", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Recording getRecording() {
		return recording;
	}
	@XmlElement(name="recording", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setRecording(Recording recording) {
		this.recording = recording;
	}
	public Long getLength() {
		return length;
	}
	@XmlElement(name="length", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setLength(Long length) {
		this.length = length;
	}
	
	
}
