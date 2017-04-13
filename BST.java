package edu.cpp.cs.cs241.Project1;
/*
 * In this class you are able to create a binary search tree.
 * You can insert a node, delete a node, and print the tree
 * in preorder, inorder, and postorder.
 */
public class BST {
	private BTNode root;
	
	//The constructor initializes the root to be null.
	public BST(){
		root = null;
	}
	
	//Passes the desired value and root node to insertNode().
	public void insert(int val){
        root = insertNode(root, val);
    }
	
	/*
	 * Recursively inserts a node with the desired value into the tree.
	 * Returns the root node of the tree.
	 */
    private BTNode insertNode(BTNode current, int val){
        if(current == null){
            current = new BTNode(val, null, null);
        }
        else{
            if(val == current.getData()){
            	System.out.println(val + " is already in the tree.");
            }
            else if(val < current.getData()){
                current.setLeft(insertNode(current.getLeft(), val));
            }
            else{
                current.setRight(insertNode(current.getRight(), val));
            }
        }
        return current;
    }
    
    /*
     * Checks if it is possible to delete the desired node
     * by checking if the tree is empty and if the 
     * node is in the tree. It calls deleteNode()
     * if it is possible to delete the node.
     */
    public void delete(int val){
        if(root == null){
            System.out.println("The tree is empty.");
        }
        else if(inTree(val) == false){
            System.out.println(val +" is not in the tree.");
        }
        else{
            root = deleteNode(root, val);
        }
    }
    
    /*
     * Recursively deletes the desired node. It finds the node
     * then it deletes it.
     * Returns the root node of the tree.
     */
    private BTNode deleteNode(BTNode current, int val){
    		if(val < current.getData()){
    			current.setLeft(deleteNode(current.getLeft(), val));
    		} 
    		else if(val > current.getData()){
    			current.setRight(deleteNode(current.getRight(), val));
    		} 
    		else{
    			if(current.getRight() == null){
    				current = current.getLeft();
    			} 
    			else{
    				BTNode replace = replacementNode(current.getRight());
    				current.setData(replace.getData());
    				current.setRight(deleteNode(current.getRight(), replace.getData()));
    			}
    		}
    		return current;
    }
    
     //Finds the node that will replace the deleted node.
    private BTNode replacementNode(BTNode current){
    	if(current.getLeft() == null){
    		return current;
    	}
    	else{
    		return replacementNode(current.getLeft());
    	}
    }
    
    /* Calls nodeInTree to check if the node is in the tree.
     * Returns true if the node is in the tree or 
     * false if it is not in the tree. 
     */
    private boolean inTree(int val){
        return nodeInTree(root, val);
    }
    
    /*
     * Checks if the node is in the tree.
     * Returns true if the node is in the tree or 
     * false if it is not in the tree.
     */
    private boolean nodeInTree(BTNode current, int val){
        boolean in = false;
        while((current != null) && !in){
            int data = current.getData();
            if(val < data){
            	current = current.getLeft();
            }
            else if(val > data){
            	current = current.getRight();
            }
            else{
                in = true;
                break;
            }
            in = nodeInTree(current, val);
        }
        return in;
    }
    /*
     * Checks if the tree is empty.
     * Returns true is the tree is empty
     * or false is the tree has nodes.
     */
    public boolean isEmpty(){
        if(root == null){
        	return true;
        }
        else{
        	return false;
        }
    }
    
    public void preOrder(){
        preOrder(root);
    }
    
    //Prints the tree in preorder.
    private void preOrder(BTNode current){
		if(current != null){
			System.out.print(current.getData() + " ");
			preOrder(current.getLeft());
			preOrder(current.getRight());
		}
	}
	
    public void inOrder(){
        inOrder(root);
    }
    
    //Prints the tree in inorder.
	private void inOrder(BTNode current){
		if(current != null){
			inOrder(current.getLeft());
			System.out.print(current.getData() + " ");
			inOrder(current.getRight()); 
		}
	}
	
	public void postOrder(){
        postOrder(root);
    }
	
	//Prints the tree in postorder.
	private void postOrder(BTNode current){
		if(current != null){
			postOrder(current.getLeft());
			postOrder(current.getRight()); 
			System.out.print(current.getData() + " ");
		}
	}
}
