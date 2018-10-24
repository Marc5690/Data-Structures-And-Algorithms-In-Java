package com.dsaa.tables.hash;

public class HashTableArrayNode{
	
	private String value;

	public HashTableArrayNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	//Don't actually create your own hashing algorithm if you can avoid it!
	public int hash(int boundary) {
		int valueHash = 0;
		for(char c : value.toCharArray()) {
		    valueHash += c;
		}
		return (boundary - 1) % valueHash;
		
	}
	

}
