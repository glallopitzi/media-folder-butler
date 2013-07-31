package eu.zeroware.mediafolderbutler.utils.rest;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import eu.zeroware.mediafolderbutler.entity.Album;
import eu.zeroware.mediafolderbutler.entity.Artist;
import eu.zeroware.mediafolderbutler.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class MusicBrainzClient implements ExternalServicesClient {
	
	private static Logger logger = LogManager.getLogger(MusicBrainzFinder.class);
	
	@Inject private MusicBrainzFinder brainzFinder;
	
	public void enhanceSongInfo(Song song) {
		List<Song> searchForSongByNameAndArtist = brainzFinder.searchForSongByNameAndArtist(song.getName(), song.getArtist());
		
		for (Song songResultItem : searchForSongByNameAndArtist) {
			logger.info(songResultItem.toString());
		}
		
	}

	public void enhanceArtistInfo(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	public void enhanceAlbumInfo(Album album) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setBrainzFinder(MusicBrainzFinder brainzFinder) {
		this.brainzFinder = brainzFinder;
	}

	public MusicBrainzFinder getBrainzFinder() {
		return brainzFinder;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * TO REMOVE-------------------
	 * This is only for dev purpose
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector();
		MusicBrainzClient client = injector.getInstance(MusicBrainzClient.class);
		logger.info("-----------Start");
		
		
		Song song = new Song();
		song.setArtist("Caparezza");
		song.setName("Ilaria condizionata");

		client.enhanceSongInfo(song);
		
		logger.info("-----------Stop");
	}
}
