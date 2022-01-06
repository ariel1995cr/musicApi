package com.example.musicapi.controller;

import com.example.musicapi.entity.Album;
import com.example.musicapi.service.IAlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlbumsController {

    @Autowired
    private IAlbumsService albumsService;

    @GetMapping("/albums")
    public List<Album> buscarTodos(){
        return albumsService.buscarTodos();
    }

    @PostMapping("/albums")
    public ResponseEntity<?> guardar(@Valid @RequestBody Album album, BindingResult result){
        if(result.hasErrors()){
            return this.validar(result);
        }
        albumsService.guardar(album);
        return ResponseEntity.ok().body(album);
    }

    @PutMapping("/albums")
    public ResponseEntity<?> modificar(@Valid @RequestBody Album album, BindingResult result){
        if(result.hasErrors()){
            return this.validar(result);
        }
        albumsService.guardar(album);
        return ResponseEntity.ok().body(album);
    }

    @DeleteMapping("/albums/{id}")
    public String eliminar(@PathVariable("id") Integer idAlbum){
        albumsService.eliminar(idAlbum);
        return "Registro Eliminado";
    }

    protected ResponseEntity<?> validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.unprocessableEntity().body(errores);
    }
}
