package com.example.musicapi.repository;

import com.example.musicapi.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {
}
