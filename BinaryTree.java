
public class BinaryTree{
	
	class Node{
		int key;
		String value;
		Node left, right;
		
		public Node(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public Node min() {
			if (left == null) {
				return this;
			}
			return left.min();
		}
	}
	
	Node root;
	
	public BinaryTree() {}
	public BinaryTree(int key, String value) {
		Node node = new Node(key, value);
		root = node;
	}
	
	public void insert(int key, String value) {
		root = insert(root, key, value);
	}
	private Node insert(Node node, int key, String value) {
		Node newNode = new Node(key, value);
		if(node == null) {
			node = newNode;
			return node;
		}else {
			if(key < node.key) {
				node.left = insert(node.left, key, value);
			}else {
				node.right = insert(node.right, key, value);
			}
		}
		return node;
	}
	
	public String find(int key) {
		Node node = find(root, key);
		return node==null? null: node.value;
	}
	
	private Node find(Node node, int key) {
		if(node == null || node.key == key) {
			return node;
		}else {
			if(key < node.key) {
				return find(node.left, key);
			}else {
				return find(node.right, key);
			}
		}
	}
	
	public Node findMin(Node node) {
		return node.min();
	}
	
	public void delete(int key) {
		root = delete(root, key);
	}
	
	private Node delete(Node node, int key) {
		if(node == null) {
			return null;
		}
		if(key < node.key) {
			node.left = delete(node.left, key);
		}
		else if(key > node.key) {
			node.right = delete(node.right, key);
		}
		else {
			if(node.left == null && node.right == null) {
				node = null;
			}
			else if(node.left == null) {
				node = node.right;
			}
			else if(node.right == null) {
				node = node.left;
			}
			else {
				Node minRight = findMin(node.right);
				node.key = minRight.key;
				node.value = minRight.value;
				node.right = delete(node.right, node.key);
			}
		}
		return node;
	}
	
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.print(node.key + " ");
			printInOrder(node.right);
		}
	}
	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	private void printPostOrder(Node node) {
		if(node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.key + " ");
		}
	}
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	private void printPreOrder(Node node) {
		if(node != null) {
			System.out.print(node.key + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
}












