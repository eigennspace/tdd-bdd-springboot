package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 22:55
 * @Project : demo
 * @Created_by : IdeaU
 */
@Entity
@Table(name = "memes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String meme;
    private Integer likes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Meme meme = (Meme) o;
        return getId() != null && Objects.equals(getId(), meme.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}