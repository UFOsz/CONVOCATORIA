package com.example.models;
import javax.persistence.*;

@Entity
@Table(name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(nullable = false , unique = true)
	private Long id;
	private String nombres;
	private String apellidos;
	private String tipoDocumento;
	private String numeroDoc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	
	
	
}
