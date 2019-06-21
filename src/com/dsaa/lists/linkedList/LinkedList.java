package com.dsaa.lists.linkedList;

import java.util.ArrayList;

public class LinkedList {
	
	Node head;
	Node tail;
	
	int count = 0;
	
	private void assignFirstNode(Node firstNode) {
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
			head = newEndNode;
		}
		
		count++;
	}
	
	public void removeFromFront() {
		if(count>0) {
			head = head.next;
			count--;	
		}
	}
	
	public void removeFromEnd() {
		if(count>0) {
			Node temp = head;
			while(temp.next.next != null) {
			  
				temp = temp.next;
			}
			tail = temp;
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
		LinkedList newLinkedList = new LinkedList();
		
		newLinkedList.addToFront(new Node(1));
		newLinkedList.addToFront(new Node(2));
		newLinkedList.addToFront(new Node(3));
		newLinkedList.addToFront(new Node(4));
		newLinkedList.addToFront(new Node(5));
		
		newLinkedList.printyy(newLinkedList);
		newLinkedList.removeFromEnd();
		newLinkedList.printyy(newLinkedList);
		
		
		newLinkedList.removeFromFront();
		
		System.out.println(newLinkedList.toString());
		
	}
	
	
	public void printyy(LinkedList newLinkedList) {
		Node[] nodeList = newLinkedList.enumerateAsArray();
		StringBuilder allNodes = new StringBuilder();
		for(int i=0; i< nodeList.length ;i++) {
			allNodes.append(nodeList[i] + " ");
			System.out.println(nodeList[i]);
		}
		
	}

}
