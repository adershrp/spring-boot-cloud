package com.spring.boot.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableResourceServer
//@EnableOAuth2Client
@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableConfigurationProperties
//@EnableScheduling
public class CarMakeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMakeServiceApplication.class, args);
	}
	
/*	@Bean
	@ConfigurationProperties(prefix = "security.oauth2.client")
	public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
		return new ClientCredentialsResourceDetails();
	}

	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor(){
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
	}

	@Bean
	public OAuth2RestTemplate clientCredentialsRestTemplate() {
		return new OAuth2RestTemplate(clientCredentialsResourceDetails());
	}*/

}
