package neil.demo.barcelona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>For diagnostics, print the cache manager implementation as
 * part of startup.
 * </P>
 * <P>Use {@link org.springframework.core.annotation.Order @Order} so
 * this is one of the last messages produced to the log.
 * </P>
 */
@Component
@Order(value=Integer.MAX_VALUE)
@Slf4j
public class Debug implements CommandLineRunner {
	
	@Autowired(required=false)
	CacheManager cacheManager;
	
	@Override
	public void run(String... arg0) throws Exception {
		log.info("CacheManager {}", 
				(this.cacheManager==null ? "null" : this.cacheManager.getClass().getCanonicalName()));
	}

}
