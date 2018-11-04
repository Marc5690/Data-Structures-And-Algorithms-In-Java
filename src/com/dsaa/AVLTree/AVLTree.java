package com.dsaa.AVLTree;

import java.util.Stack;

public class AVLTree {
	
	AVLNode rootNode;

	// This is an additional example of in order traversal that uses a stack to
	// avoid runtime out-of-memory exceptions
	public void inOrderStackTraversal() {

		if (rootNode != null) {

			Stack<AVLNode> stack = new Stack<AVLNode>();
			AVLNode current = rootNode;
			boolean goLeftNext = true;

			stack.push(current);

			while (stack.size() > 0) {
				if (goLeftNext) {
					while (current.left != null) {
						stack.push(current);
						current = current.left;
					}
				}

				System.out.println(current.value);

				if (current.right != null) {
					current = current.right;
					goLeftNext = true;
				} else {
					current = stack.pop();
					goLeftNext = false;
				}
			}
		}
	}

	//Finding data with in-order traversal
	public AVLNode findNodeInOrder(AVLNode valueToCompare, AVLNode valueToFind) {
		
		AVLNode foundValue = null;
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

	public AVLNode findNode(AVLNode valueToFind) {
		return findNodeInOrder(rootNode, valueToFind);
	}
	

	public void detachParentFromNode(AVLNode valueToDetach) {
		AVLNode parent = valueToDetach.parent;

		if (parent.left == valueToDetach) {
			parent.left = null;
		} else {
			parent.right = null;
		}
	}

	// Removing data
	public boolean removeNode(AVLNode value) {
		
	     AVLNode current;
         current = findNode(value);

         if (current == null){
             return false;
         }

         AVLNode treeToBalance = current.parent;

         if (current.right == null) {
             if (current.parent == null) {
                 rootNode = current.left;
                 if (rootNode != null) {
                	 rootNode.parent = null;
                 }
             }
             else {
                 int result = current.parent.compareTo(current.value);
                 if (result > 0) {
                     current.parent.left = current.left;
                 }
                 else if (result < 0) {
                     current.parent.right = current.left;
                 }
             }
         }
         else if (current.right.left == null) {
             current.right.left = current.left;

             if (current.parent == null) {
            	 rootNode = current.right;
                 if (rootNode != null) {
                	 rootNode.parent = null;
                 }
             }
             else {
                 int result = current.parent.compareTo(current.value);
                 if (result > 0) {
                     current.parent.left = current.right;
                 }
                 else if (result < 0) {
                     current.parent.right = current.right;
                 }
             }
         }

         else {
             AVLNode leftmost = current.right.left;

             while (leftmost.left != null) {
                 leftmost = leftmost.left;
             }

             leftmost.parent.left = leftmost.right;
             leftmost.left = current.left;
             leftmost.right = current.right;

             if (current.parent == null) {
            	 rootNode = leftmost;
                 if (rootNode != null) {
                	 rootNode.parent = null;
                 }
             }
             else {
                 int result = current.parent.compareTo(current.value);
                 if (result > 0) {
                     // if parent value is greater than current value
                     // make leftmost the parent's left child
                     current.parent.left = leftmost;
                 }
                 else if (result < 0) {
                     // if parent value is less than current value
                     // make leftmost the parent's right child
                     current.parent.right = leftmost;
                 }
             }
         }

         if (treeToBalance != null) {
             treeToBalance.Balance();
         }
         else {
             if (rootNode != null) {
            	 rootNode.Balance();
             }
         }

         return true;
         
	}

	public void addNode(AVLNode currentNode, int newNodeValue) {
        if (newNodeValue < currentNode.value) {
        	if (currentNode.left == null) {
            	currentNode.left = new AVLNode(newNodeValue, currentNode, this);
            }
            else {
                this.addNode(currentNode.left, newNodeValue);
            }
        }
        else {
            if (currentNode.right == null) {
            	currentNode.right = new AVLNode(newNodeValue, currentNode, this);
            }
            else {
                this.addNode(currentNode.right, newNodeValue);
            }
        }
		
        currentNode.Balance();
	}
	
	public void addNode(int newNodeValue) {
		if (rootNode == null) {
			AVLNode newNode = new AVLNode(newNodeValue, null, this);
			rootNode = newNode;
		} else {
			addNode(rootNode, newNodeValue);
		}

	}
	

	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();

		avlTree.addNode(4);
		System.out.println("Root: " + avlTree.rootNode);
		avlTree.addNode(2);
		System.out.println("Root: " + avlTree.rootNode);
		avlTree.addNode(10);
		System.out.println("Root: " + avlTree.rootNode);
		avlTree.addNode(11);
		System.out.println("Root: " + avlTree.rootNode);
		avlTree.addNode(12);
		System.out.println("Root: " + avlTree.rootNode);
		avlTree.addNode(13);
		System.out.println("Root: " + avlTree.rootNode);

		avlTree.inOrderStackTraversal();

	}

}
