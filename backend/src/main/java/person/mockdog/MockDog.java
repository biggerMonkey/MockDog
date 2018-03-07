package person.mockdog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import person.mockdog.utils.SpringContextUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class MockDog {
    public static void main(String[] args) {
        SpringApplication applicationWeb = new SpringApplication(MockDog.class);
        ApplicationContext contextWeb = applicationWeb.run(args);
        SpringContextUtil.setApplicationContext(contextWeb);
    }
}
