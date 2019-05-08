package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.criterion.Restrictions;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

import static org.assertj.core.api.Assertions.*;

public class ContinenteTest extends SpringTest{
	
	private Pais pais, pais1, pais2, pais3, pais4;	
	private Continente continente, continente1, continente2;
	private Ciudad ciudad, ciudad1, ciudad2, ciudad3;
	private Ubicacion ubicacion, ubicacion1, ubicacion2, ubicacion3;
	
	@Before
	public void setUp() {
		
		
		pais=new Pais();
		pais1= new Pais();
		pais2= new Pais();
		pais3= new Pais();
		pais4= new Pais();
		
		continente= new Continente();
		continente1= new Continente();
		continente2= new Continente();
		
		ciudad= new Ciudad();
		ciudad1= new Ciudad();
		ciudad2= new Ciudad();
		ciudad3= new Ciudad();
		
		ubicacion= new Ubicacion();
		ubicacion1= new Ubicacion();
		ubicacion2= new Ubicacion();
		ubicacion3= new Ubicacion();
		
	}
	
//1)Escribir las clases con las relaciones correspondientes	
		
//2)Buscar todos los paises de habla inglesa
		
	@Test
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")
	public void buscarPaisesDeHablaInglesa(){
		
		Pais estadosUnidos=new Pais();
		estadosUnidos.setIdioma("ingles");
		getSession().save(estadosUnidos);
		
		Pais inglaterra=new Pais();
		inglaterra.setIdioma("ingles");
		getSession().save(inglaterra);
		
		Pais argentina=new Pais();
		argentina.setIdioma("castellano");
		getSession().save(argentina);
		
		List<Pais> listaPaises= getSession().createCriteria(Pais.class)
				                  .add(Restrictions.eq("idioma","ingles"))
								  .list();
		
		assertThat(listaPaises).hasSize(2);
	}
	
//3) Hacer con junit un test que busque todos los países del continente europeo.
	
    @Test
    @Transactional
    @Rollback(true)
    @SuppressWarnings("unchecked")
    public void buscarPaisesContinenteEuropeo() {
    	
    	continente.setNombre("Europa");
    	
    	continente1.setNombre("America");
    	
    	continente2.setNombre("Africa");
    	
    	pais.setNombre("España");
    	pais.setIdioma("español");
    	pais.setContinente(continente);
    	
    	pais1.setNombre("Inglaterra");
    	pais1.setIdioma("Ingles");
    	pais1.setContinente(continente);
    	
		pais2.setNombre("Irlanda");
		pais2.setIdioma("ingles");
		pais2.setContinente(continente);
		
		pais3.setNombre("Argentina");
		pais3.setIdioma("español");
		pais3.setContinente(continente1);
		
		pais4.setNombre("Egipto");
		pais4.setIdioma("Arabe");
		pais4.setContinente(continente2);
    	
    	getSession().save(continente);
    	getSession().save(continente1);
    	getSession().save(continente2);
    	
    	getSession().save(pais);
    	getSession().save(pais1);
    	getSession().save(pais2);
    	getSession().save(pais3);
    	getSession().save(pais4);
    	
    	List<Pais> list=
    			getSession().createCriteria(Pais.class)
    			.createAlias("continente", "c")
    			.add(Restrictions.eq("c.nombre", "Europa"))
    			.list();
    	
    	assertThat(list.size()).isEqualTo(3);
    	
    		
    }
    
    
//4) Hacer con junit un test que busque todos los países cuya capital están al norte del trópico de cáncer. 
    	
    @Test
    @Transactional
    @Rollback(true)
    @SuppressWarnings("unchecked")
    public void buscarPaisesCapitalSuTropicoDeCancer() {
    
    	pais.setNombre("Inglaterra");
    	pais.setIdioma("Ingles");
    	
		pais1.setNombre("Irlanda");
		pais1.setIdioma("ingles");
		
		pais2.setNombre("Argentina");
		pais2.setIdioma("español");
    	
    	pais3.setNombre("Francia");
		pais3.setIdioma("frances");
    	
    	
        ciudad.setNombre("Londres");
        
    	ciudad1.setNombre("Dublin");

    	ciudad2.setNombre("Buenos Aires");
    	
    	ciudad3.setNombre("Paris");
    	
        pais.setCiudad(ciudad);
    	pais1.setCiudad(ciudad1);
    	pais2.setCiudad(ciudad2);
    	pais3.setCiudad(ciudad3);
    	
    	
    	ubicacion.setLatitud(51.5072);
    	
    	ubicacion1.setLatitud(53.3434);
    	
    	ubicacion2.setLatitud(-34.6083);
    	
    	ubicacion3.setLatitud(48.8667);
    	
    	ciudad.setUbicacion(ubicacion);
    	ciudad1.setUbicacion(ubicacion1);
    	ciudad2.setUbicacion(ubicacion2);
    	ciudad3.setUbicacion(ubicacion3);
    	
    	getSession().save(pais);
		getSession().save(pais1);
		getSession().save(pais2);
		getSession().save(pais3);
    	
    	getSession().save(ciudad);
		getSession().save(ciudad1);
		getSession().save(ciudad2);
		getSession().save(ciudad3);	    	
		
		getSession().save(ubicacion);
		getSession().save(ubicacion1);
		getSession().save(ubicacion2);
		getSession().save(ubicacion3);
	
		
		List <Pais> list=
				getSession().createCriteria(Pais.class)
				.createAlias("capital", "ciu")
				.createAlias("ciu.ubicacion", "ubi")
				.add(Restrictions.ge("ubi.latitud", new Double(23.2614)))
				.list();
		
			assertThat(list.size()).isEqualTo(3);	
				
    }
    
//5)Buscar todas las ciudades del hemisferio sur
    
    @Test
    @Transactional
    @Rollback(true)
    @SuppressWarnings("unchecked")
    public void ciudadesDelHemisferioSur() {
    	
        ciudad.setNombre("Londres");
        
    	ciudad1.setNombre("Montevideo");

    	ciudad2.setNombre("Buenos Aires");
    	
    	ciudad3.setNombre("Sidney");
    	
        ubicacion.setLatitud(51.5072);
    	
    	ubicacion1.setLatitud(-34.8833);
    	
    	ubicacion2.setLatitud(-34.6083);
    	
    	ubicacion3.setLatitud(-33.8667);
    	
    	ciudad.setUbicacion(ubicacion);
    	ciudad1.setUbicacion(ubicacion1);
    	ciudad2.setUbicacion(ubicacion2);
    	ciudad3.setUbicacion(ubicacion3);
    	
    	getSession().save(ciudad);
		getSession().save(ciudad1);
		getSession().save(ciudad2);
		getSession().save(ciudad3);	    	
		
		getSession().save(ubicacion);
		getSession().save(ubicacion1);
		getSession().save(ubicacion2);
		getSession().save(ubicacion3);
		
		List <Ciudad> list=
				getSession().createCriteria(Ciudad.class)
				.createAlias("ubicacion", "ubi")
				.add(Restrictions.le("ubi.latitud", new Double(0.0)))
				.list();
		
			assertThat(list.size()).isEqualTo(3);	
							
    } 
    
}
