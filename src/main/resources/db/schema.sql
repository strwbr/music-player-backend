CREATE TABLE IF NOT EXISTS songs (
  id UUID NOT NULL,
   name VARCHAR(255),
   duration_ms INTEGER,
   release_date date,
   CONSTRAINT pk_songs PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS song_files (
  id UUID NOT NULL,
   filename VARCHAR(255),
   song_id UUID,
   CONSTRAINT pk_song_files PRIMARY KEY (id)
);

--ALTER TABLE song_files ADD CONSTRAINT FK_SONG_FILES_ON_SONG FOREIGN KEY (song_id) REFERENCES songs (id);

CREATE TABLE IF NOT EXISTS artists (
  id UUID NOT NULL,
   name VARCHAR(255),
   description VARCHAR(255),
   CONSTRAINT pk_artists PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS artist_discography (
  artist_id UUID NOT NULL,
   song_id UUID NOT NULL,
   CONSTRAINT pk_artist_discography PRIMARY KEY (artist_id, song_id)
);

--ALTER TABLE artist_discography ADD CONSTRAINT fk_artdis_on_artist FOREIGN KEY (artist_id) REFERENCES artists (id);

--ALTER TABLE artist_discography ADD CONSTRAINT fk_artdis_on_song FOREIGN KEY (song_id) REFERENCES songs (id);