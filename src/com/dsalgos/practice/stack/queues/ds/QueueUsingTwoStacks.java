package com.dsalgos.practice.stack.queues.ds;

import java.util.Stack;

public class QueueUsingTwoStacks {
	
	  // Stacks to maintain the queue
    Stack<Integer> primaryStack;
    Stack<Integer> secondaryStack;
    
    // Variable to store the front element (peek)
    int peek;

    public QueueUsingTwoStacks() {
        primaryStack = new Stack<>();
        secondaryStack = new Stack<>();
    }
    
    public void push(int x) {
        // If the primary stack is empty, set x as the peek element
        if(primaryStack.isEmpty()) {
            peek = x;
        }
        // Push the element into the primary stack
        primaryStack.push(x);
    }
    
    public int pop() {
        // Transfer elements from primary to secondary stack to reverse order
        while(!primaryStack.isEmpty()){
            secondaryStack.push(primaryStack.pop());
        }
        
        // Pop the front element from the secondary stack
        int popped = secondaryStack.pop();
        
        // If secondary stack is not empty, update peek to the new front element
        if(!secondaryStack.isEmpty()) {
            peek = secondaryStack.peek();
        }
        
        // Transfer elements back to the primary stack
        while(!secondaryStack.isEmpty()){
            primaryStack.push(secondaryStack.pop());
        }
        
        // Return the popped element
        return popped;
    }
    
    public int peek() {
        return peek;
    }
    
    public boolean empty() {
        return primaryStack.isEmpty();
    }

}
