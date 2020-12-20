import java.util.Arrays;

public class MaxBinaryHeap<E>{
	
	int size = 0;
	int capacity = 10;
	@SuppressWarnings("unchecked")
	E[] items = (E[]) new Object[capacity];
	
	public MaxBinaryHeap() {}
	@SuppressWarnings("unchecked")
	public MaxBinaryHeap(int capacity) {
		this.capacity = capacity;
		this.items = (E[]) new Object[capacity];
	}
	
	private int indexOfLeftChild(int index) {return 2 * index + 1;}
	private int indexOfRightChild(int index) {return 2 * index + 2;}
	private int indexOfParent(int index) {return (index - 1)/2;}
	
	private E valueOfLeftChild(int index) {return items[indexOfLeftChild(index)];}
	private E valueOfRightChild(int index) {return items[indexOfRightChild(index)];}
	private E valueOfParent(int index) {return items[indexOfParent(index)];}
	
	private boolean hasLeftChild(int index) {return indexOfLeftChild(index) < size;}
	private boolean hasRightChild(int index) {return indexOfRightChild(index) < size;}
	private boolean hasParent(int index) {return indexOfParent(index) >= 0;}
	
	private void swap(int indexOne, int indexTwo) {
		E temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureCapacity() {
		if(capacity == size) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && (((Comparable<E>)valueOfParent(index)).compareTo(items[index]) < 0)) {
			swap(index, indexOfParent(index));
			index = indexOfParent(index);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int indexOfGreaterValue = indexOfLeftChild(index);
			if(hasRightChild(index) && (((Comparable<E>)valueOfRightChild(index)).compareTo(valueOfLeftChild(index)) > 0)) {
				indexOfGreaterValue = indexOfRightChild(index);
			}
			if(((Comparable<E>)items[index]).compareTo(items[indexOfGreaterValue]) > 0) {
				return;
			}
			swap(index, indexOfGreaterValue);
			index = indexOfGreaterValue;
		}
	}
	
	public E extractMax() {
		if(size == 0) {throw new IllegalStateException();}
		E temp = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return temp;
	}
	
	public void add(E value) {
		ensureCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}
	
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(i + " -> [" + items[i] + "]");
		}
	}
	
}

