package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="artist-credit", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class ArtistCredit {
	
	private NameCredit nameCredit;

	@XmlElement(name="name-credit", namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setNameCredit(NameCredit nameCredit) {
		this.nameCredit = nameCredit;
	}

	public NameCredit getNameCredit() {
		return nameCredit;
	}

}
