package Dotin.LibraryProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryProjectApplication {

	public static void main(String[] args) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//		String result = encoder.encode("123456");
//		//'$2a$10$OfCeRtOMYZs7yTQU59msJeYY.jc.0Bykhaxj5xIcbEuEeWqs5Nk3C'
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

}
