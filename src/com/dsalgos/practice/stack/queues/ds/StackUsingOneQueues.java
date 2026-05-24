package com.dsalgos.practice.stack.queues.ds;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueues {

	private Queue<Integer> q = new LinkedList<>();
	private int topp = -1;

	public void push(int x) {
		q.offer(x);
		topp = x;
		int size = q.size();
		while (size > 1) {
			int front = q.poll();
			q.offer(front);
			size--;
		}
	}

	public int pop() {
		int remo = q.poll();
		if (!q.isEmpty()) {
			topp = q.peek();
		}
		return remo;
	}

	public int top() {
		return topp;
	}

	public boolean empty() {
		return q.isEmpty();
	}
}
