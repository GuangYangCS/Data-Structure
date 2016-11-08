package Homework6;

/******************
 Implement a hash table.  
 You will insert numbers in the hash tables.  Each number can be up to 8 digits long.
 Use open addressing scheme with quadratic probing
 Also implement such that if the load factor increases to more than .5 then you increase the table size.

 Submit two runs.  ... One showing the result of inserting such that n item has at least 3 collisions.
 Second run show the increase in table size as the load factor increases to more than 5
 */
import java.util.Scanner;

public class HashTableTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hash Table  Implementation : Quadratic Probing\n");
		System.out.print("Please enter the table size : ");

		int capacity = scan.nextInt();
		HashTable ht = new HashTable(capacity);

		char ch;
		/*
		 * Using loop to continue the insert operation in this program until
		 * input is different than 'Y', then the program will exit.
		 */

		do {

			System.out.print("Enter integer element to insert : ");

			ht.insert(scan.nextInt());

			// System.out.println("Hash table Maximum capavity : " +
			// ht.capacity);
			// System.out.println("Hash table current capavity : " +
			// ht.occupied);

			/*
			 * Rwhen load factor is larger than 0.5, automatically double the
			 * prime size and rehashing
			 */
			if (HashTable.occupied > 0.5 * ht.capacity) {

				int newCapacity = ht.doublePrime(capacity);
				System.out
						.println("Rehashing since load factor is more than 0.5, double the array size to a prime number : "
								+ newCapacity);

				ht.rehash(ht.hashArray, capacity, newCapacity);

				/*
				 * Replace the old object with a new instance with a new double
				 * prime capacity and has the new rehashing array
				 */

				ht = HashTable.ht2;

			}

			ht.printHashTable();

			System.out.print("Insert number ? (Type Y (y) or N) : ");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
