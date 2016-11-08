/***********************************************************************************
Implement the Bellman Ford Algorithm to find the shortest path, even when there are
-ve edge weights. You will create a graph of at least 6 nodes and 12 edges.  Make 3 
edges with negative weights.
The output should show the result after the algorithm finds the shortest path.
Then run the algorithm to see if there are any -ve cycles.
 ***********************************************************************************/
package Homework4;

import java.util.ArrayList;

public class BellmanFord {

	static class Vertices {
		int origin;
		int opposite;
		int weight;

		// default constructor
		public Vertices() {
		}

		// constructor
		public Vertices(int newOrigin, int newOpposite, int newWeight) {
			origin = newOrigin;
			opposite = newOpposite;
			weight = newWeight;
		}
	}

	public static void main(String[] args) {
		ArrayList<Vertices> Verticess = new ArrayList<Vertices>();

		Verticess.add(new Vertices(0, 1, 7));
		Verticess.add(new Vertices(0, 2, 5));
		Verticess.add(new Vertices(0, 3, 4));

		Verticess.add(new Vertices(1, 0, -2));
		Verticess.add(new Vertices(1, 4, 2));

		Verticess.add(new Vertices(2, 1, -3));
		Verticess.add(new Vertices(2, 3, 1));
		Verticess.add(new Vertices(2, 4, 4));

		Verticess.add(new Vertices(3, 4, 2));
		Verticess.add(new Vertices(3, 5, 3));

		Verticess.add(new Vertices(4, 1, 8));
		Verticess.add(new Vertices(4, 2, 5));

		Verticess.add(new Vertices(5, 2, -1));
		Verticess.add(new Vertices(5, 4, 5));

		TestBellmanFord(Verticess, 6, 0);
	}

	static int Infinity = 9999;

	// set the origin distance to zero and everything else to infinity
	public static void TestBellmanFord(ArrayList<Vertices> Verticess,
			int number, int origin) {
		int[] distance = new int[number];
		for (int i = 0; i < distance.length; i++){
			distance[i] = Infinity;
		}
		distance[origin] = 0;

		// Iteration i finds all shortest paths that use i edges.
		for (int i = 0; i < number; i++)
			for (int j = 0; j < Verticess.size(); j++) {

				if (distance[Verticess.get(j).origin] == Infinity)
					continue;

				int newDistance = distance[Verticess.get(j).origin]
						+ Verticess.get(j).weight;

				if (newDistance < distance[Verticess.get(j).opposite])
					distance[Verticess.get(j).opposite] = newDistance;
			}
		
		// display the output after the algorithm finds the shortest path.
		System.out.println("The output of the Bellman-Ford Algorithm finding the shortest path is : \n");
		for (int i = 0; i < distance.length; i++) {

			System.out.println("The shortest distance between the two nodes " + origin
					+ " and " + i + " is " + distance[i]);
		}

		// detect a negative-weight cycle if it exists 
		for (int i = 0; i < Verticess.size(); i++)

			if (distance[Verticess.get(i).origin] != Infinity
					&& distance[Verticess.get(i).opposite] > distance[Verticess
							.get(i).origin] + Verticess.get(i).weight) {
				System.out.println("Negative cycle checks: There are -ve cycles.");
				return;
			}
		
		System.out.println("\n**** Negative cycle checks: There are no -ve cycles ****");

	}
}