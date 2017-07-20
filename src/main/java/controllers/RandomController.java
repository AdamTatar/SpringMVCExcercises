package controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/prefix")
// jak się doda adnotację nad klasą to wszystkie adresy się zmienią w taki sposób:
// http://localhost:8080/SpringMVCTest/prefix/multi
public class RandomController {

	@RequestMapping("/random")	
	@ResponseBody	
	public String getRandom(){
		Random random = new Random();
		Integer i = random.nextInt(100);
		return "<b>Wylosowano liczbe: </b><h1>"+i+"</h1>";
	}
	
	@RequestMapping("/helloView")
	public String helloView(){
		return "home.jsp";
	}
	
	@RequestMapping("/hvc")	// zadanie 5
	public String helloViewResolver(){
		return "helloViewResolver";
	}

		
}
//#### Zadanie 3
//
//1. Utwórz kontroler o nazwie `RandomController`.
//2. Utwórz akcję kontrolera o nazwie `showRandom`, która wylosuje liczbę z zakresu od 1 do 100. 
//3. Wyświetli w przeglądarce napis: **Wylosowano liczbę: <wylosowana liczba>**.

//#### Zadanie 4
//
//1. Utwórz widok o nazwie `home.jsp` ze statyczną zawartością html.
//2. Utwórz akcję `helloView`, dostępną pod adresem `/helloView` która wyświetli ten widok.

//#### Zadanie 5
//
//1. Zdefiniuj z klasie konfiguracji `ViewResolver` - skorzystaj z przykładu z prezentacji.
//2. Utwórz widok o nazwie `helloViewResolver.jsp` znajdujący się z lokalizacji określonej w konfiguracji `ViewResolver`.
//3. Utwórz akcję `helloViewResolver` , która wyświetli utworzony widok. 