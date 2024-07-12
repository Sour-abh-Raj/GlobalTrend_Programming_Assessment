import java.util.*;

class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
    private LinkedHashMap<Integer, Integer> lruCache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruCache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int value = cache.get(key);
        lruCache.get(key);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            lruCache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                int oldestKey = lruCache.keySet().iterator().next();
                cache.remove(oldestKey);
                lruCache.remove(oldestKey);
            }
            cache.put(key, value);
            lruCache.put(key, value);
        }
    }
}

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
