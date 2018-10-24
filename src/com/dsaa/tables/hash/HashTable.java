package com.dsaa.tables.hash;

import java.util.LinkedList;

public class HashTable {
	
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
			size *= 2;
			listOfNodes = new HashTableArray[size];
			fillArray();
			for(int i = 0; i < oldListOfNodes.length ; i++) {
				HashTableArrayNode[] tablesNodes = oldListOfNodes[i].listOfAllNodes();
				for(int p = 0; p < tablesNodes.length; p++) {
					this.addData(tablesNodes[p]);
				}	
			}
		}
		listOfNodes[node.hash(size)].add(node);
		count++;
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
	  HashTableArrayNode node1 = new HashTableArrayNode("Abe");
	  HashTableArrayNode node2 = new HashTableArrayNode("Aslik");
	  HashTableArrayNode node3 = new HashTableArrayNode("Shryskull");
	  HashTableArrayNode node4 = new HashTableArrayNode("Shrink");
	  
	  newTable.addData(node1);
	  System.out.println(newTable.findData(node1));
	  System.out.println(newTable.findData(node2));
	  newTable.addData(node2);
	  System.out.println(newTable.findData(node2));
	  newTable.addData(new HashTableArrayNode("Dripik"));
	  newTable.addData(new HashTableArrayNode("Molluck"));
	  newTable.addData(new HashTableArrayNode("Alf"));
	  newTable.addData(new HashTableArrayNode("Munch"));
	  
	  System.out.println(newTable.findData(node1));
	  System.out.println(newTable.findData(node3));
	  newTable.addData(node3);
	  System.out.println(newTable.findData(node3));
	  
	  newTable.addData(new HashTableArrayNode("Big face"));
	  newTable.addData(new HashTableArrayNode("Brewmaster"));
	  newTable.addData(new HashTableArrayNode("Phleg"));
	  newTable.addData(new HashTableArrayNode("Almighty Raisin"));
	  newTable.addData(new HashTableArrayNode("Lulu"));
	  newTable.addData(new HashTableArrayNode("Humphrey"));
	  newTable.addData(new HashTableArrayNode("Crig the Slig"));
	  newTable.addData(new HashTableArrayNode("Skillya"));
	  newTable.addData(new HashTableArrayNode("Lady Margaret"));
	  newTable.addData(new HashTableArrayNode("The Stranger"));
	  newTable.addData(new HashTableArrayNode("Fangus Klot"));
	  
	  System.out.println(newTable.findData(node1));
	  System.out.println(newTable.findData(node4));
	  newTable.addData(node4);
	  System.out.println(newTable.findData(node4));
	  
	  System.out.println("***");
	}
	
	public void fillArray() {
	  for(int i = 0; i <listOfNodes.length; i++)
		  listOfNodes[i] = new HashTableArray();
	}
}
