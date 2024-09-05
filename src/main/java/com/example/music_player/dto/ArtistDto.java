package com.example.music_player.dto;

import com.example.music_player.entities.Artist;
import lombok.Value;

import java.util.UUID;

/**
 * DTO for {@link Artist}
 */
@Value
public class ArtistDto {
    UUID id;
    String name;
    String description;
}