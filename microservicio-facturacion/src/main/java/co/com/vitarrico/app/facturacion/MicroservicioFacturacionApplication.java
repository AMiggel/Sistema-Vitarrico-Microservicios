package co.com.vitarrico.app.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EntityScan({"co.com.vitarrico.app.*"})
public class MicroservicioFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioFacturacionApplication.class, args);
	}

}
