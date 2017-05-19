package neil.demo.barcelona;

import javax.cache.configuration.Factory;

@SuppressWarnings({ "serial", "rawtypes" })
public class MyCacheListenerFactory implements Factory<MyCacheListener> {

	@Override
	public MyCacheListener create() {
		return new MyCacheListener();
	}

}
