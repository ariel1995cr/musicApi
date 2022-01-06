package com.example.musicapi.service;

import com.example.musicapi.entity.Album;

import java.util.List;

public interface IAlbumsService {
    List<Album> buscarTodos();

    void guardar(Album album);

    void eliminar(int idAlbum);

}
