package com.example.musicapi.service.jpa;

import com.example.musicapi.entity.Album;
import com.example.musicapi.repository.AlbumsRepository;
import com.example.musicapi.service.IAlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService implements IAlbumsService {
    @Autowired
    private AlbumsRepository repoAlbums;

    @Override
    public List<Album> buscarTodos() {
        return repoAlbums.findAll();
    }

    @Override
    public void guardar(Album album) {
        repoAlbums.save(album);
    }

    @Override
    public void eliminar(int idAlbum) {
        repoAlbums.deleteById(idAlbum);
    }


}
