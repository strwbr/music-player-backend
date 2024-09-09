package com.example.music_player.controllers;

import com.example.music_player.entities.Song;
import com.example.music_player.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final StorageService storageService;

    @Autowired
    public MainController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/main")
    private ResponseEntity<List<String>> mainPage(Model model) {
        List<String> songFileNames = storageService.getSongFileNames();
        return ResponseEntity.ok(songFileNames);
    }
}
