package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //ta klasa konfiguruje Springa
@EnableWebMvc	// że będzie MVC
@ComponentScan(basePackages={"controllers"})// gdzie będą komponenty

public class AppConfig extends WebMvcConfigurerAdapter{
	@Bean
	public	ViewResolver	viewResolver()	{	// to jest specjalna klasa Springa
			InternalResourceViewResolver	viewResolver	=
			new	InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return	viewResolver;
	}
	
	// żeby obsługiwać statyczne zasoby (obrazek ninja.png)
	@Override
	public	void	configureDefaultServletHandling(
	DefaultServletHandlerConfigurer	configurer)	{
			configurer.enable();
	}

}
