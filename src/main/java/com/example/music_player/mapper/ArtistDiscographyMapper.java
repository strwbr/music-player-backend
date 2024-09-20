package com.example.music_player.mapper;

import com.example.music_player.dto.ArtistDiscographyDto;
import com.example.music_player.entities.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArtistDiscographyMapper {
    Artist toArtistEntity(ArtistDiscographyDto artistDiscographyDto);

    ArtistDiscographyDto toArtistDiscographyDto(Artist artist);
}
