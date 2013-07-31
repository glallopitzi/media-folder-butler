package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="title", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumLookupResultReleaseMediumList {
	
	private Integer count;
	private List<AlbumLookupResultReleaseMediumItem> albumLookupResultReleaseMediumItems;
	
	public Integer getCount() {
		return count;
	}
	@XmlAttribute
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<AlbumLookupResultReleaseMediumItem> getAlbumLookupResultReleaseMediumItems() {
		return albumLookupResultReleaseMediumItems;
	}
	@XmlElement(name="medium", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setAlbumLookupResultReleaseMediumItems(
			List<AlbumLookupResultReleaseMediumItem> albumLookupResultReleaseMediumItems) {
		this.albumLookupResultReleaseMediumItems = albumLookupResultReleaseMediumItems;
	}

}
