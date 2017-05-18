package neil.demo.barcelona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <P>
 * Run and time the Fibonacci calculation. Use millisecond
 * granularity.
 * </P>
 * <P>Usage, to calculate the 10th number:
 * <PRE>
 *  http://localhost:8080/10
 * </PRE>
 * </P>
 * <P>Usage, to calculate the 11th number:
 * <PRE>
 *  http://localhost:8080/11
 * </PRE>
 * </P>
 */

@RestController
public class MyController {

	@Autowired
	MyService myService;
	
	@GetMapping("/{input}")
	public MyResult fibonacci(@PathVariable long input) {

		long before = System.currentTimeMillis();
		
		long output = this.myService.fibonacci(input);
		
		long after= System.currentTimeMillis();
		
		return new MyResult(input, output, (after - before));
	}
}
