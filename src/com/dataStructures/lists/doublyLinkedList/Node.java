package com.dataStructures.lists.doublyLinkedList;

public class Node {
	
	int value = 0;
	Node next = null;
	Node previous = null;
	
	public Node(int value) {
		this.value = value;
	}
	
	public String toString() {
		return "Value: " + value;
	}

}
