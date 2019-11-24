package com.example.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication	
@Controller
@EnableWebMvc
public class DemoApplication implements WebApplicationInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/")
	public String getString(){
		return "login";
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context
        = new AnnotationConfigWebApplicationContext();
      context.setConfigLocation("com.baeldung");

      container.addListener(new ContextLoaderListener(context));

      ServletRegistration.Dynamic dispatcher = container
        .addServlet("dispatcher", new DispatcherServlet(context));
        
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("*.do");
		
	}
	
	  @Bean
	  public ViewResolver viewResolver() {
	      InternalResourceViewResolver bean
	        = new InternalResourceViewResolver();
	      bean.setViewClass(JstlView.class);
	      bean.setPrefix("/view/");
	      bean.setSuffix(".jsp");
	      return bean;
	   }
	

}
