package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "UBICACION")
public class Ubicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name= "ID")
		private Long id;
	    @Column(name= "LATITUD")
		private double latitud;
	    @Column(name= "LONGITUD")
		private double longitud;
		
		@OneToOne
		private Continente continente;
		
		@OneToOne
		private Ciudad ciudad;
		
		//getters y setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public double getLatitud() {
			return latitud;
		}

		public void setLatitud(double latitud) {
			this.latitud = latitud;
		}

		public double getLongitud() {
			return longitud;
		}

		public void setLongitud(double longitud) {
			this.longitud = longitud;
		}

		public Continente getContinente() {
			return continente;
		}

		public void setContinente(Continente continente) {
			this.continente = continente;
		}
		
		public Ciudad getCiudad() {
			return ciudad;
		}

		public void setCiudad(Ciudad ciudad) {
			this.ciudad = ciudad;
		}	
		
}
