package pk.com.proj.enciclothias.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import pk.com.proj.enciclothias.model.config.EnumLanguages;

@Entity
public class Verbete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="VERBETE_PTBR")
	private String verbetePtBr;
	
	@Column(name="VERBETE_MATHIES")
	private String verbeteMt;
	
	@Column(name="VERBETE_INGLES")
	private String verbeteEn;
	
	@Column(name="SIGNIFICADO")
	private String significado;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVerbetePtBr() {
		return verbetePtBr;
	}

	public void setVerbetePtBr(String verbetePtBr) {
		this.verbetePtBr = verbetePtBr;
	}

	public String getVerbeteMt() {
		return verbeteMt;
	}

	public void setVerbeteMt(String verbeteMt) {
		this.verbeteMt = verbeteMt;
	}

	public String getSignificado() {
		return significado;
	}

	public void setSignificado(String significado) {
		this.significado = significado;
	}
	
	public String getVerbeteEn() {
		return verbeteEn;
	}

	public void setVerbeteEn(String verbeteEn) {
		this.verbeteEn = verbeteEn;
	}	
	
	public String toString(){
		return this.generateMathies();
	}
	
	public String toString(EnumLanguages lingua){
		if (EnumLanguages.PORTUGUES.equals(lingua)){
			return generatePortugues();
		}
		if (EnumLanguages.MATHIES.equals(lingua)){
			return generateMathies();
		}
		return null;
	}
	
	private String generatePortugues(){
		return "Verbete: "+this.getVerbetePtBr()+" ; Significado: "+ this.getSignificado();
	}
	
	private String generateMathies(){
		return "Verbete: "+this.getVerbeteMt()+" ; Significado: "+this.getSignificado();
	}
	
}
