package Homework2;
// test 
import java.util.ArrayList;

public class BinarySearchTree{
	
	public Node root;
	
	public Node addRoot(Node root, Integer data){
		if (root == null){
			root = new Node(data);
		}
		
		else if(root.getData() < data){
			root.rightChild = addRoot(root.rightChild, data);
		}
		
		else{
			root.leftChild = addRoot(root.leftChild, data);
		}
		return root;
	}
	
	public void addRoot(Integer data){
		root = addRoot(root, data);
	}
	
	public Node search(Integer data){
		if (root != null){
			return root.search(data);
		}
		return null;
	}
	
	// deleting situations analyzed case by case and print message when search method returns null 
	public void delectNode(Integer data){
		if(search(data) == null){
			System.out.println("The number " + data + " is not in the tree");
		}
		
		Node node = this.root;
		Node parent = this.root;
		boolean hasLeftChild = false;
		
		if(node == null)
			return;
		
		while(node != null && node.getData() != data){
			parent = node;
		 
			if(data < node.getData()){
			 node = node.getLeftChild();
			 hasLeftChild = true; 
		 }
			else {
			node = node.getRightChild();
			hasLeftChild = false;
			}
		 }
		
		if (node == null)
			return;
		
		if (node.getLeftChild() == null && node.getRightChild() ==null)
			if (node == root){
				root = null;
			} else{
				if (hasLeftChild)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);
			}
		
		else if (node.getRightChild() == null){
			if( node == root){
				root = node.getLeftChild();
			}
			
			else if(hasLeftChild){
				parent.setLeftChild(node.getLeftChild());
			}else{
				parent.setRightChild(node.getLeftChild());
			}
		}
		
		else if (node.getLeftChild() == null){
			if( node == root){
				root = node.getRightChild();
			}else if(hasLeftChild){
				parent.setLeftChild(node.getRightChild());
			}else{
				parent.setRightChild(node.getRightChild());
			}
		}
		
		else {
			Node successor = arrangeSuccessor(node);
			if (node == root)
				root = successor;
			else if (hasLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(node.getLeftChild());
		}
		
	}	
	// arrange the successor for the case when the deleting element has both children
	public Node arrangeSuccessor(Node node) {
		Node parentOfSuccessor = node;
		Node successor = node;
		Node current = node.getRightChild();
		
		while (current != null) {
			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeftChild();
		}
		
		if (successor != node.getRightChild()) {
			parentOfSuccessor.setLeftChild(successor.getRightChild());
			successor.setRightChild(node.getRightChild());
		}
		
		return successor;
	}
	ArrayList<Integer> printTree = new ArrayList<Integer>();
	
	// traverse all the elements in the tree and return an ArrayList type which stores all the data values
	public ArrayList<Integer> inOrderTraversal(Node root){
		printTree.clear();
		if (root != null){
			traversal(root);
		}		
		return printTree;	
	}
	
	// traverse every element in the tree
	public void traversal(Node node){
		
		if(node.leftChild != null)
			traversal(node.leftChild);
		
		printTree.add(node.getData());
		
		if(node.rightChild != null)
			traversal(node.rightChild);		
		
	}
}