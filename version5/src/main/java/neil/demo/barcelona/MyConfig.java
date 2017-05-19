package neil.demo.barcelona;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.HazelcastInstance;

/**
 * <P>Create a Hazelcast client {@code @Bean} as Spring Boot <I>1.5.3</I>
 * won't do this automatically yet.
 * See <a href="https://github.com/spring-projects/spring-boot/pull/7469">PR7469</a> 
 * as it will do this in the future.
 * </P>
 * <P>Specify what to use for caching, so that the default concurrent
 * hash map variant is not used.
 * </P>
 */
@Configuration
public class MyConfig {
	
	static {
		/* These can't be varied, so don't put in a yml/properties file.
		 */
		System.setProperty("hazelcast.jcache.provider.type", "client");
		System.setProperty("spring.cache.jcache.provider", "com.hazelcast.client.cache.impl.HazelcastClientCachingProvider");
		System.setProperty("spring.cache.type", "jcache");
	}

	/* Needs Hazelcast instance to exist first
	 */
    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager();
        return new JCacheCacheManager(cacheManager);
    }
}
