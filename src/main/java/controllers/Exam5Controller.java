package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

@Controller
public class Exam5Controller {

	@RequestMapping(path = "/first/<{param1}>/<{param2}>")
	public String getFromFirst(@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2, Model model) {

		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		return "first.jsp";
	}

	@RequestMapping(path = "/createCookie/{cookieName}/{cookieValue}/{cookieTime}", method = { RequestMethod.GET })
	@ResponseBody
	public String getParamFromPathExample(@PathVariable String cookieName, @PathVariable String cookieValue,
			@PathVariable String cookieTime, HttpServletRequest request, HttpServletResponse response) {

		if (WebUtils.getCookie(request, cookieName) == null) {
			Cookie cookie = new Cookie(cookieName, cookieValue);
			cookie.setMaxAge(Integer.parseInt(cookieTime) * 60);
			response.addCookie(cookie);
		}
		return "setCookie: " + cookieName + " for " + Integer.parseInt(cookieTime) + " minutes";
	}

	@RequestMapping("/deleteCookie/{cookieName}")
	@ResponseBody
	public String deleteMyCookie(@PathVariable String cookieName, HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = WebUtils.getCookie(request, cookieName);
		if (cookie != null) {
			String cookieValue = cookie.getValue();
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
			return "Cookie: " + cookieName + " with value: " + cookieValue;
		} else {
			return "Cookie not found";
		}
	}

	// ### Zadanie 4 (4 pkt)
	//
	// W kontrolerze `Exam5Controller` napisz akcje akcje:
	// 1. Dostępną pod adresem
	// `/createCookie/{cookieName}/{coockieValue}/{cookieTime}` -
	// Ma ona nastawiać ciasteczko o podanej nazwie na podaną wartość.
	// Ciasteczko ma żyć przez `cookieTime` minut.
	// 2. Dostępną pod adresem `/deleteCookie/{cookieName}` - wyświetla
	// zawartość ciasteczka o podanej nazwie i następnie je usuwa.
	// Jeżeli takiego ciasteczka nie ma &ndash; powinien wyświetlać informację
	// "Brak ciasteczka".

}

// ### Zadanie 3 (4 pkt)
//
// 1. Stwórz kontroler o nazwie `Exam5Controller`.
// 2. Utwórz akcję dostępną pod adresem `/first/<param1>/<param2>`.
// 3. Akcja ma ma wyświetlać widok `first.jsp`.
// 4. Pobierz parametry `param1` oraz `param2`, przekaż do widoku a następnie
// wyświetl.
