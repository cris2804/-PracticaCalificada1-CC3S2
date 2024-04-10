
package io.collective;

import java.time.Clock;

public class SimpleAgedCache {
    Clock tiempo = null;
    final String clave ;
    final String valor;

    public SimpleAgedCache() {
        this.tiempo = tiempo;
    }


    public void put(String aKey, String aValue, int i) {
        cache.put(akey, avalue);
        expirationTimes.put(akey, tiempo.millis() + i);
    }

    public boolean isEmpty() {
        return
    }

    public int size() {
    }

    public String get(String aKey) {
    }


//    public Clock getClock() {
    /*
    * package io.collective;

import java.time.Clock;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SimpleAgedCache {
    private final Clock tiempo;
    private final Map<String, String> cache = new HashMap<>();
    private final Map<String, Long> expirationTimes = new HashMap<>();

    public SimpleAgedCache(Clock tiempo) {
        this.tiempo = tiempo;
    }

    public void put(String key, String value, long expirationMillis) {
        cache.put(key, value);
        expirationTimes.put(key, tiempo.millis() + expirationMillis);
    }

    public String get(String key) {
        if(cache.containsKey(key) && isNotExpired(key)) {
            return cache.get(key);
        }
        return null;
    }

    public int size() {
        return cache.size();
    }

    public boolean isEmpty() {
        return cache.isEmpty();
    }

    private boolean isNotExpired(String key) {
        return tiempo.millis() < expirationTimes.get(key);
    }
}
    *
    * */
//        return clock;
//    }
}


