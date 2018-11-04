package com.dsaa.sorting;

import java.util.Arrays;

public class QuickSort {

	int[] valuesToSort;
	int timesTakenToSort = 0;
	
	public QuickSort(int size) {
		valuesToSort = new int[size];
	}
	
	public void sort() {
		for(int i = valuesToSort.length/2, t = valuesToSort.length/2; t != 0 && i != valuesToSort.length - 1;) {
			if(i < valuesToSort.length - 1) {
				i++;
				this.rearrange(i);
			}
			if(t > 0) {
				t--;
				this.rearrange(t);
			}
		}
		
	}
	
	public void rearrange(int indexToArrangeFrom) {
		
		int[] lowerValues = new int[valuesToSort.length];
		int[] equalValues = new int[valuesToSort.length];
		int[] higherValues = new int[valuesToSort.length];
		
		int lowerValueIndex = 0;
		int equalValueIndex = 0;
		int higherValueIndex = 0;
			
		for(int i = 0; i < valuesToSort.length; i++) {
			if(valuesToSort[i] < valuesToSort[indexToArrangeFrom]) {
				lowerValues[lowerValueIndex] = valuesToSort[i];
				lowerValueIndex++;				
			}
			else if(valuesToSort[i] == valuesToSort[indexToArrangeFrom]) {
				equalValues[equalValueIndex] = valuesToSort[i];
				equalValueIndex++;
			}
			else {
				higherValues[higherValueIndex] = valuesToSort[i];
				higherValueIndex++;
			}
		}
		
		int valuesIndex = 0;
		
		for(int i = 0 ; i < lowerValueIndex ; i++) {
			valuesToSort[valuesIndex] = lowerValues[i];
			valuesIndex++;
		}
		
		for(int i = 0 ; i < equalValueIndex ; i++) {
			valuesToSort[valuesIndex] = equalValues[i];
			valuesIndex++;
		}
		
		for(int i = 0 ; i < higherValueIndex ; i++) {
			valuesToSort[valuesIndex] = higherValues[i];
			valuesIndex++;
		}		
	}
	
	public static void main(String[] args) {
		QuickSort sq = new QuickSort(args.length);
		
		for(int i = 0 ; i < args.length; i++) {
			sq.valuesToSort[i] = Integer.valueOf(args[i]);
		}		
		sq.sort();
		for(int i = 0 ; i < sq.valuesToSort.length; i++) {
			System.out.print(sq.valuesToSort[i]+",");
		}
		System.out.print("***");
	}
	
	public boolean isInOrder() {
		boolean inOrder = true;
		
		for(int i = 1; i < valuesToSort.length; i++) {
			if(valuesToSort[i] > valuesToSort[i-1]) {
				inOrder = false;
			}
		}
		
		return inOrder;
	}
}
