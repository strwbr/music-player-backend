package com.example.music_player.mapper;

import com.example.music_player.dto.SongResponseDto;
import com.example.music_player.entities.Song;
import com.example.music_player.entities.SongFile;
import com.example.music_player.service.SongUrlService;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ArtistMapper.class})
public interface SongMapper {

    Song toSongEntity(SongResponseDto songResponseDto);

    @Mapping(target = "storageUrl",
            expression = "java(generateSongUrl(song.getSongFile()))")
    SongResponseDto toSongResponseDto(Song song);

    default String generateSongUrl(SongFile songFile) {
        if (songFile == null) {
            return null;
        }
        String songFilename = songFile.getFilename();
        return SongUrlService.generateSongStorageUrl(songFilename);
    }
}
