package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.TrackList;

@XmlRootElement(name="medium", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumLookupResultReleaseMediumItem {
	private String title;
	private Integer position;
	private TrackList list;
	
	public String getTitle() {
		return title;
	}
	@XmlElement(name="title", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPosition() {
		return position;
	}
	@XmlElement(name="position", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setPosition(Integer position) {
		this.position = position;
	}
	public TrackList getList() {
		return list;
	}
	@XmlElement(name="track-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setList(TrackList list) {
		this.list = list;
	}
	
	
}
