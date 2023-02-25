package leet_code.algorithms.lru;

import data_structures.linked_list.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRU<K, V> implements LRUCacheI<K, V> {
    private final int size;
    private final Map<K, Node<CacheItem<K, V>>> lru;
    private final CustomDLL<CacheItem<K, V>> dll;

    public LRU(int size) {
        this.size = size;
        this.lru = new HashMap<>();
        this.dll = new CustomDLL<>();
    }

    @Override
    public void set(K key, V value) {
        if (size == dll.length()) {

        }

        CacheItem cacheItem = new CacheItem(key, value);
        Node<CacheItem<K, V>> node = new Node<>(cacheItem);

        this.dll.addToHead(node);
        this.lru.put(key, node);
    }

    @Override
    public Optional<V> get(K key) {
        Node<CacheItem<K, V>> node = lru.get(key);

        if (node != null) {
            this.dll.moveToHead(node);
            return Optional.ofNullable(node.data.value);
        } else {
            return Optional.empty();
            // cache miss
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
