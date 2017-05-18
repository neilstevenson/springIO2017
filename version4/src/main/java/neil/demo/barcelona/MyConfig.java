package neil.demo.barcelona;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
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
 * <P>The change to this class from <I>version3</I> is just to explicitly
 * create the Hazelcast instance {@code @Bean}.
 * </P>
 */
@Configuration
public class MyConfig {

	@Bean
	public HazelcastInstance hazelcastInstance() throws Exception {
		ClientConfig clientConfig = new XmlClientConfigBuilder("hazelcast-client.xml").build();
		return HazelcastClient.newHazelcastClient(clientConfig);
	}

	@Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance);
    }

}
