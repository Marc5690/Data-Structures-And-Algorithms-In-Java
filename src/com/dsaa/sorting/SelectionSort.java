package com.dsaa.sorting;

public class SelectionSort {
	
	int[] valuesToSort;
	
	public SelectionSort(int size) {
		valuesToSort = new int[size];
	}
	
	public static void main(String[] args) {
		 
		SelectionSort selectionSort = new SelectionSort(args.length);
		
		for(int i = 0 ; i < args.length; i++) {
			selectionSort.valuesToSort[i] = Integer.valueOf(args[i]);
			System.out.print(selectionSort.valuesToSort[i]+",");
		}
		
		System.out.println("");
		System.out.println("***");
		selectionSort.sortArray() ;
			
		System.out.println("Sorted");
		for(int i = 0 ; i < selectionSort.valuesToSort.length; i++) {
			System.out.print(selectionSort.valuesToSort[i]+",");
		}
	}
	
	public void sortArray() {
		
		int passesCompleted = 0;
		while(passesCompleted < valuesToSort.length ) {
			int lowestValueIndex= passesCompleted;
			
			for(int i = passesCompleted ; i < valuesToSort.length; i++) {
				if(valuesToSort[i] < valuesToSort[lowestValueIndex]) {
					lowestValueIndex = i;
				}
				
			}	
			
			System.out.println("Pass: " + passesCompleted + "; switched " + valuesToSort[lowestValueIndex] + 
					" with " + valuesToSort[passesCompleted]);
			
			switchIndices(passesCompleted, lowestValueIndex);
			passesCompleted++;
		}
			
	}
	
	public void switchIndices(int lowestValFoundIndex, int indexToBeSwitchedWith) {
		int previousIndexValue = valuesToSort[indexToBeSwitchedWith];
		int currentIndexValue = valuesToSort[lowestValFoundIndex];

		valuesToSort[lowestValFoundIndex] = previousIndexValue;
		valuesToSort[indexToBeSwitchedWith] = currentIndexValue;
		
	}

}
