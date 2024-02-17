package com.example.demo.repository;

import com.example.demo.model.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 23:11
 * @Project : demo
 * @Created_by : IdeaU
 */
public interface MemeRepository extends JpaRepository<Meme, Long> {
}
