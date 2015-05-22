package dochef.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "receta")
public class Receta implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8196791492170969546L;
	private int id;
    private String titulo;
    
    private String descripcionCorta;
    
    private String descripcion;
    
    private String ingredientes;
    
    private String preparacion;
    
    private String imagen;
    
    private User autor;
    
    
    @Id
    @GeneratedValue
    @Column(name="id_receta", nullable = false, length= 10)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="titulo", nullable=false, length=255)
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name="descripcion_corta", nullable=false, length=500)
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	
	@Column(name="descripcion", nullable=false, length=2000)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	
	@Column(name="ingredientes", nullable=true, length=500)
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	@Column(name="preparacion", nullable=true, length=2000)
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	
	
	
	@Column(name="imagen", nullable=false, length=255)
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	@ManyToOne
    @JoinColumn(name = "autor", nullable = true)
	public User getAutor() {
		return autor;
	}
	public void setAutor(User autor) {
		this.autor = autor;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Receta [id=" + id + ", titulo=" + titulo
				+ ", descripcionCorta=" + descripcionCorta + ", descripcion="
				+ descripcion + ", ingredientes=" + ingredientes
				+ ", preparacion=" + preparacion + "]";
	}
	
	
	
}
