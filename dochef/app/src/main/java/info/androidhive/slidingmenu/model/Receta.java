package info.androidhive.slidingmenu.model;

import java.io.Serializable;

/**
 * Created by Celeritech Peru on 18/05/2015.
 */
public class Receta implements Serializable {

    private int id;
    private String titulo;
    private String imagen;
    private String autor;
    private String descripcion;
    private String ingredientes;
    private String preparacion;

    public Receta() {

    }

    public Receta(int id, String titulo, String imagen, String autor, String descripcion, String ingredientes, String preparacion) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.autor = autor;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receta receta = (Receta) o;

        return id == receta.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
