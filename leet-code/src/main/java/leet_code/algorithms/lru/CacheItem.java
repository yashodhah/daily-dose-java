package leet_code.algorithms.lru;

public class CacheItem<K, V> {
    K key;
    V value;

    public CacheItem(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
