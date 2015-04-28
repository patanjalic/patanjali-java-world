import java.util.LinkedList;

import org.junit.Test;


class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data){
		this.data = data;
	}
}

class BinaryTree {
	TreeNode root;
	BinaryTree(TreeNode root){
		this.root = root;
	}
	void inOrder(TreeNode root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(" "+root.data);
		inOrder(root.right);
	}
	TreeNode removeHalfNodesSimple(TreeNode root){
		if(root == null)
			return null;
		root.left = removeHalfNodesSimple(root.left);
		root.right = removeHalfNodesSimple(root.right);
		if(root.left == null && root.right == null)
			return root;
		if(root.left == null)
			return root.right;
		if(root.right == null)
			return root.left;
		return root;
	}
	TreeNode removeHalfNodes(TreeNode root){
		if(root == null)
			return null;
		while(checkRootRemoval(root)){
			if(root.right == null)
				root = root.left;
			else
				root = root.right;
		}
		while(checkChildForDeletion(root.left)){
			if(root.left.right == null)
				root.left = root.left.left;
			else
				root.left = root.left.right;
		}
		while(checkChildForDeletion(root.right)){
			if(root.right.right == null)
				root.right = root.right.left;
			else
				root.right = root.right.right;
		}
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		return root;
	}
	private boolean checkChildForDeletion(TreeNode child) {
		return checkRootRemoval(child);
	}
	private boolean checkRootRemoval(TreeNode root) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null)
			return false;
		if(root.left == null || root.right == null){
			if(root.right == null)
				root = root.left;
			else
				root = root.right;
			return true;
		}
		return false;
	}
	public int height() {
		return heightHelper(this.root);
	}
	private int heightHelper(TreeNode r) {
		if(r == null)
			return 0;
		return 1+Math.max(heightHelper(r.left), heightHelper(r.right));
	}
	public void printByLevel(int level) {
		printByLevelHelper(root,level);
	}
	private void printByLevelHelper(TreeNode r, int level) {
		if(r == null)
			return;
		if(level == 0)
			System.out.print(" "+r.data);
		else{
			if((level & 1) == 1){
				printByLevelHelper(r.right,level-1);
				printByLevelHelper(r.left,level-1);
			}
			else{
				printByLevelHelper(r.left,level-1);
				printByLevelHelper(r.right,level-1);
			}
		}
	}
	public void printByLevelIterative() {
		printByLevelIterativeHelper(this.root);
	}
	private void printByLevelIterativeHelper(TreeNode r) {
		if(r == null)
			return;
		LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
		l1.add(r);
		int level = 1;
		while(!l1.isEmpty() || !l2.isEmpty()){
			while(!l1.isEmpty()){
				TreeNode temp = l1.poll();
				if(level == 2)
					System.out.print(" "+temp.data);
				if(temp.left != null)
					l2.add(temp.left);
				if(temp.right != null)
					l2.add(temp.right);
			}
			++level;
			System.out.println();
			while(!l2.isEmpty()){
				TreeNode temp = l2.poll();
				if(level == 2)
					System.out.print(" "+temp.data);
				if(temp.left != null)
					l1.add(temp.left);
				if(temp.right != null)
					l1.add(temp.right);
			}
			System.out.println();
			++level;
		}
	}
	private void printZigzagHelper(TreeNode r) {
		if(r == null)
			return;
		LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
		l1.add(r);
		while(!l1.isEmpty() || !l2.isEmpty()){
			while(!l1.isEmpty()){
				TreeNode temp = l1.pollLast();
				System.out.print(" "+temp.data);
				if(temp.left != null)
					l2.add(temp.left);
				if(temp.right != null)
					l2.add(temp.right);
			}
			System.out.println();
			while(!l2.isEmpty()){
				TreeNode temp = l2.pollLast();
				System.out.print(" "+temp.data);
				if(temp.left != null)
					l1.add(temp.left);
				if(temp.right != null)
					l1.add(temp.right);
			}
			System.out.println();
		}
	}
	public void printZigzag() {
		printZigzagHelper(this.root);
	}
	public int sumLeafNodes() {
		return sumLeafNodesHelper(this.root);
	}
	private int sumLeafNodesHelper(TreeNode r) {
		if(r == null)
			return 0;
		if(r.left == null && r.right == null)
			return r.data;
		return sumLeafNodesHelper(r.left) + sumLeafNodesHelper(r.right);
	}
}

public class BinaryTreeTest {
	@Test
	public void main_test() {
		TreeNode root = new TreeNode(2);
		BinaryTree tree = new BinaryTree(root);
		root.left = new TreeNode(7);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(11);
		tree.inOrder(root);
		//tree.removeHalfNodes(root);
		//tree.removeHalfNodesSimple(root);
		//tree.inOrder(root);
		System.out.println();
		int treeHeight = tree.height();
		System.out.println(treeHeight);
		for(int i = 0; i < treeHeight; i++){
			tree.printByLevel(i);
			System.out.println();
		}
		tree.printByLevelIterative();
		tree.printZigzag();
		System.out.println("sum of leaf nodes is "+tree.sumLeafNodes());
	}
}
