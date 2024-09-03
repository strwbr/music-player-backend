package com.example.music_player.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/main")
    private String mainPage(Model model) {
        return "main page";
    }
}
