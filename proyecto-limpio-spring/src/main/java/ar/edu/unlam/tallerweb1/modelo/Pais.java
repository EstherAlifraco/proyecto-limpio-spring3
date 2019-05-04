package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "PAIS")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name= "ID")
		private Long id;
	    @Column(name= "NOMBRE")
		private String nombre;
	    @Column(name= "HABITANTE")
		private Integer habitantes;
	    @Column(name= "IDIOMA")
		private String idioma;
		
	    @OneToOne
		private Ciudad capital;
				
		@ManyToOne
		private Continente continente;
		
		//getters y setters
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Integer getHabitantes() {
			return habitantes;
		}
		public void setHabitantes(Integer habitantes) {
			this.habitantes = habitantes;
		}
		public String getIdioma() {
			return idioma;
		}
		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}

		public Continente getContinente() {
			return continente;
		}
		public void setContinente(Continente continente) {
			this.continente = continente;
		}

		public Ciudad getCiudad() {
			return capital;
		}

		public void setCiudad(Ciudad ciudad) {
			this.capital = ciudad;
		}
		
}
