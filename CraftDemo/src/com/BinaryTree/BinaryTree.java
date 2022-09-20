//	Given a binary tree with unique integer values. Return the vector of roots of subtrees formed after
//	removing the given node.
//	Node {
//		int id;
//		Node left;
//		Node right;
//	};
//	Vector<Integer> removeNode(Node root, int nodeToBeRemoved)


package com.BinaryTree;

import java.util.Vector;

public class BinaryTree {
	
	static class Node {
		int id;
		Node left;
		Node right;
		
		Node(int id) {
			this.id = id;
			this.left = null;
			this.right = null;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.right.right.left = new Node(7);

		Vector<Integer> remainingRoots = removeNode(root, 1);
		System.out.println(remainingRoots);
	}

	private static Vector<Integer> removeNode(Node root, int nodeToBeRemoved) {
		// TODO Auto-generated method stub
		
		Vector<Integer> remainingRoots = new Vector<Integer>();
		
		if(getSubTreeRoot(root, nodeToBeRemoved, remainingRoots) != null) {
			remainingRoots.add(root.id);
		}
		
		return remainingRoots;
	}

	private static Node getSubTreeRoot(Node root, int nodeToBeRemoved, Vector<Integer> remainingRoots) {
		// TODO Auto-generated method stub
		
		if(root == null) {
			return null;
		}
		
		root.left = getSubTreeRoot(root.left, nodeToBeRemoved, remainingRoots);
		root.right = getSubTreeRoot(root.right, nodeToBeRemoved, remainingRoots);
		
		if(root.id == nodeToBeRemoved){
            if(root.left != null) {
            	remainingRoots.add(root.left.id);
            }
            
            if(root.right != null) {
            	remainingRoots.add(root.right.id);
            }
            
            return null;
        }
		
		return root;
	}
}
