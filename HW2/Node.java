package Homework2;

public class Node {
	public Node leftChild;
	private Integer data;
	public Node rightChild;
	public Node parent;
	
	// default constructor
	public Node(){
		leftChild = null;
		data = 0;
		rightChild = null;
		parent = null;
	}
	// constructor which takes data parameter
	public Node(Integer data){
		leftChild = null;
		this.data = data;
		rightChild = null;
		parent = null;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	// search method which helps search an element in the tree 
	public Node search(int data){
		if(this.data == data){
			return this;
		}
		if(this.data < data && rightChild != null){
			return rightChild.search(data);
		}
		if(this.data > data && leftChild != null) {
			return leftChild.search(data);
		}
	
		return null;

	}

}
