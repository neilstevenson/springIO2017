package neil.demo.barcelona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <P>Add the {@link org.springframework.cache.annotation.Cacheable @Cacheable}
 * annotation so the results of each invocation of the {@link #fibonacci} method
 * are stored.
 * </P>
 * <P>
 * <B>NB:</B> No change to this class from <I>version4</I>.
 * </P>
 */
@Service
public class MyServiceImpl implements MyService {

	@Autowired
	MyService myService;
	
	@Override
	@Cacheable("fibonacci")
	public long fibonacci(long input) {
		
		if (input < 2) {
			return 1;
		} else {
			return this.myService.fibonacci(input - 1) + this.myService.fibonacci(input - 2);
		}
	}

}
