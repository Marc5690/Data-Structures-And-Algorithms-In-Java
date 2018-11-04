package com.dsaa.set;

import java.util.ArrayList;

public class Set {
	
	private ArrayList<String> listOfStrings;
	
	public Set() {
		listOfStrings = new ArrayList<String>();
	}
	
	public Set(ArrayList<String> initialSet) {
		listOfStrings = new ArrayList<String>(initialSet);
	}
	
	public Set union(ArrayList<String> comparisonSet){
		Set combinedSet = new Set(listOfStrings);
		
		for(int i = 0; i < comparisonSet.size(); i++) {
			combinedSet.add(comparisonSet.get(i));
		}
		
		return combinedSet;
	}
	
	public Set intersection(ArrayList<String> comparisonSet){
		Set combinedSet = new Set();
		
		for (int i = 0; i < listOfStrings.size();i++) {
		    if(comparisonSet.contains(listOfStrings.get(i))) {
		    	combinedSet.add(listOfStrings.get(i));
		    }
		}
		
		return combinedSet;
	}
	
	//The difference of the two arrays, for the first list
	public Set setDifference(ArrayList<String> comparisonSet){
		Set firstDifferencesSet = new Set();
		
		for (int i = 0; i < listOfStrings.size();i++) {
		    if(!comparisonSet.contains(listOfStrings.get(i))) {
		    	firstDifferencesSet.add(listOfStrings.get(i));
		    }
		}
		
		return firstDifferencesSet;
	}
	
	public Set symmetricDifference(ArrayList<String> comparisonSet){
		Set allDifferencesSet = new Set();
		
		for (int i = 0; i < listOfStrings.size();i++) {
		    if(!comparisonSet.contains(listOfStrings.get(i))) {
		    	allDifferencesSet.add(listOfStrings.get(i));
		    }
		}
		
		for (int i = 0; i < comparisonSet.size();i++) {
		    if(!listOfStrings.contains(comparisonSet.get(i))) {
		    	allDifferencesSet.add(comparisonSet.get(i));
		    }
		}
		
		return allDifferencesSet;
	}
	
	public boolean add(String newString) {
		if(listOfStrings.contains(newString)) {
			return false;
		}
		else {
			listOfStrings.add(newString);
			
			return true;
		}
	}

	public boolean remove(String newString) {
		if(listOfStrings.contains(newString)) {
			listOfStrings.remove(newString);
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public void printContents() {
		for(int i = 0; i < listOfStrings.size(); i++) {
			System.out.println(listOfStrings.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> setOne = new ArrayList<String>();
		setOne.add("One");
		setOne.add("Two");
		setOne.add("Three");
		setOne.add("Four");
		setOne.add("Five");
		setOne.add("Six");
		
		ArrayList<String> setTwo = new ArrayList<String>();
		setTwo.add("Four");
		setTwo.add("Five");
		setTwo.add("Six");
		setTwo.add("Seven");
		setTwo.add("Eight");
		setTwo.add("Nine");
		
		Set set = new Set(setOne);
		System.out.println("*****");
		set.union(setTwo).printContents();
		System.out.println("*****");
		set.intersection(setTwo).printContents();
		System.out.println("*****");
		set.symmetricDifference(setTwo).printContents();
		System.out.println("*****");
		set.setDifference(setTwo).printContents();
		System.out.println("*****");
		
	}
	
}
