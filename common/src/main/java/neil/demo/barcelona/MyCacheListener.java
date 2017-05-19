package neil.demo.barcelona;

import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCacheListener<K,V> implements CacheEntryCreatedListener<K,V> {

	@Override
	public void onCreated(Iterable<CacheEntryEvent<? extends K, ? extends V>> iterable) throws CacheEntryListenerException {
		iterable.iterator().forEachRemaining(cacheEntryEvent -> {
			log.info("Cache entry added {} {}", cacheEntryEvent.getKey(), cacheEntryEvent.getValue());
		});
	}

}
