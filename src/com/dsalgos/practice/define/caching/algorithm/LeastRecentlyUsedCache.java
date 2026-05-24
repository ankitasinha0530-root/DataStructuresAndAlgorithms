package com.dsalgos.practice.define.caching.algorithm;

import java.util.HashMap;
import java.util.Map;

class Node{
	Node prev, next;
	int key, value;
	
	public Node (int key, int val) {
		this.key = key;
		this.value = val;
	}
}

public class LeastRecentlyUsedCache {
	
	// https://www.youtube.com/watch?v=xDEuM5qa0zg - Explanation
	// https://www.youtube.com/watch?v=Xc4sICC8m4M&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=79 - problem solved
	
	Node head = new Node(0, 0);
	Node tail = new Node(0, 0);
	Map<Integer, Node> map = new HashMap<>();
	int capacity;
	
	// Define Constructor to initialize LRU Cache
	public LeastRecentlyUsedCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key){
		if(map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		}else {
			return -1;
		}
	}
	
	public void put(int key, int value) {
		System.out.println("Put in Map");
		if(map.containsKey(key)) {
			System.out.println("MapContains Key so remove key node");
			remove(map.get(key));
		}
		if(map.size() == capacity) {
			System.out.println("Map == capacity so remove tail.prev last node");
			remove(tail.prev);
		}
		System.out.println("Insert Node after head");
		System.out.println();
		insert(new Node(key, value));
	}
	
	private void insert(Node node) {
		System.out.println("Inside Insert method");
		map.put(node.key, node);
		
		Node headNext = head.next;
		
		node.next = headNext; // or node.next = head.next;
		head.next = node;
		node.prev = head;
		headNext.prev = node;
	}

	private void remove(Node node) {
		System.out.println("Inside Remove method");
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}


	public static void main(String[] args) {

		LeastRecentlyUsedCache lRUCache = new LeastRecentlyUsedCache(3);
		
		lRUCache.put(1, 10);
		lRUCache.put(2, 20);
		lRUCache.get(2);
		System.out.println(lRUCache.get(2));
		lRUCache.put(3, 30);
		lRUCache.put(4, 40);
		System.out.println(lRUCache.get(3));
		System.out.println(lRUCache.get(3));
		lRUCache.put(5, 50);
	}

}
