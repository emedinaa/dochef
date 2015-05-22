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
@Table(name = "plan")
public class Plan implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -8196791492170969546L;
	private int id;
    private String titulo;

    private String descripcionCorta;
    
    private String descripcion;
    
    //Dieta
    
    private String lblAntesDesayuno;
    
    private String antesDesayuno;
    
    private String lblDesayuno;
    
    private String desayuno;
    
    private String lblMerienda1;
    
    private String merienda1;
    
    private String lblMerienda2;
    
    private String merienda2;
    
    private String lblAlmuerzo;
    
    private String almuerzo;
    
    private String lblMediaTarde1;
    
    private String mediaTarde1;
    
    private String lblMediaTarde2;
    
    private String mediaTarde2;
    
    private String lblCena;
    
    private String cena;
    
    
    
    private User autor;
    
    private String imagen;
    
    private String pdf;
    
    private String video;

    @Id
    @GeneratedValue
    @Column(name="id_plan", nullable = false, length= 10)
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
	
	@Column(name="desayuno", nullable=true, length=500)
	public String getDesayuno() {
		return desayuno;
	}
	public void setDesayuno(String desayuno) {
		this.desayuno = desayuno;
	}
	
	@Column(name="almuerzo", nullable=true, length=500)
	public String getAlmuerzo() {
		return almuerzo;
	}
	public void setAlmuerzo(String almuerzo) {
		this.almuerzo = almuerzo;
	}
	
	
	@Column(name="cena", nullable=true, length=500)
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	

	
	
	
	
	@Column(name="antes_desayuno", nullable=true, length=500)
    public String getAntesDesayuno() {
		return antesDesayuno;
	}
	public void setAntesDesayuno(String antesDesayuno) {
		this.antesDesayuno = antesDesayuno;
	}
	
	@Column(name="merienda1", nullable=true, length=500)
	public String getMerienda1() {
		return merienda1;
	}
	public void setMerienda1(String merienda1) {
		this.merienda1 = merienda1;
	}
	@Column(name="merienda2", nullable=true, length=500)
	public String getMerienda2() {
		return merienda2;
	}
	public void setMerienda2(String merienda2) {
		this.merienda2 = merienda2;
	}
	@Column(name="media_tarde1", nullable=true, length=500)
	public String getMediaTarde1() {
		return mediaTarde1;
	}
	public void setMediaTarde1(String mediaTarde1) {
		this.mediaTarde1 = mediaTarde1;
	}
	@Column(name="media_tarde2", nullable=true, length=500)
	public String getMediaTarde2() {
		return mediaTarde2;
	}
	public void setMediaTarde2(String mediaTarde2) {
		this.mediaTarde2 = mediaTarde2;
	}
	
	
	
	
	
	@Column(name="lbl_antes_desayuno", nullable=true, length=255)
	public String getLblAntesDesayuno() {
		return lblAntesDesayuno;
	}
	public void setLblAntesDesayuno(String lblAntesDesayuno) {
		this.lblAntesDesayuno = lblAntesDesayuno;
	}
	@Column(name="lbl_desayuno", nullable=true, length=255)
	public String getLblDesayuno() {
		return lblDesayuno;
	}
	public void setLblDesayuno(String lblDesayuno) {
		this.lblDesayuno = lblDesayuno;
	}
	@Column(name="lbl_merienda1", nullable=true, length=255)
	public String getLblMerienda1() {
		return lblMerienda1;
	}
	public void setLblMerienda1(String lblMerienda1) {
		this.lblMerienda1 = lblMerienda1;
	}
	@Column(name="lbl_merienda2", nullable=true, length=255)
	public String getLblMerienda2() {
		return lblMerienda2;
	}
	public void setLblMerienda2(String lblMerienda2) {
		this.lblMerienda2 = lblMerienda2;
	}
	@Column(name="lbl_almuerzo", nullable=true, length=255)
	public String getLblAlmuerzo() {
		return lblAlmuerzo;
	}
	public void setLblAlmuerzo(String lblAlmuerzo) {
		this.lblAlmuerzo = lblAlmuerzo;
	}
	@Column(name="lbl_media_tarde1", nullable=true, length=255)
	public String getLblMediaTarde1() {
		return lblMediaTarde1;
	}
	public void setLblMediaTarde1(String lblMediaTarde1) {
		this.lblMediaTarde1 = lblMediaTarde1;
	}
	@Column(name="lbl_media_tarde2", nullable=true, length=255)
	public String getLblMediaTarde2() {
		return lblMediaTarde2;
	}
	public void setLblMediaTarde2(String lblMediaTarde2) {
		this.lblMediaTarde2 = lblMediaTarde2;
	}
	@Column(name="lbl_cena", nullable=true, length=255)
	public String getLblCena() {
		return lblCena;
	}
	public void setLblCena(String lblCena) {
		this.lblCena = lblCena;
	}
	@ManyToOne
    @JoinColumn(name = "autor", nullable = true)
	public User getAutor() {
		return autor;
	}
	public void setAutor(User autor) {
		this.autor = autor;
	}
	
	
	
	@Column(name="imagen", nullable=true, length=255)
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Column(name="archivo", nullable=true, length=255)
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	@Column(name="video", nullable=true, length=255)
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
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
		Plan other = (Plan) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Plan [id=" + id + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", antesDesayuno=" + antesDesayuno
				+ ", desayuno=" + desayuno + ", merienda1=" + merienda1
				+ ", merienda2=" + merienda2 + ", almuerzo=" + almuerzo
				+ ", mediaTarde1=" + mediaTarde1 + ", mediaTarde2="
				+ mediaTarde2 + ", cena=" + cena + ", autor=" + autor + "]";
	}

    
    
    
}
