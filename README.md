# springIO2017

http://2017.springio.net/ - Caching Made Bootiful

Featuring Spring Boot, Hazelcast and JSR107 JCache.

Each of the modules starts listening to port 8080, Try with

```
http://localhost:8080/45
```

a few times to see how response time varies for the 45th result in the
Fibonacci series.

## Variations on adding caching

## `version1` - No caching

A simple Spring Boot web service.

## `version2` - Basic caching

Add the `@EnableCaching` and `@Cacheable` annotations, and nothing else. Spring
will provide a default implementation of the caching manager, essentially a
concurrent hashmap.

This is great start, performance is great for the 2nd and subsequent calls.
Until you restart.

## `version3` - Hazelcast server-mode caching

This is a step on from `version3`, adding the `hazelcast.xml` file so Spring Boot
will create a Hazelcast *server* and use that for caching.

If you only run one such JVM, you won't notice much difference. If you run more
than one, you can stop and restart either without losing the cached results.

## `version4` - Hazelcast client-mode caching

A more honed approach to Hazelcast caching, using client-mode. This means the
business logic -- the Fibonacci calculation -- is in the client, and the
storage of the cached results is in the server(s).

## `version5` - JCache standard

Now we use JCache, _JSR107_, the Java caching standard.

Hazelcast is the implementation provider, and still in client-mode so the
same benefits of separating storage from processing as in `version4`.

But now it's standardised, so if you don't want to use Hazelcast you can swap
in something dearer and slower.
