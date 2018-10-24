package com.dsaa.stack;

import java.util.LinkedList;

public class Stack<T> {
	
	//Last-In-First-Out
	private LinkedList<T> listOfNodes;
	private int count = 0;
	
	public Stack() {
		listOfNodes  = new LinkedList<T>();
	}
	
	public void push(T node) {
		listOfNodes.addFirst(node);
		count++;
	}

	public T peek() {
		if(!listOfNodes.isEmpty()) {
		    return listOfNodes.getFirst();
		}
		else {
			return null;
		}
	}
	
	public T pop() {
		count--;
		return listOfNodes.removeFirst();
	}
	
	public void clear() {
		listOfNodes.clear();
		count = 0;
	}
	
	public int count() {
		return count;
	}

}
