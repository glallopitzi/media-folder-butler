package eu.zeroware.mediafolderbutler.utils.rest;

import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;

public interface ExternalServicesClient {	
	public void enhanceSongInfo(Song song);
	public void enhanceArtistInfo(Artist artist);
	public void enhanceAlbumInfo(Album album);
}
