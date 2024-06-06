package com.myapp.rest_client_DanVega;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.myapp.rest_client_DanVega.client.JsonPlaceholderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class RestClientDanVegaApplication {

	public static void main(String[] args) {SpringApplication.run(RestClientDanVegaApplication.class, args);
	}

	@Bean
	JsonPlaceholderService jsonPlaceholderService(){
		RestClient client = RestClient.create("http://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(client))
				.build();
		return factory.createClient(JsonPlaceholderService.class);
	}


}
