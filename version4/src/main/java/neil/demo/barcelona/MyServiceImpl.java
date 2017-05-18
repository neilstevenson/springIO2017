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
 * Instead of {@code this.fibonacci()} calls in <I>version2</I>, use the
 * bean so that each of the recursive calls passes through Spring and
 * has its result cached. Otherwise a call for the 40th number only
 * caches this number, and we want all 40 in the sequence to be cached.
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
