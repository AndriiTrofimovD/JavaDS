
public class LinkedList<E>{
	
	@SuppressWarnings("hiding")
	class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E data) {
			this.data = data;
		}
	}
	
	Node<E> head, tail;
	int size = 0;
	
	public LinkedList() {;}
	public LinkedList(E value) {
		this.head = new Node<E>(value);
		this.tail = this.head;
		this.size++;
	}
	
	public void addFirst(E value) {
		Node<E> node = new Node<E>(value);
		if(head == null) {
			head = node;
			tail = node;
			size++;
		}else {
			node.next = head;
			head = node;
			size++;
		}
	}
	public void addLast(E value) {
		Node<E> node = new Node<E>(value);
		if(tail == head) {
			addFirst(value);
		}else {
		tail.next = node;
		tail = node;
		size++;
		}
	}
	
	public void clear() {
		head = tail = null;
		size = 0;
	}
	
	public void print() {
		Node<E> node = head;
		while(node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}
	
	public void removeFirst() {
		if(size < 2) {
			clear();
		}else {
			head = head.next;
			size--;
		}
	}
	
	public void removeLast() {
		Node<E> node = head;
		if(size < 2) {
			clear();
		}else {
			while(node.next != tail) {
				node = node.next;
			}
			node.next = null;
			tail = node;
			size--;
		}
	}
	@SuppressWarnings("unchecked")
	public void remove(E value) {
		Node<E> node = head;
		if(size == 0) {System.out.println("The list is empty."); return;}
		if(size == 1 && ((Comparable<E>)value).compareTo(head.data) != 0) {System.out.println("The value is not the list.");}
		else if(((Comparable<E>)value).compareTo(head.data) == 0) {removeFirst();}
		else if(((Comparable<E>)value).compareTo(tail.data) == 0) {removeLast();}
		else {
			while(((Comparable<E>)value).compareTo(node.next.data) != 0) {
				if(node.next == tail) {System.out.println("The value is not in the list."); return;}
				node = node.next;
			}
			node.next = node.next.next;
			size--;
		}
	}
	
	public void reverse() {
		if(size < 2) {return;}
		tail = head;
		Node<E> current = head;
		Node<E> previous = null;
		while(current != null) {
			Node<E> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		
	}
}

