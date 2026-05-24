package com.dsalgos.practice.binarysearch.tree;

class TreeNode{
	int val;
	TreeNode left, right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class LargesetElementInBinarySearchTree {
	



	public static TreeNode getLargestNumber(TreeNode root) {
		
		if(root == null) {
			return root;
		}else if(root.right == null) {
			return root;
		}else {
			return getLargestNumber(root.right);
		}
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
	     root.left = new TreeNode(3);
	        root.left.left = new TreeNode(1);
	        root.left.right = new TreeNode(6);
	        root.left.right.left = new TreeNode(4);
	        root.left.right.right = new TreeNode(7);
	        root.right = new TreeNode(10);
	        root.right.right = new TreeNode(14);
	        root.right.right.left = new TreeNode(13);
//        tree.root = new Node(2);
//        tree.root.left = new Node(7);
//        tree.root.right = new Node(5);
//        tree.root.left.right = new Node(6);
//        tree.root.left.right.left = new Node(1);
//        tree.root.left.right.right = new Node(11);
//        tree.root.right.right = new Node(9);
//        tree.root.right.right.left = new Node(4);
 
        // Function call
        System.out.println("Maximum element is "
                           + getLargestNumber(root).val);

	}

}
