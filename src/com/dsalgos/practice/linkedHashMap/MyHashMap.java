package com.dsalgos.practice.linkedHashMap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
	
	private List<Entry<K, V>> buckets;
	public static final int INITIAL_CAPACITY = 1 << 4;
	private int size = 0;
	
	public MyHashMap(int capacity) {
		this.buckets = new ArrayList<>(capacity);
	}
	
	public void put(K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value, null);
		// compute hash code() and index
		int bucketIdx = key.hashCode() % getBucketSize();
		Entry<K, V> existing = buckets.get(bucketIdx);
		
		if(existing == null) {
			buckets.add(0, entry);
			size++;
		}else {
			while(existing.next != null) {
				if(existing.key.equals(key)) {
					existing.setValue(value);
					return;
				}
				existing = existing.next;
			}
			
			if(existing.key.equals(key)) {
				existing.setValue(value);
			}else {
				existing.next = entry;
			}
		}
	}
	
	public V get(K key) {
		Entry<K, V> currBucket = buckets.get(key.hashCode() % getBucketSize());

		while(currBucket != null) {
			if(currBucket.key.equals(key)) {
				return currBucket.value;
			}
			currBucket = currBucket.next;
		}

		return null;
	}
	
	public boolean remove(K key) {
		Entry<K, V> currEntry = buckets.get(key.hashCode() % getBucketSize());
		Entry<K, V> prev = null;
		
		while(currEntry != null) {
			if(currEntry.key.equals(key)) {
				if(currEntry.next == null) {
					prev.next = null;
					return true;
				}else {
					prev.next = currEntry.next;
					return true;
				}
			}
			prev = currEntry;
			currEntry = currEntry.next;
		}
		return false;
	}

	private int getBucketSize() {
		return buckets.size();
	}

	
	
	
	
	@SuppressWarnings("hiding")
	class Entry<K, V>{
		final K key;
			  V value;
		Entry<K, V> next;
		
		public Entry(K key, V value , Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public K getKey() {
			return key;
		}
		
		@Override
		public String toString() {
			return key + "=" + value ;
		}

//		implements hashcode  -- No need to implement
//		@Override
//		public int hashCode() {
//			return Objects.hash(key);
//		}

		// Implement equals method
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Entry<K, V> other = (Entry<K, V>) obj;
//			
//			return Objects.equals(key, other.key);
//		}

//		implements hashcode  -- No need to implement
//		@Override
//		public int hashCode() {
//			return Objects.hash(key, next, value);
//		}
		// Implement ToString
		
	}
}


