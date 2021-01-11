package guru.springframework.msscbrewery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import guru.springframework.msscbrewery.web.client.BreweryClient;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
public class MsscBreweryApplication {

	private static final Logger log = LoggerFactory.getLogger(MsscBreweryApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MsscBreweryApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			BeerDto quote = restTemplate.getForObject(
					"http://localhost:8080/api/v1/beer/df5493eb-18ee-4496-a279-624109939774", BeerDto.class);
			log.info(quote.toString());
		};
	}

}
