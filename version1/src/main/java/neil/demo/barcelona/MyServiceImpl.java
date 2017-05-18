package neil.demo.barcelona;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

	@Override
	public long fibonacci(long input) {
		
		if (input < 2) {
			return 1;
		} else {
			return this.fibonacci(input - 1) + this.fibonacci(input - 2);
		}
	}

}
