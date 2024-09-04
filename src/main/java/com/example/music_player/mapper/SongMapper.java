package com.example.music_player.mapper;

import com.example.music_player.dto.SongResponseDto;
import com.example.music_player.entities.Song;
import com.example.music_player.entities.SongFile;
import com.example.music_player.service.SongUrlService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class SongMapper {

    @Autowired
    private SongUrlService songUrlService;

//    public abstract Song toEntity(SongResponseDto songResponseDto);

    @Mapping(target = "urlS3", source = "songFiles", qualifiedByName = "generateSongUrl")
    public abstract SongResponseDto toDto(Song song);

    @Named("generateSongUrl")
    private String generateSongUrl(Set<SongFile> songFiles) {
        if(songFiles == null || songFiles.isEmpty()) {
            return null;
        }
        String songFilename = songFiles.iterator().next().getFilename(); // если в сете только 1 эл-т
        return songUrlService.generateSongUrl(songFilename);
    }
}
