package com.dsaa.AVLTree;

public class AVLNode implements Comparable{

	int value;
	AVLNode left;
	AVLNode right;
	AVLNode parent;
	AVLTree tree;
	
	public AVLNode(int value, AVLNode parent, AVLTree tree) {
		this.value = value;
		this.tree = tree;
		this.parent = parent;
	}
	
	private TreeState state() {
		
        System.out.println("Left height: " + leftHeight() + " right height: " + rightHeight());
        
        if (leftHeight() - rightHeight() > 1) {
                return TreeState.LeftHeavy;
        }
        if (rightHeight() - leftHeight() > 1) {
                return TreeState.RightHeavy;
        }
        
        return TreeState.Balanced;
        
	}
	
	private int balanceFactor() {
		return 0;
	}
	
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
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public AVLNode getLeft() {
		return left;
	}
	
	public void setLeft(AVLNode left) {
		this.left = left;
	}
	
	public AVLNode getRight() {
		return right;
	}
	
	public void setRight(AVLNode right) {
		this.right = right;
	}
	
	public AVLNode getParent() {
		return parent;
	}
	
	public void setParent(AVLNode parent) {
		this.parent = parent;
	}
	
	public void Balance() {
		
        if (this.state() == TreeState.RightHeavy)
        {
        	System.out.println("Balancing right heavy");
            if (right != null && right.balanceFactor() < 0)
            {
                leftRightRotation();
            }
            else
            {
                leftRotation();
            }
        }
        else if (this.state() == TreeState.LeftHeavy)
        {
        	System.out.println("Balancing left heavy");
            if (left != null && left.balanceFactor() > 0)
            {
                rightLeftRotation();
            }
            else
            {
                rightRotation();
            }
        }
	}
	
	public void leftRotation() {
        AVLNode newRoot = right;
        replaceRoot(newRoot);
        right = newRoot.left;
        newRoot.left = this;
		
	}
	
	public void rightRotation() {
        AVLNode newRoot = left;
        replaceRoot(newRoot);
        left = newRoot.right;
        newRoot.right = this;
        
	}
	
	public void leftRightRotation() {
        right.rightRotation();
        leftRotation();
		
	}
	
	public void rightLeftRotation() {
        left.leftRotation();
        rightRotation();
        
	}
	
	private int MaxChildHeight(AVLNode node) {
        if (node != null){
            return 1 + Math.max(MaxChildHeight(node.left), MaxChildHeight(node.right));
        }

        return 0;
        
	}
	

    private void replaceRoot(AVLNode newRoot) {
    	
        if (this.parent != null) {
            if (this.parent.left == this) {
                this.parent.left = newRoot;
            }
            else if (this.parent.right == this) {
                this.parent.right = newRoot;
            }
        }
        else {
            tree.rootNode = newRoot;
        }

        newRoot.parent = this.parent;
        this.parent = newRoot;
        
    }

	@Override
	public int compareTo(Object o) {
		
		AVLNode comparedUpon = (AVLNode) o;
		int gtoet = 0;
		if(comparedUpon.value > this.value) {
			gtoet = 1;	
		}
		else if(comparedUpon.value < this.value) {
			gtoet = -1;		
		}
		return gtoet;
		
	}
	
	private int leftHeight() {
        return MaxChildHeight(left);
        
    }

    private int rightHeight() {
        return MaxChildHeight(right);
        
    }
    
	public String toString() {
	    return String.valueOf(this.value).toString();
	    
	}
	
    public enum TreeState {
        Balanced,
        LeftHeavy,
        RightHeavy
    }
	
}
