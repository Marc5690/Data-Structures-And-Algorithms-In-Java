package com.dsaa.sorting;

public class InsertionSort {
	
	int[] valuesToSort;
	
	public InsertionSort(int size) {
		valuesToSort = new int[size];
	}
	
	public static void main(String[] args) {
		 
		InsertionSort insertionSort = new InsertionSort(args.length);
		
		for(int i = 0 ; i < args.length; i++) {
			insertionSort.valuesToSort[i] = Integer.valueOf(args[i]);
			System.out.print(insertionSort.valuesToSort[i]+",");
		}
		
		System.out.println("");
		System.out.println("***");
		insertionSort.sortArray() ;
			
		System.out.println("Sorted");
		for(int i = 0 ; i < insertionSort.valuesToSort.length; i++) {
			System.out.print(insertionSort.valuesToSort[i]+",");
		}
	}
	
	public void sortArray() {
		
		for(int i = 1 ; i < valuesToSort.length; i++) {
			    System.out.println("Iterating: " + i + " - " + valuesToSort[i]);
				int t = i - 1;
				int e = i;
				while(t >= 0 && valuesToSort[t] > valuesToSort[e]) {
					travelBackOne(e);
					t--;
					e--;
				}	
				t = i;
				e = i;
		}		
	}
	
	public void travelBackOne(int currentIndex) {
		int previousIndexValue = valuesToSort[currentIndex -1];
		int currentIndexValue = valuesToSort[currentIndex];
		
		System.out.println(previousIndexValue + " is going backwards, replacing " + currentIndexValue);
		valuesToSort[currentIndex] = previousIndexValue;
		valuesToSort[currentIndex -1] = currentIndexValue;
		
	}

}
