package neil.demo.barcelona;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

/**
 * <P>Specify what to use for caching, so that the default concurrent
 * hash map variant is not used.
 * </P>
 * <P>Use the Hazelcast <I>server</I> instance that Spring Boot creates
 * when it sees a {@code hazelcast.xml} file.
 * </P>
 */
@Configuration
public class MyConfig {

	@Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }
}
