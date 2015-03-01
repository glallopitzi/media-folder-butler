package eu.zeroware.mediafolderbutler.utils.rest;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class MusicBrainzClient implements ExternalServicesClient {
	
	private static Logger logger = LogManager.getLogger(MusicBrainzFinder.class);
	
	@Autowired
	private MusicBrainzFinder brainzFinder;
	
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
	
}
