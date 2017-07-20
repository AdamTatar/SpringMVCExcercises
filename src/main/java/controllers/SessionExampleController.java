package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "count", "max" })	// ten kontroler w sesji przechowuje nastepujace parametry
//okazuje sie ze to jest w sumie niepotrzebne tutaj akurat. 
//możemy sie przez model odwolywac tak jak na slajdach, przez model

public class SessionExampleController {

	@RequestMapping("/sessionAdd")
	@ResponseBody
	public String home(HttpSession ses) {
		ses.setAttribute("max", 12);
		ses.setAttribute("count", 99);
		return "home";
	}

	@RequestMapping("/sessionGet")
	@ResponseBody
	public String session1(HttpSession ses) {
		
		return "session attribute max: "+ses.getAttribute("max")+" count: "+ses.getAttribute("count");
	}
}
