package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.ReleaseList;

@XmlRootElement(name="artist", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistLookupResultArtist {
	
	private String id;
	private String type;
	private String name;
	private ReleaseList releaseList;
	
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@XmlElement(name="name", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}

	public ReleaseList getReleaseList() {
		return releaseList;
	}

	@XmlElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setReleaseList(ReleaseList releaseList) {
		this.releaseList = releaseList;
	}
}
