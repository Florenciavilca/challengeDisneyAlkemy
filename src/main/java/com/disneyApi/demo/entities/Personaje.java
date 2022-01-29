package com.disneyApi.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Flor
 */
@Entity
public class Personaje implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2") 
    private String id;
    
    private String imagen;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    @ManyToMany(mappedBy = "personaje", fetch = FetchType.LAZY)
    private Set<Pelicula_serie> peliculaAparicion = new HashSet<>();

    public Personaje() {
    }


    public Set<Pelicula_serie> getPeliculaAparicion() {
        return peliculaAparicion;
    }

    public void setPeliculaAparicion(Set<Pelicula_serie> peliculaAparicion) {
        this.peliculaAparicion = peliculaAparicion;
    }
    
    


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    
}
