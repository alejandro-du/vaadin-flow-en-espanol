package com.example.test;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alejandro Duarte
 */
@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    private Date fecha;

    public Comentario() {
        fecha = new Date();
    }

    public Comentario(String contenido) {
        this();
        setContenido(contenido);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}