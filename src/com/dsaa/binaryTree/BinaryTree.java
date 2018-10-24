package com.dsaa.binaryTree;

public class BinaryTree {
	
	
	BinaryTreeNode rootNode;
	
	
	//Finding data with pre-order traversal
	public BinaryTreeNode findNodePreOrder(BinaryTreeNode valueToCompare, BinaryTreeNode valueToFind) {
		
		BinaryTreeNode foundValue = null;
		
        if(valueToCompare != valueToFind) {
        	System.out.println(valueToCompare + " is not " + valueToFind);
        	if(valueToCompare.left != null) {
        		findNodePreOrder(valueToCompare.left, valueToFind);
        	}
        	if(valueToCompare.right != null) {
        		findNodePreOrder(valueToCompare.right, valueToFind);
        	}
        }
        else {
        	System.out.println(valueToCompare + " Found!");
        	foundValue = valueToCompare;
        }		
        
        return foundValue;
				 
	}
	
	//Finding data with in-order traversal
	public BinaryTreeNode findNodeInOrder(BinaryTreeNode valueToCompare, BinaryTreeNode valueToFind) {
		
		BinaryTreeNode foundValue = null;
    	if(valueToCompare.left != null) {
		    findNodeInOrder(valueToCompare.left, valueToFind);
    	}
		
        if(valueToCompare.value != valueToFind.value) {
        	System.out.println(valueToCompare + " is not " + valueToFind);
        	if(valueToCompare.right != null) {
        	    findNodeInOrder(valueToCompare.right, valueToFind);
        	}
        }
        else {
        	foundValue = valueToCompare;
        	System.out.println(valueToCompare + " was finally found!");
        }		
        
        return foundValue;
				 
	}
	
	//Finding data with post-order traversal
	public BinaryTreeNode findNodePostOrder(BinaryTreeNode valueToCompare, BinaryTreeNode valueToFind) {
		
		BinaryTreeNode foundValue = null;
    	if(valueToCompare.left != null) {
		    findNodePostOrder(valueToCompare.left, valueToFind);
    	}
    	if(valueToCompare.right != null) {
    	    findNodePostOrder(valueToCompare.right, valueToFind);
    	}
    	
        if(valueToCompare.value == valueToFind.value){
        	System.out.println(valueToCompare + " is found!");
        	foundValue = valueToCompare;
        }		
        else {
        	System.out.println(valueToCompare + " is not " + valueToFind);
        }
        
        return foundValue;
				 
	}
	
	public BinaryTreeNode findNode(BinaryTreeNode valueToFind) {
		return findNodePostOrder(rootNode, valueToFind);	
		
	}
	
	public void detachParentFromNode(BinaryTreeNode valueToDetach) {
		BinaryTreeNode parent = valueToDetach.parent;
		
		if(parent.left == valueToDetach) {
			parent.left = null;
		}
		else {	
			parent.right = null;
		}
	}
		
	//Removing data
	public BinaryTreeNode removeNode(BinaryTreeNode currentValue, BinaryTreeNode valueToFind) {
		
		BinaryTreeNode removedNode = null;
		
	    if(currentValue.value != valueToFind.value) {
	    	removeNode(valueToFind.left, valueToFind);
	    	removeNode(valueToFind.right, valueToFind);    	
	    }
	    else {
	    	
	    	removedNode = currentValue;	
	    	//If leaf node it's simple. If it's not there are three scenarios to consider
	        if(currentValue.left == null && currentValue.right == null) {
	        	this.detachParentFromNode(removedNode);
	        }
	        else if(currentValue.left != null && currentValue.right == null) {
	        	if(currentValue.determineChildSide() == BinaryTreeNode.NodeSide.LEFT) {
	        		currentValue.parent.left = currentValue.left;	
	        	}
	        	else {
	        		currentValue.parent.right = currentValue.left;
	        	}   	
	        }
	        else if(currentValue.left !=  null && currentValue.right != null) {
	        	if(currentValue.right.left == null) {
	        		BinaryTreeNode newLeft = currentValue.left;
	        		BinaryTreeNode movedNode = currentValue.right;
	        		movedNode.left = newLeft;
	        		if(currentValue.determineChildSide() == BinaryTreeNode.NodeSide.LEFT) {
	        			currentValue.parent.left = movedNode;	
	        		}
	        		else {
	        			currentValue.parent.right = movedNode;	
	        		}
	        		
	        	}
	        	else {
	        		BinaryTreeNode newLeft = currentValue.left;
	        		
	        		//test before uploading
	        		/*while(newLeft.left != null) {
	        			newLeft = newLeft.left;	
	        		}*/
	        		BinaryTreeNode newRight = currentValue.right;
	        		BinaryTreeNode movedNode = currentValue.right.left;
	        		movedNode.right = newRight;
	        		movedNode.left = newLeft;
	        		if(currentValue.determineChildSide() == BinaryTreeNode.NodeSide.LEFT) {
	        			currentValue.parent.left = movedNode;	
	        		}
	        		else {
	        			currentValue.parent.right = movedNode;	
	        		}
	        	}

	        }
	    }
	    
	    return removedNode;
	}
	
	
	public void addNode(BinaryTreeNode currentNode, BinaryTreeNode newNode) {
		if(rootNode == null) {
			rootNode = newNode;
			addNode(rootNode, newNode);
		}
		else if(currentNode.value > newNode.value) {
			if(currentNode.left == null) {
				currentNode.left = newNode;
				newNode.parent = currentNode;
				System.out.println("Assigned " + newNode + " under " + currentNode + " as it's left node");
			}
			else {
				addNode(currentNode.left, newNode);  	
			}
		}
		else if(currentNode.value <= newNode.value) {
			if(currentNode.right == null) {
				currentNode.right = newNode;
				newNode.parent = currentNode;
				System.out.println("Assigned " + newNode + " under " + currentNode + " as it's right node");
			}
			else {
				addNode(currentNode.right, newNode);  	
			}
		}		
	}
	
	public void addNode(BinaryTreeNode newNode) {
		if(rootNode == null) {
			rootNode = newNode;
		}
		else {
            addNode(rootNode, newNode);
		}	
		
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		//Stack intead of recursion when traversing, because recursion could cause stack
		//overflow errors in production
		bt.addNode(new BinaryTreeNode(4));
		bt.addNode(new BinaryTreeNode(2));
		bt.addNode(new BinaryTreeNode(1));
		bt.addNode(new BinaryTreeNode(6));
		bt.addNode(new BinaryTreeNode(7));
		bt.addNode(new BinaryTreeNode(3));
		bt.addNode(new BinaryTreeNode(5));
		
		bt.findNode(new BinaryTreeNode(5));
		
		
	/*	bt.addNode(new BinaryTreeNode(1));
		bt.addNode(new BinaryTreeNode(2));
		bt.addNode(new BinaryTreeNode(3));
		bt.addNode(new BinaryTreeNode(4));
		bt.addNode(new BinaryTreeNode(5));
		bt.addNode(new BinaryTreeNode(6));
		bt.addNode(new BinaryTreeNode(7));
		bt.addNode(new BinaryTreeNode(8));*/
		
	}
	
	

}
