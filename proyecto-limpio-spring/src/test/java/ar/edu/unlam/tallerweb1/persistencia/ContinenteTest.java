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
	
	private Pais pais, pais1, pais2, pais3;	
	private Continente continente, continente1, continente2;
	private Ciudad ciudad, ciudad1, ciudad2, ciudad3;
	private Ubicacion ubicacion, ubicacion1, ubicacion2, ubicacion3;
	
	@Before
	public void setUp() {
		
		
		pais=new Pais();
		pais1= new Pais();
		pais2= new Pais();
		pais3= new Pais();
		
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
		
		
}
