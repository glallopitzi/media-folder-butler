package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="metadata", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class AlbumLookupResult {
	
	private AlbumLookupResultRelease release;

	
	public AlbumLookupResultRelease getRelease() {
		return release;
	}

	@XmlElement(name="release", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setRelease(AlbumLookupResultRelease release) {
		this.release = release;
	}
}
