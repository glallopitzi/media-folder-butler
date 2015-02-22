package eu.zeroware.mediafolderbutler.utils.rest.musicbrainz;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import eu.zeroware.mediafolderbutler.MediaFolderButlerModule;
import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.JerseyRESTClient;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse.AlbumBrowseResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse.ArtistBrowseResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse.SongBrowseResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.Release;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.common.Track;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.AlbumLookupResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.AlbumLookupResultReleaseMediumItem;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.ArtistLookupResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.SongLookupResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.AlbumSearchResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.ArtistSearchResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.ArtistSearchResultItem;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.SongSearchResult;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.SongSearchResultItem;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.SongSearchResultList;

public class MusicBrainzFinder extends JerseyRESTClient {
	
	private static Logger logger = LogManager.getLogger(MusicBrainzFinder.class);
	
	@Inject @Named("musicbrainz.baseServiceUrl") private String BASE_SERVICE_URL;
	
	private final String SONG_RESOURCE 		= "recording";
	private final String SONGS_RESOURCE 	= SONG_RESOURCE + "s";
	private final String ARTIST_RESOURCE 	= "artist";
	private final String ARTISTS_RESOURCE 	= ARTIST_RESOURCE + "s";
	private final String ALBUM_RESOURCE 	= "release";
	private final String ALBUMS_RESOURCE 	= ALBUM_RESOURCE + "s";
	
	private final String OFFSET_KEY 		= "offset";
	private final String LIMIT_KEY 			= "limit";
	
	public Artist browseArtist(String id){
		// get artist with given id with all the albums
		String browsedResource = ALBUM_RESOURCE;
		String linkedResource = ARTIST_RESOURCE;
		String xmlString = makeRESTBrowseRequest(browsedResource, linkedResource, id);
		if(StringUtils.isNotBlank(xmlString)){
			logger.debug(xmlString);
			ArtistBrowseResult artistBrowseResult = (ArtistBrowseResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse.ArtistBrowseResult.class}, xmlString);
			if(artistBrowseResult != null){
				// TODO
			}
		}
		return null;
	}
	
	public Album browseAlbum(String id){
		// get album with given id with all the songs
		String browsedResource = SONG_RESOURCE;
		String linkedResource = ALBUM_RESOURCE;
		String xmlString = makeRESTBrowseRequest(browsedResource, linkedResource, id);
		if(StringUtils.isNotBlank(xmlString)){
			logger.debug(xmlString);
			AlbumBrowseResult albumBrowseResult = (AlbumBrowseResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse.AlbumBrowseResult.class}, xmlString);
			if (albumBrowseResult != null){
				// TODO
			}
		}
		return null;
	}
	
	public Song browseSong(String id){
		// get song with a given id with all the albums
		String browsedResource = ALBUM_RESOURCE;
		String linkedResource = SONG_RESOURCE;
		String xmlString = makeRESTBrowseRequest(browsedResource, linkedResource, id);
		if(StringUtils.isNotBlank(xmlString)){
			logger.debug(xmlString);
			SongBrowseResult songBrowseResult = (SongBrowseResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.browse.SongBrowseResult.class}, xmlString);
			
		}
		return null;
	}
	
	public Artist lookupArtistWithAlbums(String id){
		// get artist with given id with all the albums
		String  resource = ARTIST_RESOURCE;
		String inc = "releases";
		String xmlString = makeRESTLookupRequest(resource, id, inc);
		
		if(StringUtils.isNotBlank(xmlString)){
			ArtistLookupResult artistLookupResult = (ArtistLookupResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.ArtistLookupResult.class}, xmlString);
			if(artistLookupResult != null){
				Artist artist = new Artist();
				artist.setName(artistLookupResult.getArtist().getName());
				if (artistLookupResult.getArtist().getReleaseList().getReleases() != null ){
					List<Album> albums = new ArrayList<Album>();
					for (Release release : artistLookupResult.getArtist().getReleaseList().getReleases()) {
						Album album = new Album();
						album.setArtist(artist);
						album.setName(release.getTitle());
						album.setMbid(release.getId());
						albums.add(album);
					}
					artist.setAlbums(albums);
				}
				
				return artist;
			}	
		}
		return null;
	}
	
	
	public Album lookupAlbumWithSongs(String id){
		// get album with given id with all the songs
		String  resource = ALBUM_RESOURCE;
		String inc = SONGS_RESOURCE;
		String xmlString = makeRESTLookupRequest(resource, id, inc);
		
		if(StringUtils.isNotBlank(xmlString)){
			AlbumLookupResult albumLookupResult = (AlbumLookupResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.AlbumLookupResult.class}, xmlString);
			if(albumLookupResult != null){
				List<Song> songs = new ArrayList<Song>();
				for (AlbumLookupResultReleaseMediumItem albumLookupResultReleaseMediumItem : albumLookupResult.getRelease().getAlbumLookupResultReleaseMediumList().getAlbumLookupResultReleaseMediumItems()) {
					for (Track track : albumLookupResultReleaseMediumItem.getList().getTracks()) {
						Song songToAdd = new Song();
						songToAdd.setAlbum(albumLookupResult.getRelease().getTitle());
						songToAdd.setName(track.getRecording().getTitle());
						songToAdd.setNumber(String.valueOf(track.getNumber()));
						songs.add(songToAdd);
					}
				}
				Album album = new Album();
				album.setName(albumLookupResult.getRelease().getTitle());
				album.setMbid(albumLookupResult.getRelease().getId());
				album.setTracks(songs);
				return album;
			}
		}
		return null;
	}
	
	public Song lookupSong(String id){
		// get song with given id with all the albums and artist
		String  resource = SONG_RESOURCE;
		String inc = ALBUMS_RESOURCE + "+" + ARTISTS_RESOURCE;
		String xmlString = makeRESTLookupRequest(resource, id, inc);
		
		if(StringUtils.isNotBlank(xmlString)){
			SongLookupResult songLookupResult = (SongLookupResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.lookup.SongLookupResult.class}, xmlString);
			logger.info(xmlString);
		}
		return null;
	}
	
	
	
	public Artist searchForArtistByName(String artistName) {
		String query = artistName;
		String resource = BASE_SERVICE_URL + ARTIST_RESOURCE;
		String xmlString = makeRESTSearchRequest(resource, query);
		
		if(StringUtils.isNotBlank(xmlString)){
			ArtistSearchResult artistSearchResult = (ArtistSearchResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.ArtistSearchResult.class}, xmlString);
			if(artistSearchResult != null){
				ArtistSearchResultItem artistSearchResultItem = artistSearchResult.getArtistSearchResultList().getArtistSearchResultItems().get(0);
				logger.debug("in searchForArtistByName, arid: " + artistSearchResultItem.getId());
				
				Artist artistWithAlbums = lookupArtistWithAlbums(artistSearchResultItem.getId());
				artistWithAlbums.setMbid(artistSearchResultItem.getId());
				
				List<Album> newAlbumList = new ArrayList<Album>();
				for (Album album : artistWithAlbums.getAlbums()) {
					Album albumWithSongs = lookupAlbumWithSongs(album.getMbid());
					newAlbumList.add(albumWithSongs);
				}
				artistWithAlbums.setAlbums(newAlbumList);
				return artistWithAlbums;
				
			}
		}	
		return null;
	}

	
	public Album searchForAlbumByNameAndArtist(String albumName, String artistName) {
		String query = albumName + " AND "+ARTIST_RESOURCE+":" + artistName;
		String resource = BASE_SERVICE_URL + ALBUM_RESOURCE;
		String xmlString = makeRESTSearchRequest(resource, query);
		
		if(StringUtils.isNotBlank(xmlString)){
			AlbumSearchResult albumSearchResult = (AlbumSearchResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.AlbumSearchResult.class}, xmlString);
			if(albumSearchResult != null)
				return lookupAlbumWithSongs(albumSearchResult.getAlbumSearchResultReleaseList().getAlbumSearchResultReleaseItems().get(0).getId());
		}
		return null;
	}
	
	public Album searchForAlbumByName(String albumName) {
		String query = albumName;
		String resource = BASE_SERVICE_URL + ALBUM_RESOURCE;
		String xmlString = makeRESTSearchRequest(resource, query);
		
		if(StringUtils.isNotBlank(xmlString)){
			AlbumSearchResult albumSearchResult = (AlbumSearchResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.AlbumSearchResult.class}, xmlString);
			if(albumSearchResult != null){
				logger.debug(albumSearchResult.getAlbumSearchResultReleaseList().getAlbumSearchResultReleaseItems().get(0).getId());
				return lookupAlbumWithSongs(albumSearchResult.getAlbumSearchResultReleaseList().getAlbumSearchResultReleaseItems().get(0).getId());
			}
		}
		return null;
	}

	public List<Song> searchForSongByName(String songName) {
		String query = songName;
		String resource = BASE_SERVICE_URL + SONG_RESOURCE;
		String xmlString = makeRESTSearchRequest(resource, query);
		
		if(StringUtils.isNotBlank(xmlString)){
			SongSearchResult songSearchResult = (SongSearchResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.SongSearchResult.class}, xmlString);
			if(songSearchResult != null){
				SongSearchResultList songSearchResultList = songSearchResult.getSongSearchResultList();
				List<Song> songs = new ArrayList<Song>();
				
				for (SongSearchResultItem songSearchItem : songSearchResultList.getSearchResultItems()) {
					for (Release release : songSearchItem.getReleaseList().getReleases()) {
						Song songToAdd = new Song();
						songToAdd.setName(songSearchItem.getTitle());
						songToAdd.setArtist(songSearchItem.getArtistCredit().getNameCredit().getArtist().getName());
						songToAdd.setAlbum(release.getTitle());
						songs.add(songToAdd);
					}
				}
				return songs;
			}
		}	
		return null;
	}
	
	
	public List<Song> searchForSongByNameAndArtist(String songName, String artistName) {
		String query = songName + " AND "+ARTIST_RESOURCE+":" + artistName;
		String resource = BASE_SERVICE_URL + SONG_RESOURCE;
		String xmlString = makeRESTSearchRequest(resource, query);
		
		if(StringUtils.isNotBlank(xmlString)){
			SongSearchResult songSearchResult = (SongSearchResult) unmarshall(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.SongSearchResult.class}, xmlString);
			if(songSearchResult != null){
				SongSearchResultList songSearchResultList = songSearchResult.getSongSearchResultList();
				List<Song> songs = new ArrayList<Song>();
				for (SongSearchResultItem songSearchItem : songSearchResultList.getSearchResultItems()) {
					for (Release release : songSearchItem.getReleaseList().getReleases()) {
						Song songToAdd = new Song();
						songToAdd.setName(songSearchItem.getTitle());
						songToAdd.setArtist(songSearchItem.getArtistCredit().getNameCredit().getArtist().getName());
						songToAdd.setAlbum(release.getTitle());
						songs.add(songToAdd);
					}
				}
				return songs;
			}
		}	
		return null;
	}
	
	
	public List<Song> searchForSongByNameAndArtistAndAlbum(String songName, String artistName, String albumName) {
		String query = songName + " AND " + ARTIST_RESOURCE + ":" + artistName + "&" + ALBUM_RESOURCE + ":" + albumName;
		String resource = BASE_SERVICE_URL + SONG_RESOURCE;
		String xmlString = makeRESTSearchRequest(resource, query);
		
		if (StringUtils.isNotBlank(xmlString)) {
			SongSearchResult songSearchResult = (SongSearchResult) unmarshall(new Class[] { eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.SongSearchResult.class }, xmlString);
			
			if(songSearchResult != null){
				SongSearchResultList songSearchResultList = songSearchResult.getSongSearchResultList();
				
				List<Song> songs = new ArrayList<Song>();
				for (SongSearchResultItem songSearchItem : songSearchResultList.getSearchResultItems()) {
					for (Release release : songSearchItem.getReleaseList().getReleases()) {
						Song songToAdd = new Song();
						songToAdd.setName(songSearchItem.getTitle());
						songToAdd.setArtist(songSearchItem.getArtistCredit().getNameCredit().getArtist().getName());
						songToAdd.setAlbum(release.getTitle());
						songs.add(songToAdd);
					}
				}
				return songs;
			}
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> T unmarshall(Class[] classes, String xmlString){
		try {
			JAXBContext jc = JAXBContext.newInstance(classes);
			Unmarshaller u = jc.createUnmarshaller();
			T objResult = (T) u.unmarshal( new ByteArrayInputStream (new String(xmlString.getBytes(), "UTF-8").getBytes()));
			return objResult;
		} catch (JAXBException e) {
			logger.error("some error during unmarshalling", e);
			return null;
		} catch (UnsupportedEncodingException e) {
			logger.error("some error during unmarshalling", e);
			return null;
		}
	}
	
	private String makeRESTSearchRequest(String resource, String query){
		checkForRequestBound();
		WebResource r = c
				.resource(resource)
				.queryParam("query", query)
				.queryParam(LIMIT_KEY, "1");
		logger.info("makeRESTSearchRequest: " + r.toString());
		ClientResponse response = r.accept(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
		if(response.getStatus() == 200){
			String xmlString = response.getEntity(String.class);
			if(StringUtils.isNotBlank(xmlString)){
				return xmlString;
			}
		}
		return "";
	}
	
	
	private String makeRESTLookupRequest(String resource, String id, String inc){
		checkForRequestBound();
		WebResource r = c
				.resource(BASE_SERVICE_URL)
				.path(resource)
				.path(id)
				.queryParam("inc", inc);
		logger.info("makeRESTSearchRequest: " + r.toString());
		ClientResponse response = r.accept(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
		if(response.getStatus() == 200){
			String xmlString = response.getEntity(String.class);
			if(StringUtils.isNotBlank(xmlString)){
				return xmlString;
			}
		}
		return "";
	}
	
	private String makeRESTBrowseRequest(String browsedesource, String linkedResource, String id){
		checkForRequestBound();
		WebResource r = c
				.resource(BASE_SERVICE_URL)
				.path(browsedesource)
				.queryParam(linkedResource, id);
		
		logger.info("makeRESTBrowseRequest: " + r.toString());
		ClientResponse response = r.accept(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
		if(response.getStatus() == 200){
			String xmlString = response.getEntity(String.class);
			if(StringUtils.isNotBlank(xmlString)){
				return xmlString;
			}
		}
		return "";
	}

	

	/**
	 * TO REMOVE-------------------
	 * This is only for dev purpose
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MediaFolderButlerModule());
		MusicBrainzFinder finder = injector.getInstance(MusicBrainzFinder.class);
		
		
		logger.info("-------- Start");
		
		
//		finder.browseArtist("b7ffd2af-418f-4be2-bdd1-22f8b48613da");
//		
//		finder.browseAlbum("0d9e2d13-3a3b-4823-b7bf-1f992697c527");
//		
//		finder.browseSong("787cf6d0-a44b-4562-aa5c-5c4b244576c6");
//		
//		finder.searchForAlbumByName("the fragile");
		
//		Album searchForAlbumByNameAndArtist = finder.searchForAlbumByNameAndArtist("broken", "nine inch nails");
//		if(searchForAlbumByNameAndArtist != null)
//			logger.info(searchForAlbumByNameAndArtist.toString());
//		
//		Artist searchForArtistByName = finder.searchForArtistByName("caparezza");
//		if(searchForArtistByName != null)
//			logger.info(searchForArtistByName.toString());
		
//		List<Song> searchForSongByNameAndArtistAndAlbum = finder.searchForSongByNameAndArtistAndAlbum("the wretched", "nine inch nails", "the fragile");
//		if(searchForSongByNameAndArtistAndAlbum != null){
//			
//		}
		
//		Artist lookupArtistWithAlbums = finder.lookupArtistWithAlbums("b7ffd2af-418f-4be2-bdd1-22f8b48613da");
//		Artist searchForArtistByName = finder.searchForArtistByName("Pearl Jam");
//		logger.info(searchForArtistByName.toString());
		
		
//		System.out.println("before first request: " + new Date().toGMTString());
//		finder.checkForRequestBound();
//		System.out.println("after first request: " + new Date().toGMTString());
//		finder.checkForRequestBound();
//		System.out.println("after second request: " + new Date().toGMTString());
//		finder.checkForRequestBound();
//		System.out.println("after third request: " + new Date().toGMTString());
//		finder.checkForRequestBound();
//		System.out.println("after forth request: " + new Date().toGMTString());
		
		logger.info("-------- Stop");
	}
	
}
