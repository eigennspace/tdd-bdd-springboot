package com.example.demo.service;

import com.example.demo.model.Meme;

import java.util.List;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 23:40
 * @Project : demo
 * @Created_by : IdeaU
 */
public interface MemeService {

    List<Meme> retrieveAllMemes();
}
