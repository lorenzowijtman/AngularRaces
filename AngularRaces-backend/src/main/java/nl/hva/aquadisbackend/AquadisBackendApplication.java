package nl.hva.aquadisbackend;

import nl.hva.aquadisbackend.models.UserEntity;
import nl.hva.aquadisbackend.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AquadisBackendApplication{


	public static void main(String[] args) {
		SpringApplication.run(AquadisBackendApplication.class, args);
	}


}
