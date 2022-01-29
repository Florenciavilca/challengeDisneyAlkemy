package com.disneyApi.demo.entities;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Flor
 */
@Entity
public class Genero implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2") 
    private String id;
    private String imagen;
    private String nombre;
    
    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Pelicula_serie> peliculas;


    public Genero() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<Pelicula_serie> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula_serie> peliculas) {
        this.peliculas = peliculas;
    }
    
    

}
