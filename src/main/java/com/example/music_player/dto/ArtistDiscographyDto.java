package com.example.music_player.dto;

import lombok.Value;

import java.util.Set;

/**
 * DTO for {@link com.example.music_player.entities.Artist}
 */
@Value
public class ArtistDiscographyDto {
    Set<SongResponseDto> songs;
}