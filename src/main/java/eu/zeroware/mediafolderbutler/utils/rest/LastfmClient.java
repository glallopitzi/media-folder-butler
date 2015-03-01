package eu.zeroware.mediafolderbutler.utils.rest;

import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.lastfm.LastfmFinder;

public class LastfmClient extends JerseyRESTClient implements
		ExternalServicesClient {

	
	@Autowired
	private LastfmFinder lastfmFinder;

	
	public void enhanceSongInfo(Song song) {
		// TODO Auto-generated method stub
		
	}

	public void enhanceArtistInfo(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	public void enhanceAlbumInfo(Album album) {
		// TODO Auto-generated method stub
		
	}
	
	
	// Getters and setters	

	public LastfmFinder getLastfmFinder() {
		return lastfmFinder;
	}

	public void setLastfmFinder(LastfmFinder lastfmFinder) {
		this.lastfmFinder = lastfmFinder;
	}
}
