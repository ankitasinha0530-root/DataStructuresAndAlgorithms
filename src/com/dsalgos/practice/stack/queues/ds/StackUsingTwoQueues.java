package com.dsalgos.practice.stack.queues.ds;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

	Queue<Integer> firstQ = new LinkedList<>();
	Queue<Integer> secondQ = new LinkedList<>();
	static int currentSize = 0;

	StackUsingTwoQueues() {
		currentSize = 0;
	}

	int top() {
		if (firstQ.isEmpty()) {
			return -1;
		}
		int topEle = -1;
		while (firstQ.size() > 0) {
			int x = firstQ.peek();
			if (firstQ.size() == 1) {
				topEle = x;
			}
			secondQ.add(x);
			firstQ.remove();
		}
		Queue<Integer> tempQ = firstQ;
		firstQ = secondQ;
		secondQ = tempQ;
		return topEle;
	}

	int getSize() {
		return currentSize;
	}

	void push(int val) {
		firstQ.add(val);
		currentSize += 1;
	}

	int pop() {
		int val = 0;
		if (!firstQ.isEmpty()) {
			while (firstQ.size() != 1) {
				int x = firstQ.peek();
				secondQ.add(x);
				firstQ.remove();
			}
			val = firstQ.remove();
			currentSize -= 1;
			Queue<Integer> tempQ = firstQ;
			firstQ = secondQ;
			secondQ = tempQ;
		}
		return val;
	}
	
	

}
