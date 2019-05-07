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
    
    
//4- Hacer con junit un test que busque todos los países cuya capital están al norte del trópico de cáncer. 
    	
}
