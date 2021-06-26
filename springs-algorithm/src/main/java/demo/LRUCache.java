package Impl.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 简单用LinkedHashMap来实现的LRU算法的缓存
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;
    public LRUCache(int cacheSize) {
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> map = new LRUCache<>(10);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        map.get(2);
        System.out.println(map);
        map.put(11, 11);
        System.out.println(map);
    }
}
