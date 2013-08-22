package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tag", namespace="http://musicbrainz.org/ns/mmd-2.0#")
public class MBTagItem {

	private String name;
	private int count;
	
	public String getName() {
		return name;
	}
	
	@XmlElement(namespace="http://musicbrainz.org/ns/mmd-2.0#")
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	
	@XmlAttribute
	public void setCount(int count) {
		this.count = count;
	}
}
