package com.dsaa.queue;

import java.util.LinkedList;


public class PriorityQueue {
	
	//First-In-First-Out
	private LinkedList<Integer> listOfNodes;
	
	public PriorityQueue() {
		listOfNodes  = new LinkedList<Integer>();
		
	}
	
	public void enqueue(Integer node) {
		if(listOfNodes.size() == 0) {
			listOfNodes.addLast(node);	
		}
		else {
			//Integer nodeIter = listOfNodes.getFirst();
			for(int i = 0; i < listOfNodes.size(); i++) {
			    if(node >= listOfNodes.get(i)) {
			    	
			        listOfNodes.add(i, node);	
			        break;
			    }
			}
		}
		

	}

	public Integer peek() {
		if(!listOfNodes.isEmpty()) {
		    return listOfNodes.getFirst();
		}
		else {
			return null;
		}
	}
	
	public Integer dequeue() {
		return listOfNodes.removeFirst();
	}
	
	public void clear() {
		listOfNodes.clear();
	}
	
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.enqueue(new Integer(1));
		pq.enqueue(new Integer(3));
		pq.enqueue(new Integer(5));
		pq.enqueue(new Integer(7));
		pq.enqueue(new Integer(9));
		pq.enqueue(new Integer(4));
		
		System.out.println("---");
		
		for(int i = 0; i < pq.listOfNodes.size(); i++) {
			System.out.println(pq.listOfNodes.get(i));
		}
		System.out.println("---");
		System.out.println(pq.dequeue());
		System.out.println("---");
		for(int i = 0; i < pq.listOfNodes.size(); i++) {
			System.out.println(pq.listOfNodes.get(i));
		}
		
		pq.enqueue(new Integer(9));
		System.out.println("---");
		for(int i = 0; i < pq.listOfNodes.size(); i++) {
			System.out.println(pq.listOfNodes.get(i));
		}
	}
	
}

