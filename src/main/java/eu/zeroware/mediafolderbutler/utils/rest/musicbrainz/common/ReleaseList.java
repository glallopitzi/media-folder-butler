package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ReleaseList {
	
	private Long count;
	private List<Release> releases;

	@XmlElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public Long getCount() {
		return count;
	}
	@XmlAttribute
	public void setCount(Long count) {
		this.count = count;
	}
}
