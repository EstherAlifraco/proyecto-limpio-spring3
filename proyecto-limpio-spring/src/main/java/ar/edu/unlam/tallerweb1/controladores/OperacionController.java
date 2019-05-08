package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*6) Usando path variables, hacer un action que reciba una operación y una cadena de caracteres y que
lleve a una vista que muestra la siguiente frase “El resultado de <nombre-operacion> sobre <cadena> es
<cadena-resultado>”, donde la <cadena-resultado> es la cadena resultante de aplicar la operación a la
cadena recibida por parámetro. Las operaciones pueden ser: pasarAMayuscula, pasarAMiniscula,
invertirOrden, cantidadDeCaracteres (en este caso se devuelve un número).*/

@Controller

public class OperacionController {

	
			//http://localhost:8080/Proyecto-limpio-spring/operacion/mayuscula/esther y naty
		@RequestMapping (path= "/operacion/{operacion}/{cadena}", method=RequestMethod.GET)
		public ModelAndView operacionCadena(@PathVariable String operacion,
				@PathVariable String cadena) {
			
			switch (operacion) {
			case "pasarAMayuscula":
				ModelMap model= new ModelMap();
				String resultado= cadena.toUpperCase();
				model.put("resultado", resultado);
				return new ModelAndView("mayuscula", model);
				
			case "pasarAMinuscula":
				ModelMap model1= new ModelMap();
				String resultado1= cadena.toLowerCase();
				model1.put("resultado", resultado1);
				return new ModelAndView("minuscula", model1);
				
			case "invertirOrden":
				if(cadena.length()==1) {
					String msj2 = "La cadena debe tener mas de un caracter";
					ModelMap errorOrden = new ModelMap();
					errorOrden.put("errorOrden", msj2);
					
					return new ModelAndView ("invertir",errorOrden);
				}
				else {
					ModelMap model2= new ModelMap();
					String resultado2= new StringBuilder(cadena).reverse().toString();
				    model2.put("resultado", resultado2);
				    
				return new ModelAndView("invertir", model2);
				}
			
			case "cantidadDeCaracteres":
				ModelMap model3= new ModelMap();
				int resultado3= cadena.length();
				model3.put("resultado", resultado3);
				return new ModelAndView("cantidad", model3);
				
			}
			String error= "Debe ingresar una operacion valida";
			ModelMap modelError= new ModelMap();
			modelError.put("msj", error);
			
			return new ModelAndView("error", modelError);
		}

	}


