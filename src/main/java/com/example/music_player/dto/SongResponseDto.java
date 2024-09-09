package com.example.music_player.dto;

import lombok.Value;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.example.music_player.entities.Song}
 */
@Value
public class SongResponseDto {
    UUID id;
    String name;
    int durationMs;
    LocalDate releaseDate;
    String storageUrl;
    Set<ArtistDto> artists;
}