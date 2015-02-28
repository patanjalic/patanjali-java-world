public class SortedArrayToBST {
	class Node {
		Node left;
		Node right;
		int data;
	}
	Node sortedArrayToBST(int arr[], int n) {
		return sortedArrayToBST(arr, 0, n - 1);
	}
	Node sortedArrayToBST(int arr[], int start, int end) {
		if (start > end) return null;
		// same as (start+end)/2, but it avoids overflow.
		int mid = start + (end - start) / 2;
		Node node = new Node();
		node.data = arr[mid];
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);
		return node;
	}
	public static void main(String[] args) {
		int[] sortedArray = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		SortedArrayToBST test = new SortedArrayToBST();
		Node node = test.sortedArrayToBST(sortedArray, 11);
		printTree(node);
	}
	private static void printTree(Node node) {
		if(node == null)
			return;
		printTree(node.left);
		System.out.print(" "+node.data);
		printTree(node.right);
	}
	}