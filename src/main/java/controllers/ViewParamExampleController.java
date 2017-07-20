package controllers;
//będę przekazywał do widoków parametry

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewParam")
public class ViewParamExampleController {

	@GetMapping("/home")
	public String getView(HttpServletRequest request){
		request.setAttribute("prywatny", "jakas inna wartosc");
		return "home";
	}
	
	// to co powyżej robi tak, że w home.jsp wyświetlamy jakas inna wartosc z atrybutu prywatny
	
	@GetMapping("/homeModel")
	public String getViewModel(Model model){
		model.addAttribute("atrModelu", "jakas inna wartosc z Modelu");
		model.addAttribute("atrModelu2", "jakas inna wartosc z Modelu 222222222222222222222222222");
		return "homeModel";
	}
	
	// Model to klasa przechowująca jakies dane, sąone dostepne w widoku i mozemy sobie z niego brac.
}
