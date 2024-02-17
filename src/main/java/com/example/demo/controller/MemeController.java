package com.example.demo.controller;

import com.example.demo.model.Meme;
import com.example.demo.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 23:18
 * @Project : demo
 * @Created_by : IdeaU
 */
@RestController
@RequestMapping("/api/v1/memes")
public class MemeController {

    @Autowired
    private MemeService memeService;

    @GetMapping
    public ResponseEntity<List<Meme>> getAllMemes() {
        return ResponseEntity.ok(memeService.retrieveAllMemes());
    }
}
