package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.ArtistCredit;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.ReleaseList;

@XmlRootElement(name="recording", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class SongSearchResultItem {
	
	private String reid;
	private String title;
	private ArtistCredit  artistCredit;
	private ReleaseList releaseList;
	
	
	public String getTitle() {
		return title;
	}
	
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlAttribute(name="id", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setReid(String reid) {
		this.reid = reid;
	}

	public String getReid() {
		return reid;
	}

	@XmlElement(name="artist-credit", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	@XmlElement(name="release-list", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setReleaseList(ReleaseList releaseList) {
		this.releaseList = releaseList;
	}

	public ReleaseList getReleaseList() {
		return releaseList;
	}
	

}
