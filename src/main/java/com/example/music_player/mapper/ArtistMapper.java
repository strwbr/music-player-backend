package com.example.music_player.mapper;

import com.example.music_player.dto.ArtistDiscographyDto;
import com.example.music_player.entities.Artist;
import com.example.music_player.dto.ArtistDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SongMapper.class})
public interface ArtistMapper {

    Artist toArtistEntity(ArtistDto artistDto);

    ArtistDto toArtistDto(Artist artist);

//    Artist toArtistEntity(ArtistDiscographyDto artistDiscographyDto);
//
//    ArtistDiscographyDto toArtistDiscographyDto(Artist artist);

}