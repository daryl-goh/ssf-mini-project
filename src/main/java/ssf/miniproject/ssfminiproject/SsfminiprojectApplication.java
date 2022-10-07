package ssf.miniproject.ssfminiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class SsfminiprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsfminiprojectApplication.class, args);
	}

}
