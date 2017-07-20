package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

@Controller
//@RequestMapping("/prefix")
// jak się doda adnotację nad klasą to wszystkie adresy się zmienią w taki sposób:
// http://localhost:8080/SpringMVCTest/prefix/multi
public class HomeController {

	@RequestMapping("/home")	//jaki adres jest obsługiwany przez tą metodę
	@ResponseBody	//musimy dać tą adnotację że my z tej funkcji zwracamy ciało do przeglądarki
	public String getHome(){
		return "<b>Jesteś</b> w domu";
	}
	
	//na slajdach jest inaczej - funkcja tam zwraca plik jsp. slajd 31
	// niżej przykład na to:
	//dodajemy drugi mapping - tutaj wywołuję PLIK!
	@RequestMapping("/view")
	public String getView(){
		return "view2.jsp";
	}

	// żeby to testować używam aplikacji POSTMAN
	@RequestMapping(path="/multi", method={RequestMethod.DELETE, RequestMethod.PUT})	// ma być path zamiast value żeby mieć kilka metod obsłużonych
	@DeleteMapping("/delete") //można mieć dwa mappingi do tej samej metody
	@ResponseBody
	public String processMultiType(HttpServletRequest request){
		return "Request type: "+request.getMethod();
	}

	// używamy wyrażen regularnych:
//	http://localhost:8080/SpringMVCTest/patter/abc
	@GetMapping("patter/a?c")
	@ResponseBody
	public String getPatterAddress(){
		return "pattern matched";
	}
	//ciasteczka
	@GetMapping("cookie")
	@ResponseBody
	public String getSetCookie(HttpServletResponse response, HttpServletRequest request){
		response.addCookie(new Cookie("mojeCookie1", "wartoscCookie1"));
		String text="";
		if(WebUtils.getCookie(request, "nowy") != null){
			text=WebUtils.getCookie(request, "nowy").getValue();
		} else{
			
			response.addCookie(new Cookie("nowy", "wartoscNowegoCookie"));
		}
		return "cookie set "+text;
	}
	
	@RequestMapping("/cookieGet")
	@ResponseBody
	public String home(@CookieValue("nowy") String fooCookie, HttpServletRequest request) {

		return "cookie: " + fooCookie;
	}
	

}
