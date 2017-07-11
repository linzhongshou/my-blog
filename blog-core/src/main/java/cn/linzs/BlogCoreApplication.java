package cn.linzs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BlogCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogCoreApplication.class, args);
	}
}
