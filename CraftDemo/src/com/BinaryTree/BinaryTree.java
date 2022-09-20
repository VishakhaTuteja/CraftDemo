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
		root.right.right.right = new Node(1);

		Vector<Integer> rootsAfterDeletionOfAvailableNode = removeNode(root, 2);
		System.out.println(rootsAfterDeletionOfAvailableNode);

	}

	private static Vector<Integer> removeNode(Node root, int nodeToBeRemoved) {
		// TODO Auto-generated method stub
		
		Vector<Integer> forestRoots = new Vector<Integer>();
		
		if(removeNodeUtil(root, nodeToBeRemoved, forestRoots) != null) {
			forestRoots.add(root.id);
		}
		
		return forestRoots;
		
	}

	private static Node removeNodeUtil(Node root, int nodeToBeRemoved, Vector<Integer> forestRoots) {
		// TODO Auto-generated method stub
		if(root == null) {
			return null;
		}
		
		root.left = removeNodeUtil(root.left, nodeToBeRemoved, forestRoots);
		root.right = removeNodeUtil(root.right, nodeToBeRemoved, forestRoots);
		
		if(root.id == nodeToBeRemoved){
            if(root.left != null) {
            	forestRoots.add(root.left.id);
            }
            
            if(root.right != null) {
            	forestRoots.add(root.right.id);
            }
            
            return null;
        }
		
		return root;
	}
}
