package com.disneyApi.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author Flor
 */
@Entity
public class Pelicula_serie implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2") 
    private String id;
    
    private String imagen;
    private String titulo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    private Integer calificacion;

    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "pelicula_serie_personaje",
            joinColumns = {
                    @JoinColumn(name = "pelicula_serie_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "personaje_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Personaje> personaje = new HashSet<>();
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    public Pelicula_serie() {
    }


    public Set<Personaje> getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Set<Personaje> personaje) {
        this.personaje = personaje;
    }
 

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    

    
}
