package eu.zeroware.mediafolderbutler.music.id3tag;

import java.io.File;

import eu.zeroware.mediafolderbutler.entity.Song;

public interface SongBuilder {
	
	public Song fromFile(File file);
	public File toFile(Song song);
	
}
