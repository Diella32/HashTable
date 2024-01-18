package linearProbingPD;

public class LinearProbing<E> {

	int size = 0;
	MapEntry<E>[] arrayUsed; 
	MapEntry<E> defunct = new MapEntry(-1, null); 
	private class MapEntry<E> {
		int key = 0;
		E element; 
	
		private MapEntry(int keyUsed, E objectUsed){
			key = keyUsed;
			element = objectUsed; 
		}
		
		public void setKey(int keyUsed) {
			key = keyUsed; 
		}
		
		public int getKey() {
			return key; 
		}
		
		public E getElement() {
			return element;
		}
		public void setElement(E elementUsed) {
			element = elementUsed; 
		}
			
	}
	
	public LinearProbing( int sizeUsed) {
		size = sizeUsed; 
		arrayUsed = new MapEntry[size];
	}
	
	public void setSize(int sizeUsed) {
		size = sizeUsed; 
	}
	public int getSize() {
		return size; 
	}
	
	private int Hash(int key) {
		return (3 * key - 5) % (size); 
	}
	
	
	public E get(int key) {
	
		int beginning = Hash(key);
		int hashedKey = Hash(key);
		if (arrayUsed[hashedKey] != null) {
			if(arrayUsed[hashedKey].key == key) {
				return arrayUsed[hashedKey].element; 
			}
			else {
				 hashedKey = (hashedKey + 1)%size;
				// if () { 
			while(arrayUsed[hashedKey] != null && hashedKey != beginning) {
				if(arrayUsed[hashedKey].key != key)
					hashedKey = (hashedKey + 1)%size;
				else
					return arrayUsed[hashedKey].element;
			//}
				 }
			}
		}
		if(hashedKey != beginning && arrayUsed[hashedKey] != null) {
			return arrayUsed[hashedKey].element; 
		}
		else
			return null; 
		 
	}
	
	public int put(int key, E element) {
		int collisions =0; 
		int hashedKey = Hash(key); 
		while(arrayUsed[hashedKey] != null) {
			hashedKey = (hashedKey + 1)%size; 
			collisions++; 
		}
		arrayUsed[hashedKey] = new MapEntry(key,element); 
		return collisions; 
	}
	public E Remove (int key) {
		
		int beginning = Hash(key);
		int hashedKey = Hash(key);
		E elementUsed; 
		if (arrayUsed[hashedKey] != null) {
			if(arrayUsed[hashedKey].key == key) {
				elementUsed = arrayUsed[hashedKey].element;
				arrayUsed[hashedKey] = defunct; 
				return elementUsed; 
			}
			else {
				 hashedKey = (hashedKey + 1)%size;
			while(arrayUsed[hashedKey].key != key && hashedKey != beginning) {
				hashedKey = (hashedKey + 1)%size;
			}
			}
		}
		if(hashedKey != beginning) {
			elementUsed = arrayUsed[hashedKey].element;
			arrayUsed[hashedKey] = defunct; 
			return elementUsed; 
			
		}
		else
			return null; 
		 
	}
		
	}
	

