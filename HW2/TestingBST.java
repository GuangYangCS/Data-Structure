/******************************************
Write a program to do the following:
1. create a Binary Search Tree with at least 15 numbers entered in a random order.
DO NOT ENTER NUMBERS IN ASCENDING OR DESCENDING ORDER.
2. write the function to delete a number.
your function should print not found if the number to be deleted is not in the tree
3. Run the program twice.
a) the number to be deleted is in the tree.  Delete the number and print the
before and after tree
b) the number is not in the tree.  Print not in the tree.
Submit code and screen shot
*******************************************/
package Homework2;

public class TestingBST {
	
	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree();
		BST.addRoot(29);
		BST.addRoot(10);
		BST.addRoot(5);
		BST.addRoot(13);
		BST.addRoot(8);
		BST.addRoot(40);
		BST.addRoot(21);
		BST.addRoot(30);
		BST.addRoot(1);
		BST.addRoot(28);
		BST.addRoot(33);
		BST.addRoot(17);
		BST.addRoot(55);
		BST.addRoot(48);
		BST.addRoot(11);
		BST.addRoot(25);
	

		System.out.println("Case1: The number to be deleted is in the tree.");
		System.out.println("Before delecting, the tree is : ");
		System.out.println(BST.inOrderTraversal(BST.root));
	
		BST.delectNode(10);
		System.out.println("After delecting, the tree is : " );
		System.out.println(BST.inOrderTraversal(BST.root));
		
		System.out.println("\nCase2: The number to be deleted is not in the tree.");
		BST.delectNode(27);
	
	
		
		
		
	
	}

	
	
	
	
	
}

