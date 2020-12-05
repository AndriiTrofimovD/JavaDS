import java.util.Arrays;

public class MaxBinaryHeap{
	
	int capacity = 10;
	int size = 0;
	int[] items = new int[capacity];
	
	public MaxBinaryHeap() {}
	public MaxBinaryHeap(int capacity) {
		this.capacity = capacity;
		this.items = new int[capacity];
	}
	
	private int indexOfLeftChild(int index) {return 2 * index + 1;}
	private int indexOfRightChild(int index) {return 2 * index + 2;}
	private int indexOfParent(int index) {return (index -1) / 2;}
	
	private boolean hasLeftChild(int index) {return indexOfLeftChild(index) < size;}
	private boolean hasRightChild(int index) {return indexOfRightChild(index) < size;}
	private boolean hasParent(int index) {return indexOfParent(index) >= 0;}
	
	private int valueOfLeftChild(int index) {return items[indexOfLeftChild(index)];}
	private int valueOfRightChild(int index) {return items[indexOfRightChild(index)];}
	private int valueOfParent(int index) {return items[indexOfParent(index)];}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	private void ensureCapacity() {
		if(capacity == size) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && valueOfParent(index) < items[index]) {
			swap(index, indexOfParent(index));
			index = indexOfParent(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int indexOfGreaterChild = indexOfLeftChild(index);
			if(hasRightChild(index) && valueOfRightChild(index) > valueOfLeftChild(index)) {
				indexOfGreaterChild = indexOfRightChild(index);
			}
			if(items[index] > items[indexOfGreaterChild]) {
				break;
			}
			swap(index, indexOfGreaterChild);
			index = indexOfGreaterChild;
		}
	}
	
	public void add(int value) {
		ensureCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}
	
	public int extractMax() {
		if(size == 0) {throw new IllegalStateException();}
		int temp = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return temp;
	}
	
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.println(i + " [" + items[i] + "]");
		}
	}
}

