package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="artist", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistSearchResultItem {
	
	private String id;
	private String type;
	private String name;
	private List<MBTagItem> tags;
	
	public String getName() {
		return name;
	}
	
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	
	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute
	public void setId(String arid) {
		this.id = arid;
	}

	public String getId() {
		return id;
	}

	public List<MBTagItem> getTags() {
		return tags;
	}

	@XmlElement(name="tag", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTags(List<MBTagItem> tags) {
		this.tags = tags;
	}
	
}
