package com.example.demo.service.impl;

import com.example.demo.model.Meme;
import com.example.demo.repository.MemeRepository;
import com.example.demo.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 23:40
 * @Project : demo
 * @Created_by : IdeaU
 */
@Service
public class MemeServiceImpl implements MemeService {

    @Autowired
    private MemeRepository memeRepository;

    @Override
    public List<Meme> retrieveAllMemes() {
        return memeRepository.findAll();
    }
}
