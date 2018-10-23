package com.dsaa.tables.hash;

import java.util.LinkedList;

public class HashTable {
	
	//Todo: fix array growth bug. Committing to save work because library is closing.
	HashTableArray[] listOfNodes;
	double fillFactor = .75;
	int count = 0;
	int size = 2;
		
	public HashTable() {
		listOfNodes = new HashTableArray[size];
	}
	
	public void addData(HashTableArrayNode node) {
		if( count != 0 && ((count / size) > fillFactor) ) {
			HashTableArray[] oldListOfNodes = listOfNodes;
			int newSize = size * 2;
			HashTableArrayNode[] allNodes = new HashTableArrayNode[newSize];
			int allNodesIndex = 0;
			for(int i = 0; i < oldListOfNodes.length ; i++) {
				HashTableArrayNode[] tablesNodes = oldListOfNodes[i].listOfAllNodes();
				for(int p = 0; p < tablesNodes.length; p++) {
					allNodes[allNodesIndex] = tablesNodes[p];
					allNodesIndex++;
				}	
			}
			
			listOfNodes = new HashTableArray[newSize];
		}
		
		listOfNodes[node.hash(size)].add(node);
	}

	public boolean findData(HashTableArrayNode node) {
		
		return listOfNodes[node.hash(size)].findData(node);
	}
	
	public boolean removeData(HashTableArrayNode node) {
		
		return listOfNodes[node.hash(size)].removeData(node);
	}
	
	public static void main(String[] arguments) {
	  HashTable newTable = new HashTable();
	  newTable.fillArray();
	  
	  newTable.addData(new HashTableArrayNode("Marc"));
	  newTable.addData(new HashTableArrayNode("Aslik"));
	  newTable.addData(new HashTableArrayNode("Dripik"));
	  newTable.addData(new HashTableArrayNode("Molluck"));
	}
	
	public void fillArray() {
	  for(int i = 0; i <listOfNodes.length; i++)
		  listOfNodes[i] = new HashTableArray();
	}
}
