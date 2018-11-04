package com.dsaa.sorting;

import java.util.Arrays;

public class MergeSort {

    int[] valuesToSort;
	
	public MergeSort(int size) {
		valuesToSort = new int[size];
	}
	
	//Test odd-numbered capacity arrays	
	public static void main(String[] args) {
		 
		MergeSort mergeSort = new MergeSort(args.length);
		
		for(int i = 0 ; i < args.length; i++) {
			mergeSort.valuesToSort[i] = Integer.valueOf(args[i]);
			System.out.print(mergeSort.valuesToSort[i]+",");
		}
		
		System.out.println("");
		System.out.println("***");
		int[] sortedFinish = mergeSort.recursivelySplit(mergeSort.valuesToSort) ;
			
		System.out.println("Sorted");
		for(int i = 0 ; i < sortedFinish.length; i++) {
			System.out.print(sortedFinish[i]+",");
		}
	}
	
	public int[] recursivelySplit(int[] currentArrayToSplit) {
		
		System.out.println("Splitting" + currentArrayToSplit);
		
		if(currentArrayToSplit.length > 1) {
			int[] leftSplit = Arrays.copyOfRange(currentArrayToSplit, 0, currentArrayToSplit.length/2);
			int[] rightSplit = Arrays.copyOfRange(currentArrayToSplit, currentArrayToSplit.length/2, currentArrayToSplit.length);
			int[] leftSplitResults = recursivelySplit(leftSplit);
			int[] rightSplitResults = recursivelySplit(rightSplit);
			int[] sortedArray = rejoinArrays(leftSplitResults,rightSplitResults);
			Arrays.sort(sortedArray);
			
			return sortedArray;
		}	
		else {
			return currentArrayToSplit;		
		}
	}
	
	public int[] rejoinArrays(int[] leftSplitResults, int[] rightSplitResults) {
		
		System.out.println("Adding " + leftSplitResults.length + " with " + rightSplitResults.length);
		int[] sortedSplitResults = new int[leftSplitResults.length + rightSplitResults.length];
		
		int t = 0;
		for(int i = 0; i <leftSplitResults.length; i++, t++) {
			sortedSplitResults[t] = leftSplitResults[i];
			
		}
		
		for(int i = 0; i <rightSplitResults.length; i++, t++) {
			sortedSplitResults[t] = rightSplitResults[i];
			
		}
		
		System.out.println("Result: "  + sortedSplitResults.length);
		
		return sortedSplitResults;

	}

}
