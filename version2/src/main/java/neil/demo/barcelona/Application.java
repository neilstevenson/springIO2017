package neil.demo.barcelona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <P>Duplicate the {@code main} method in this module, and copy to other
 * modules. This is <I>KISS</I> rather than <I>DRY</I>, but it makes
 * it easy for Boot Dashboard panel in the STS IDE to find.
 * </P>
 * <P>If you would prefer DRY, move this to the <I>common</I> module
 * and add the '{@code mainClass}' configuration parameter to 
 * {@code spring-boot-maven-plugin}.
 * </P>
 * <P>Use the {@link org.springframework.cache.annotation.EnableCaching @EnableCaching}
 * annotation to tell Spring to look for {@link org.springframework.cache.annotation.Cacheable @Cacheable}
 * methods.</P>
 */
@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
