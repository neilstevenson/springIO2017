package neil.demo.barcelona;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <P>Define an object to return for all result information.
 * </P>
 * <P>As we use <a href="http://projectlombok.org">http://projectlombok.org</a>
 * we can use the {@code @Data} annotation to save typing the getters and
 * setters.
 * </P>
 */
@AllArgsConstructor
@Data
public class MyResult {

	long	input;
	long	output;
	long	durationMilliseconds;
	
}
