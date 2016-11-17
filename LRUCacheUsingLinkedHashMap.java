/*
 * A special constructor is provided to create a linked hash map whose order of iteration 
 * is the order in which its entries were last accessed, from least-recently accessed to most-recently (access-order). 
 * This kind of map is well-suited to building LRU caches. Invoking the put or get method results in an access 
 * to the corresponding entry (assuming it exists after the invocation completes). The putAll method generates one entry 
 * access for each mapping in the specified map, in the order that key-value mappings are provided by the specified map's 
 * entry set iterator. No other methods generate entry accesses. In particular, operations on collection-views do not 
 * affect the order of iteration of the backing map.

The removeEldestEntry(Map.Entry) method may be overridden to impose a policy for removing stale mappings 
automatically when new mappings are added to the map.
 * 
 * 
 * 
 */
package practice.arrays;

import java.util.LinkedHashMap;

public class LRUCacheUsingLinkedHashMap {
	Cache<Integer, Integer> lru;
	public static void main(String[] args) {

		LRUCacheUsingLinkedHashMap cache = new LRUCacheUsingLinkedHashMap(2);
		cache.set(1, 2);
		cache.set(2, 3);
		cache.set(1, 5);
		cache.set(4, 5);
		cache.set(6, 7);
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));

	}
	public LRUCacheUsingLinkedHashMap(int capacity) {
		lru = new Cache<>(capacity);
	}

	public int get(int key) {
		if(lru.containsKey(key))
			return lru.get(key);
		return -1;

	}

	public void set(int key, int value) {
		lru.put(key, value);
	}

	class Cache<T, S> extends LinkedHashMap<T, S>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		LinkedHashMap<T, S> lru;
		int MAX = -1;
		public Cache(int capacity) {
			lru = new LinkedHashMap<>(capacity, 1, true);
			MAX = capacity;
		}

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<T, S> eldest) {
			return size() > MAX ;
		}
	}

}
