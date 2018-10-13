package com.dsaa.binaryTree;

public class BinaryTreeNode implements Comparable{
	
	Integer value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	
	public static enum NodeSide {
	    LEFT,
	    RIGHT
	}
	
	public NodeSide determineChildSide() {
		if(this.parent.left == this) {
			return NodeSide.LEFT;
		}
		else {
			return NodeSide.RIGHT;
		}
	}
	
	public BinaryTreeNode(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public BinaryTreeNode getLeft() {
		return left;
	}
	
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	
	public BinaryTreeNode getRight() {
		return right;
	}
	
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public BinaryTreeNode getParent() {
		return parent;
	}
	
	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}

	@Override
	public int compareTo(Object o) {
		BinaryTreeNode comparedUpon = (BinaryTreeNode) o;
		int gtoet = 0;
		if(comparedUpon.value > this.value) {
			gtoet = 1;	
		}
		else if(comparedUpon.value < this.value) {
			gtoet = -1;		
		}
		return gtoet;
	}
	
	public String toString() {
	    return this.value.toString();
	}

}
