package Homework6;

class HashTable {
	int[] hashArray;
	int capacity;

	// constructor
	public HashTable(int capacity) {
		this.capacity = nextPrime(capacity);
		hashArray = new int[this.capacity];
	}

	// parameter as a counter to count the occupied items in the array.
	static int occupied = 0;

	// insert method to find the position for new number
	public void insert(int ele) {
		int index = ele % capacity;
		if (hashArray[index] == 0) {
			hashArray[index] = ele;
		}
		// collision occurs
		else {
			hashArray[quadProbing(ele, capacity)] = ele;
		}
		occupied++;
	}

	/*
	 * this method is used to find the next available position for the inserted
	 * element when collision happens.
	 */
	int quadProbing(int ele, int capacity) {
		int current;
		int collisionNumber = 0;
		current = ele % capacity;
		// Using Quadratic Probing to solve collision
		while (hashArray[current] != 0 && hashArray[current] != ele) {
			current += 2 * ++collisionNumber - 1;
			// make sure the current position is still in the array
			if (current >= hashArray.length)
				current = current % hashArray.length;
		}
		return current;
	}

	static HashTable ht2;

	public static int[] rehash(int[] hashArray, int capacity, int newCapacity) {
		ht2 = new HashTable(newCapacity);
		;
//		System.out.println(newCapacity);

		for (int index = 0; index < newCapacity; index++) {

			int[] tempHashArray = new int[newCapacity];

			System.arraycopy(hashArray, 0, tempHashArray, 0, hashArray.length);

			int ele = tempHashArray[index];

			ht2.insert(ele);
			// System.out.println(ht2.hashArray[index]);
		}
		return ht2.hashArray;

	}

	// double the array size to a new prime number
	public int doublePrime(int n) {
		n = 2 * n + 1;
		while (!isPrime(n)) {
			n++;
		}
		return n;

	}

	// This method resize the user's given initial array size to the next prime
	// number
	static int nextPrime(int n) {
		if (n % 2 == 0)
			n++;
		while (!isPrime(n)) {
			n = n + 2;
		}

		return n;
	}

	// This method is used to check if given array size is prime
	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	// print the hash table
	public void printHashTable() {
		System.out.println("\nHash Table is : ");
		for (int i = 0; i < capacity; i++)
			System.out.println(i + " : " + ((hashArray[i] == 0) ? "Null" : hashArray[i]));

	}
}
