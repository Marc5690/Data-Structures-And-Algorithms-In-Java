package com.dsaa.tables.hash;

import java.util.LinkedList;

//https://stackoverflow.com/questions/217065/cannot-create-an-array-of-linkedlists-in-java

public class HashTableArray {
	
	LinkedList<HashTableArrayNode> nodeList;
	
	public HashTableArray() {
		nodeList = new LinkedList<HashTableArrayNode>();
	}
	
	public void add(HashTableArrayNode node) {
		nodeList.addFirst(node);
	}

	public boolean findData(HashTableArrayNode node) {
		HashTableArrayNode foundNode;
		HashTableArrayNode next = nodeList.getFirst();
		while(next != null) {
		  if(next.getValue().equals(node.getValue())) {
			  foundNode = next;
		  }
		}
		return next != null ? true : false ;
	}
	
	public boolean removeData(HashTableArrayNode node) {
		HashTableArrayNode foundNode = null;
		HashTableArrayNode next = nodeList.getFirst();
		while(next != null) {
		  if(next.getValue().equals(node.getValue())) {
			  foundNode = next;
		  }
		}
		if(foundNode != null) {
	      nodeList.remove(foundNode);
		  return true;
		}
		
		return false;
		
	}
	
	public HashTableArrayNode[] listOfAllNodes() {
		return (HashTableArrayNode[]) nodeList.toArray();
	}
	
	

}
