package com.example.music_player.dto;

import com.example.music_player.entities.Song;
import lombok.Value;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link Song}
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