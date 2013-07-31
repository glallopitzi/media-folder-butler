package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumSearchResultReleaseList {
	
	private List<AlbumSearchResultReleaseItem> albumSearchResultReleaseItems;
	private Integer offset;
	private Integer count;
	
	@XmlElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setAlbumSearchResultReleaseItems(
			List<AlbumSearchResultReleaseItem> albumSearchResultReleaseItems) {
		this.albumSearchResultReleaseItems = albumSearchResultReleaseItems;
	}

	public List<AlbumSearchResultReleaseItem> getAlbumSearchResultReleaseItems() {
		return albumSearchResultReleaseItems;
	}
	
	@XmlAttribute
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getOffset() {
		return offset;
	}

	@XmlAttribute
	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}
}
