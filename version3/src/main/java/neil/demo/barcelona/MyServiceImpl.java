package neil.demo.barcelona;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <P>Add the {@link org.springframework.cache.annotation.Cacheable @Cacheable}
 * annotation so the results of each invocation of the {@link #fibonacci} method
 * are stored.
 * </P>
 * <P>
 * <B>NB:</B> No change to this class from <I>version2</I>.
 * </P>
 */
@Service
public class MyServiceImpl implements MyService {

	@Override
	@Cacheable("fibonacci")
	public long fibonacci(long input) {
		
		if (input < 2) {
			return 1;
		} else {
			return this.fibonacci(input - 1) + this.fibonacci(input - 2);
		}
	}

}
