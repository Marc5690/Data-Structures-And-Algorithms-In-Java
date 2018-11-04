package com.dsaa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		 
		int[] valuesToSort = new int[args.length];
		
		for(int i = 0 ; i < args.length; i++) {
			valuesToSort[i] = Integer.valueOf(args[i]);
			System.out.print(valuesToSort[i]+",");
		}
		
		System.out.println("");
		System.out.println("***");
		
		BubbleSort bubbleSort = new BubbleSort();
		
		while(bubbleSort.sortArrayAndReturnTimesChange(valuesToSort) != 0) continue; 
			
		
		System.out.println("Sorted");
		for(int i = 0 ; i < valuesToSort.length; i++) {
			System.out.print(valuesToSort[i]+",");
		}

	}
	
	public int sortArrayAndReturnTimesChange(int[] valuesToSort) {
		int timesChanged = 0;
		for(int i = 0 ; i < valuesToSort.length; i++) {
			if(i+1 <= valuesToSort.length -1 && valuesToSort[i+1] < valuesToSort[i] ) {
				timesChanged++;
				int left = valuesToSort[i];
				int right = valuesToSort[i+1];
				valuesToSort[i+1] = left;
				valuesToSort[i] = right;
				System.out.println(valuesToSort[i] + " changed places with " + valuesToSort[i+1]);
			}
		}
		System.out.println("Times changed:  " + timesChanged);
		return timesChanged;
		
	}

}
