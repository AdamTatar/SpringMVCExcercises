package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	
public class ParametersExample {
	
	@RequestMapping("/paramRequest")
	@ResponseBody
	public String getParamFromRequestExample(HttpServletRequest request){
		String value1 = request.getParameter("param1");
		String value2 = request.getParameter("param2");
		return "values: <b>"+value1+" "+value2+"</b>";
//		http://localhost:8080/SpringMVCTest/paramRequest?param1=kot&param2=dziala
	}
	@RequestMapping("/paramAnnotation")	//slajdy od 40
	@ResponseBody
	public String getParamFromRequestExample2(@RequestParam(defaultValue="Stefan") String param1, @RequestParam(required=false) Integer param2, @RequestParam(name="paramName", required=false) String value){
		return "values: <b>"+param1+" "+param2+"</b> "+value;
//		http://localhost:8080/SpringMVCTest/paramAnnotation?param1=kot&param2=666&paramName=jajeczko
		// @RequestParam(required=false) - dzięki temu nie jest konieczny parametr param2
	}
	@RequestMapping(path="/paramPath/{resource}/{id}", method={RequestMethod.GET, RequestMethod.DELETE})// te metody nie powinny być obsługiwane w jednej funkcji, trzeba je rozdzielać
	@ResponseBody
	public String getParamFromPath(@PathVariable(name="resource") String resource, @PathVariable(name="id") Long id, HttpServletRequest request){
		return request.getMethod()+ " zasob typu: <b>"+resource+"</b> o id: <b>"+id+"</b>";
//		http://localhost:8080/SpringMVCTest/paramPath/mojResource/555

	}
	@GetMapping("/userAgent")
	@ResponseBody
	public	String	userAgent(@RequestHeader("user-agent")	String	userAgent)	{
					return	"user-agent	=	"		+	userAgent;
	}
}
