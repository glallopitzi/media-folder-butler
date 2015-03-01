package eu.zeroware.mediafolderbutler.utils.rest.lastfm;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Chart;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.JerseyRESTClient;

public class LastfmFinder extends JerseyRESTClient {
	
	private static final Logger logger = Logger.getLogger(LastfmFinder.class);
	
	@Value("lastfm.baseServiceUrl") private String BASE_SERVICE_URL;
	@Value("lastfm.apiToken") private String API_TOKEN;
	@Value("lastfm.apiSecret") private String API_SECRET;
	@Value("lastfm.apiUser") private String API_USER;
	
	private String token;
	
	private final String TOKEN_RESOURCE = "auth.gettoken";
	
	private void init(){
		Caller.getInstance().setUserAgent( getRealUserAgent() );
		Caller.getInstance().setDebugMode(true);
		checkForRequestBound();
	}
	
	
	public List<eu.zeroware.mediafolderbutler.music.entity.Artist> searchForArtistByName(String artistName){
		init();
		List<eu.zeroware.mediafolderbutler.music.entity.Artist> result = new ArrayList<eu.zeroware.mediafolderbutler.music.entity.Artist>();
		logger.info("Artist search result for " + artistName);
		Collection<Artist> searchedArtists = Artist.search(artistName, API_TOKEN);
	    for (Artist artist : searchedArtists) {
	    	logger.info(artist.getName());
	    	eu.zeroware.mediafolderbutler.music.entity.Artist toAdd = new eu.zeroware.mediafolderbutler.music.entity.Artist();
	    	toAdd.setName(artist.getName());
	    	result.add(toAdd);
	    }
	    
		return result;
	}
	
	public List<eu.zeroware.mediafolderbutler.music.entity.Album> searchForAlbumByName(String albumName){
		init();
		logger.info("Album search result for " + albumName);
		Collection<Album> searchedAlbums = Album.search(albumName, API_TOKEN);
		for (Album album : searchedAlbums) {
	        logger.info(album.getName() + " " + album.getArtist());
		}
		return null;
	}
	
	public List<Song> searchForSongByName(String songName){
		init();
		List<Song> songs = new ArrayList<Song>();
		
		logger.info("Song search result for: " + songName);
		Collection<Track> search = Track.search(songName, API_TOKEN);
		for (Track track : search) {
			Track trackInfo = Track.getInfo(track.getArtist(), track.getMbid(), API_TOKEN);
			if(StringUtils.isNotBlank(track.getArtist()) && StringUtils.isNotBlank(track.getAlbum())){
				Artist artistInfo = Artist.getInfo(track.getArtist(), API_TOKEN);
				Album albumInfo = Album.getInfo(track.getArtist(), track.getAlbum(), API_TOKEN);

				Song songToAdd = new Song();
				
				songToAdd.setName(trackInfo.getName());
				songToAdd.setArtist(artistInfo.getName());
				songToAdd.setAlbum(albumInfo.getName());
				songToAdd.setNumber(String.valueOf(trackInfo.getPosition()));

				if(albumInfo.getReleaseDate() != null){
					DateFormat format = DateFormat.getDateInstance();
				    String year = format.format(albumInfo.getReleaseDate());
					songToAdd.setYear(year);
				}else{
					songToAdd.setYear("");
				}
				if(songToAdd.isComplete())
					songs.add(songToAdd);
				
			}
		}
		return songs;
	}
	
	public List<Song> searchForSongByNameAndArtist(String songName, String artistName){
		init();
		List<Song> songs = new ArrayList<Song>();

		logger.info("Song search result for: " + songName);
		Collection<Track> search = Track.search(songName, API_TOKEN);
		for (Track track : search) {
			Track trackInfo = Track.getInfo(track.getArtist(), track.getName(), API_TOKEN);
			if(StringUtils.isNotBlank(track.getArtist()) && StringUtils.isNotBlank(track.getAlbum())){
				Artist artistInfo = Artist.getInfo(track.getArtist(), API_TOKEN);
				Album albumInfo = Album.getInfo(track.getArtist(), track.getAlbum(), API_TOKEN);

				Song songToAdd = new Song();
				
				songToAdd.setName(trackInfo.getName());
				songToAdd.setArtist(artistInfo.getName());
				songToAdd.setAlbum(albumInfo.getName());
				songToAdd.setNumber(String.valueOf(trackInfo.getPosition()));

				if(albumInfo.getReleaseDate() != null){
					DateFormat format = DateFormat.getDateInstance();
				    String year = format.format(albumInfo.getReleaseDate());
					songToAdd.setYear(year);
				}else{
					songToAdd.setYear("");
				}
				if(songToAdd.isComplete())
					songs.add(songToAdd);
				
			}
		}
		return songs;
	}
	
	public Song searchForSongByNameArtistAndAlbum(String songName, String artistName, String albumName){
		init();
		
		logger.info("Artist search result for: " + artistName);
		Collection<Artist> searchedArtists = Artist.search(artistName, API_TOKEN);
	    for (Artist artist : searchedArtists) {
	        logger.info(artist.getName());
	    }
	    
		return null;
	}
	
	public void getUserLastWeekCharts(String userName){
		init();
	    Chart<Artist> chart = User.getWeeklyArtistChart(userName, 10, API_TOKEN);
	    DateFormat format = DateFormat.getDateInstance();
	    String from = format.format(chart.getFrom());
	    String to = format.format(chart.getTo());
	    
	    logger.info("Charts for "+ userName + " for the week from " + from + " to " + to);
	    Collection<Artist> artists = chart.getEntries();
	    for (Artist artist : artists) {
	        logger.info(artist.getName());
	    }
	}
	
	
	
	private void getAuthToken() {
		WebResource r = c.
				resource(BASE_SERVICE_URL)
				.queryParam("method", TOKEN_RESOURCE)
				.queryParam("api_key", API_TOKEN)
				.queryParam("api_sig", API_SECRET);
		
		ClientResponse response = r.accept(MediaType.APPLICATION_XML_TYPE).get(ClientResponse.class);
		if(response.getStatus() == 200){
			String xmlString = response.getEntity(String.class);
			if(StringUtils.isNotBlank(xmlString)){
				try {
					JAXBContext jc = JAXBContext.newInstance(new Class[] {eu.zeroware.mediafolderbutler.utils.rest.lastfm.TokenRequestResult.class});
					Unmarshaller u = jc.createUnmarshaller();
					
					TokenRequestResult tokenRequestResult = (TokenRequestResult) u.unmarshal( new ByteArrayInputStream (xmlString.getBytes()));
//					if(StringUtils.isNotBlank(tokenRequestResult,getAuthToken()))
//						outln("Token received: " + tokenRequestResult.getToken());
					this.token = tokenRequestResult.getToken();
				} catch (JAXBException e) {
					e.printStackTrace();
					this.token = "";
				}
			}
		}
		this.token = "";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
