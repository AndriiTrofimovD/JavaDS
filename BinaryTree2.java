

public class BinaryTree2<E>{
	
	@SuppressWarnings("hiding")
	class Node<E>{
		E data;
		Node<E> left, right;
		
		public Node(E data) {
			this.data = data;
		}
		public Node<E> min() {
			if(left == null) {
				return this;
			}
			return left.min();
		}
	}
	
	Node<E> root;
	
	public BinaryTree2() {}
	public BinaryTree2(E data) {
		Node<E> node = new Node<E>(data);
		this.root = node;
	}
	
	public Node<E> minNode(Node<E> node) {
		return node.min();
	}
	
	public boolean contains(E data) {
		Node<E> node = contains(root, data);
		
		return node == null? false: true;
	}
	@SuppressWarnings("unchecked")
	private Node<E> contains(Node<E> node, E data) {
		if(node == null || (((Comparable<E>)data).compareTo(node.data) == 0)) {
			return node;
		}else if(((Comparable<E>)data).compareTo(node.data) < 0) {
			contains(node.left, data);
		}else {
			contains(node.right, data);
		}
		return node;
	}
	
	public void insert(E data) {
		root = insert(root, data);
	}
	
	@SuppressWarnings("unchecked")
	private Node<E> insert(Node<E> node, E data){
		Node<E> newNode = new Node<E>(data);
		if(node == null) {
			node = newNode;
			return node;
		}else if(((Comparable<E>)data).compareTo(node.data) < 0) {
			node.left = insert(node.left, data);
		}else {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	public void delete(E data) {
		root = delete(root, data);
	}
	@SuppressWarnings("unchecked")
	private Node<E> delete(Node<E> node, E data) {
		if(node == null) {
			return null;
		}else if(((Comparable<E>)data).compareTo(node.data) < 0) {
			node.left = delete(node.left, data);
		}else if (((Comparable<E>)data).compareTo(node.data) > 0) {
			node.right = delete(node.right, data);
		}else {
			if(node.left == null && node.right == null)
				node = null;
			else if(node.left == null) {
				node = node.right;
			}
			else if(node.right == null) {
				node = node.left;
			}
			else {
				Node<E> minRight = minNode(node.right);
				node.data = minRight.data;
				node.right = delete(node.right, node.data);
			}
		}
		return node;
	}
	
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(Node<E> node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.print(node.data + " ");
			printInOrder(node.right);
		}
	}
	
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	private void printPreOrder(Node<E> node) {
		if(node != null) {
			System.out.print(node.data + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	
	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	private void printPostOrder(Node<E> node) {
		if(node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.data + " ");
		}
	}
}

















