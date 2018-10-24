package com.dsaa.queue;

import javax.print.attribute.standard.PrinterLocation;

public class Queue {

	//Head removed first, tail last.

	//Due to type erasure in Java, we cannot make a generic array
	Object[] queueOfNodes = new Object[1];
	int queueOfNodesHeadIndex = 0;
	int queueOfNodesTailIndex = 0;
	int size = 0;

	public Queue() {

	}

	public Object peek() {
		return queueOfNodes[queueOfNodesHeadIndex];
	}

	public boolean isEmptyArray() {
		boolean isEmptyArray = true;
		for(int i = 0; i < queueOfNodes.length; i++) {
			if(queueOfNodes[i] != null) {
				isEmptyArray = false;
			}
		}

		return isEmptyArray;
	}

	public boolean isFullArray() {
		boolean isFullArray = true;
		for(int i = 0; i < queueOfNodes.length; i++) {
			if(queueOfNodes[i] == null) {
				isFullArray = false;
			}
		}

		return isFullArray;
	}

	public void enQueue(Object node) {
		if(isEmptyArray()) {
			queueOfNodes[0] = node;
			size++;
		}
		else {
			size++;
			if(size >= queueOfNodes.length && this.isFullArray()) {
				copyArrayAndResize();
			}
			if(queueOfNodesTailIndex == queueOfNodes.length - 1) {
				queueOfNodesTailIndex = 0;
			}
			else {
				queueOfNodesTailIndex++;
			}

			queueOfNodes[queueOfNodesTailIndex] = node;

		}
	}

	public void copyArrayAndResize() {
		Object[] oldCopy = queueOfNodes;
		int sizeNew = size*2;
		Object[] newArray = new Object[sizeNew];

		int newArrayIndex = 0;
		int newTailIndex = 0;

		for(int i = queueOfNodesHeadIndex; i < queueOfNodesTailIndex;i++, newArrayIndex++) {
			newArray[newArrayIndex] = oldCopy[i];	
		}

		for(int i = queueOfNodesTailIndex; i < queueOfNodes.length;i++, newArrayIndex++) {
			newArray[newArrayIndex] = oldCopy[i];
			newTailIndex = newArrayIndex;
		}

		queueOfNodesHeadIndex = 0;
		queueOfNodesTailIndex = newTailIndex;

		queueOfNodes = newArray;

	}

	public void deQueue() {
		if(size <= 1) {
			if(size == 1) {
				queueOfNodes[queueOfNodesHeadIndex] = null;
				size--;
			}
			
			queueOfNodesHeadIndex = 0;
			queueOfNodesTailIndex = 0;

		}
		else {
			queueOfNodes[queueOfNodesHeadIndex] = null;

			if(queueOfNodesHeadIndex == queueOfNodes.length -1) {
				queueOfNodesHeadIndex = 0;
			}
			else {
				queueOfNodesHeadIndex++;	
			}


			size--;
		}
	}

	public static void main(String[] args) {
		Queue testQueue = new Queue();

		testQueue.enQueue(new Integer(1));
		testQueue.enQueue(new Integer(2));
		testQueue.enQueue(new Integer(3));
		testQueue.enQueue(new Integer(4));
		testQueue.enQueue(new Integer(5));

		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();


		testQueue.enQueue(new Integer(6));
		testQueue.enQueue(new Integer(7)); 
		testQueue.enQueue(new Integer(8));
		testQueue.enQueue(new Integer(9));

		testQueue.deQueue();

		testQueue.enQueue(new Integer(10));
		testQueue.enQueue(new Integer(11));
		testQueue.enQueue(new Integer(12));
		testQueue.enQueue(new Integer(13));
		testQueue.enQueue(new Integer(14));

		testQueue.deQueue();

		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();

		testQueue.enQueue(new Integer(15));
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();

		testQueue.enQueue(new Integer(16));
		testQueue.enQueue(new Integer(17));
		testQueue.enQueue(new Integer(18));
		testQueue.enQueue(new Integer(19));
		testQueue.enQueue(new Integer(20));
		testQueue.enQueue(new Integer(21));
		testQueue.enQueue(new Integer(22));

		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.deQueue();

		testQueue.enQueue(new Integer(23));
		testQueue.deQueue();
		testQueue.enQueue(new Integer(24));
		testQueue.enQueue(new Integer(25));
		testQueue.deQueue();
		testQueue.deQueue();
		testQueue.enQueue(new Integer(26));
		testQueue.deQueue();
		testQueue.deQueue();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < testQueue.queueOfNodes.length ; i++) {
			sb.append(testQueue.queueOfNodes[i] + ", ");
		}

		System.out.println("End: ");
		System.out.println(sb);
		System.out.println("Tail: " + testQueue.queueOfNodesTailIndex);
		System.out.println("Head: " + testQueue.queueOfNodesHeadIndex);
		System.out.println("Size: " + testQueue.size);



	}

}
