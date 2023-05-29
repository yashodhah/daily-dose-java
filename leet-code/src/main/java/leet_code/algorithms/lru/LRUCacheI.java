package leet_code.algorithms.lru;

import java.util.Optional;

public interface LRUCacheI<K, V> {
    void set(K key, V value);

    Optional<V> get(K key);

    int size();
}
