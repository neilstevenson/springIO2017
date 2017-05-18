package neil.demo.barcelona;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <P>Add the {@link org.springframework.cache.annotation.Cacheable @Cacheable}
 * annotation so the results of each invocation of the {@link #fibonacci} method
 * are stored.
 * </P>
 */
@Service
public class MyServiceImpl implements MyService {

	/** 
	 * <P>The {@link org.springframework.cache.annotation.Cacheable @Cacheable}
	 * annotation really should go on the interface not the implementations.
	 * </P>
	 */
	@Cacheable("fibonacci")
	@Override
	public long fibonacci(long input) {
		
		if (input < 2) {
			return 1;
		} else {
			return this.fibonacci(input - 1) + this.fibonacci(input - 2);
		}
	}

}
