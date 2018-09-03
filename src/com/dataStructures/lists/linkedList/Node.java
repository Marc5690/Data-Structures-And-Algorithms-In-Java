package com.dataStructures.lists.linkedList;

public class Node {
	
	int value = 0;
	Node next = null;
	
	public Node(int value) {
		this.value = value;
	}
	
	public String toString() {
		return "Value: " + value; //+ ", Next: " + next;
	}

}
