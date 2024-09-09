package com.example.music_player.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song extends NamedEntity {

    @Column(name = "duration_ms")
    private int durationMs;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "songs")
    private Set<Artist> artists;

    @OneToMany(mappedBy = "song", orphanRemoval = true)
    private Set<SongFile> songFiles;
}