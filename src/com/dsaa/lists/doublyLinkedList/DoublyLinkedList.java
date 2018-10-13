package com.dsaa.lists.doublyLinkedList;

import java.util.ArrayList;

public class DoublyLinkedList {
	
	Node head;
	Node tail;
	
	int count = 0;
	
	public void assignFirstNode(Node firstNode) {
		head = firstNode;
		tail = firstNode;
	}
	
	public void addToFront(Node newFrontNode) {
		if(head == null && tail == null) {
			assignFirstNode(newFrontNode);
		}
		else {
			Node oldHead = head;
			newFrontNode.next = oldHead;
			oldHead.previous = newFrontNode;
			head = newFrontNode;
		}
		
		count++;
	}
	
	public void addToEnd(Node newEndNode) {
		if(head == null && tail == null) {
			assignFirstNode(newEndNode);
		}
		else {
			Node oldTail = tail;
			oldTail.next = newEndNode;
			newEndNode.previous = oldTail;
			head = newEndNode;
		}
		
		count++;
	}
	
	public void removeFromFront() {
		if(count>0) {
			head = head.next;
			head.previous = null;
			count--;	
		}

	}
	
	public void removeFromEnd() {
		if(count>0) {
			tail.previous.next = null;
			count--;
		}

	}
	
	public Node[] enumerateAsArray(){
		
		Node[] listOfAllNodes = new Node[count];
		int currentNodePosition = 0;
		Node tempCurrentNode = head;
		
		while(tempCurrentNode != null) {
			listOfAllNodes[currentNodePosition] = tempCurrentNode;
			tempCurrentNode = tempCurrentNode.next;
			currentNodePosition++;
		}
		
		return listOfAllNodes;
		
	}
	
	public void printAllList(Node node) {
	
		while(node.next != null) {
			System.out.println(node.value);
		}
	}
	
	public static void main(String args[]) {
		DoublyLinkedList newDoublyLinkedList = new DoublyLinkedList();
		
		newDoublyLinkedList.addToFront(new Node(1));
		newDoublyLinkedList.addToFront(new Node(2));
		newDoublyLinkedList.addToFront(new Node(3));
		newDoublyLinkedList.addToFront(new Node(4));
		newDoublyLinkedList.addToFront(new Node(5));
		
		newDoublyLinkedList.printyy(newDoublyLinkedList);
		newDoublyLinkedList.removeFromEnd();
		newDoublyLinkedList.printyy(newDoublyLinkedList);
		
		
		newDoublyLinkedList.removeFromFront();
		
		System.out.println(newDoublyLinkedList.toString());
		
	}
	
	
	public void printyy(DoublyLinkedList newDoublyLinkedList) {
		Node[] nodeList = newDoublyLinkedList.enumerateAsArray();
		StringBuilder allNodes = new StringBuilder();
		for(int i=0; i< nodeList.length ;i++) {
			allNodes.append(nodeList[i] + " ");
			System.out.println(nodeList[i]);
		}
		
	}

}
