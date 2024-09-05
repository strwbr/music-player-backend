package com.example.music_player.mapper;

import com.example.music_player.dto.SongResponseDto;
import com.example.music_player.entities.Song;
import com.example.music_player.entities.SongFile;
import com.example.music_player.service.SongUrlService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ArtistMapper.class})
public abstract class SongMapper {

    @Autowired
    private SongUrlService songUrlService;

    public abstract Song toSongEntity(SongResponseDto songResponseDto);

    @Mapping(target = "storageUrl", source = "songFiles", qualifiedByName = "generateSongUrl")
    public abstract SongResponseDto toSongResponseDto(Song song);

    @Named("generateSongUrl")
    private String generateSongUrl(Set<SongFile> songFiles) {
        if (songFiles == null || songFiles.isEmpty()) {
            return null;
        }
        String songFilename = songFiles.iterator().next().getFilename(); // если в сете только 1 эл-т
        return songUrlService.generateSongStorageUrl(songFilename);
    }
}
