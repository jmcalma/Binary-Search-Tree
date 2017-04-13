package edu.cpp.cs.cs241.Project1;

public class BTNode {
	private int data;
	private BTNode left, right;
	
	public BTNode(){
	}
			
	public BTNode(int initialData, BTNode initialLeft, BTNode initialRight){
		data = initialData;
		left = initialLeft;
		right = initialRight;
	}
	
	public int getData(){
		return data;
	}
	
	public BTNode getLeft(){
		return left;
	}
	
	public BTNode getRight(){
		return right;
	}
	
	public void setData(int newData){
		data = newData;
	}
	
	public void setLeft(BTNode newLeft){
		left = newLeft;
	}
	
	public void setRight(BTNode newRight){
		right = newRight;
	}
	
}
