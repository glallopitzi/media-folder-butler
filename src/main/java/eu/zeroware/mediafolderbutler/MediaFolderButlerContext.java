package eu.zeroware.mediafolderbutler;

import org.springframework.context.annotation.Bean;

import eu.zeroware.mediafolderbutler.music.id3tag.SongBuilder;
import eu.zeroware.mediafolderbutler.music.id3tag.SongBuilderJAudioTagger;

public class MediaFolderButlerContext {

	@Bean
	SongBuilder getSongBuilder(){
		return new SongBuilderJAudioTagger();
	}
}
