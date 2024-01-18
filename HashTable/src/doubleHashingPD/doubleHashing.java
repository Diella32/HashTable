package doubleHashingPD;


public class doubleHashing<E> {
		
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
		
		public doubleHashing( int sizeUsed) {
			size = sizeUsed; 
			arrayUsed = new MapEntry[size];
		}
		
		public void setSize(int sizeUsed) {
			size = sizeUsed; 
		}
		public int getSize() {
			return size; 
		}
		
		private int Hash(int key, int i) {
			return (((3 * key - 5) % size + (i*(7-(key%7))))%size) ; 
		}
		
		
		public E get(int key) {
			int i =0; 
			int hashedKey = Hash(key, i);
			if(arrayUsed[hashedKey] == null) {
				
				return null; 
			}
			
			while(arrayUsed[hashedKey] != null) {
				
				hashedKey = Hash(key, i);
				if(arrayUsed[hashedKey] != null) {
				if(arrayUsed[hashedKey].getKey() == key) {
				
					return arrayUsed[hashedKey].getElement();
				}
				}
				i++;
			}
			 
			return null;
		}
		
		public int put(int key, E element) {
			int collisions =0; 
			int i = 0; 
			int hashedKey = Hash(key, i); 
			while(arrayUsed[hashedKey] != null) {
				i++;
				hashedKey = Hash(key, i);
				collisions++;
				
			}
			
			arrayUsed[hashedKey] = new MapEntry(key,element); 
			return collisions; 
	}
		public E Remove (int key) {
			int i = 0; 
			int beginning = Hash(key, i);
			int hashedKey = Hash(key, i);
			E elementUsed; 
			if (arrayUsed[hashedKey] != null) {
				if(arrayUsed[hashedKey].key == key) {
					elementUsed = arrayUsed[hashedKey].element;
					arrayUsed[hashedKey] = defunct; 
					return elementUsed; 
				}
				else {
					 i++; 
					 hashedKey = Hash(key, i); //ici
				while(arrayUsed[hashedKey].key != key && hashedKey != beginning) {
					i++; 
					hashedKey = Hash(key, i);				}
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


