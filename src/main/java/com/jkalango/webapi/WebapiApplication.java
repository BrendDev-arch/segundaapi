package com.jkalango.webapi;
import com.jkalango.view.JSplash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebapiApplication {

	public static void main(String[] args) { 
		new JSplash();
		SpringApplication.run(WebapiApplication.class, args) ;
	}

}
