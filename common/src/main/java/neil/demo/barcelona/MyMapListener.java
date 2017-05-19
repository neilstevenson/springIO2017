package neil.demo.barcelona;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("rawtypes")
public class MyMapListener implements EntryAddedListener {

	@Override
	public void entryAdded(EntryEvent entryEvent) {
		log.info("Map entry added {} {}", entryEvent.getKey(), entryEvent.getValue());
	}

}
