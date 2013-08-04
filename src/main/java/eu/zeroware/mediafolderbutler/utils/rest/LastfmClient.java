package eu.zeroware.mediafolderbutler.utils.rest;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.lastfm.LastfmFinder;

public class LastfmClient extends JerseyRESTClient implements
		ExternalServicesClient {

	
	@Inject private LastfmFinder lastfmFinder;

	
	public void enhanceSongInfo(Song song) {
		// TODO Auto-generated method stub
		
	}

	public void enhanceArtistInfo(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	public void enhanceAlbumInfo(Album album) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * TO REMOVE------------------- This is only for dev purpose
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector();
		
		LastfmClient client = injector.getInstance(LastfmClient.class);
		
		
		
	}

	public LastfmFinder getLastfmFinder() {
		return lastfmFinder;
	}

	public void setLastfmFinder(LastfmFinder lastfmFinder) {
		this.lastfmFinder = lastfmFinder;
	}
}
