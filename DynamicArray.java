
public class DynamicArray{
	
	private Object[] data;
	public int size;
	public int initialCapacity;
	
	public DynamicArray(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		data = new Object[initialCapacity];
	}
	
	public String get(int index) {
		return (String)data[index];
	}
	
	public void append(Object value) {
		if(size == initialCapacity) {
			resize();
		}
		data[size] = value;
		size++;
	}
	
	public void insert(int index, String value) {
		if (size == initialCapacity) {
			resize();
		}
		
		for(int j = size; j > index; j--) {
			data[j] = data[j-1];
		}
		data[index] = value;
		size++;
	}
	private void resize() {
		Object[] newData = new Object[initialCapacity * 2];
		for (int i = 0; i < initialCapacity; i++) {
			newData[i] = data[i];
		}
		data = newData;
		initialCapacity *= 2;
	}
	public void delete(int index) {
		for(int i = index; i < size-1; i++) {
			data[i] = data[i+1];
			
		}size--;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean contains(String value) {
		for(int i = 0; i < size; i++) {
			String currValue = (String)data[i];
			if (currValue.equals(value)) {
				return true;
			}
		}
		return false;
	}
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
}
