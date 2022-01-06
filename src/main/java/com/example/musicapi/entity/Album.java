package com.example.musicapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "es requerido")
    @NotBlank(message = "no puede ser blanco")
    @NotEmpty(message = "no puede estar vacio")
    private String titulo;


    @NotNull(message = "es requerido")
    private Date lanzado;

    @NotEmpty(message = "es requerido")
    private String genero;

    @NumberFormat(pattern = "000000.000", style = NumberFormat.Style.CURRENCY)
    @PositiveOrZero
    @NotNull(message = "es requerido")
    private Double precio;
}
