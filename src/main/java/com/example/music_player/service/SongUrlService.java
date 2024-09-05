package com.example.music_player.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SongUrlService {

    @Value("${storage.endpoint}")
    private String storageEndpoint;

    @Value("${storage.bucket-name}")
    private String bucketName;

    public String generateSongStorageUrl(String filename) {
        String url = storageEndpoint + "/" + bucketName + "/" + filename;
        System.out.println("S3 storage URL = " + url);
        return url;
    }
}
