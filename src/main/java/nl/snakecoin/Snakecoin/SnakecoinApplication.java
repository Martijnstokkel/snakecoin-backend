package nl.snakecoin.Snakecoin;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableAutoConfiguration
@SpringBootApplication
public class SnakecoinApplication {
//
//	@Override
//	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(SnakecoinApplication.class);
//    }
	public static void main(String[] args) {
		SpringApplication.run(SnakecoinApplication.class, args);
	}

}
