package encacheGroup.encacheArtifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/*第二种方式

	通过@Configuration+@ComponentScan开启注解扫描并自动注册相应的注解Bean*/
}
