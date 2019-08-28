package co.com.vitarrico.app.inventario;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"co.com.vitarrico.app.*"})
public class MicroservicioInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioInventarioApplication.class, args);
	}

}
