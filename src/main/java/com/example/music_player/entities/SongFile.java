package com.example.music_player.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "song_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongFile extends BaseEntity {

    private String filename;

    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;
}