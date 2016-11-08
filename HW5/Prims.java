package Homework5;

/****************************************************
 * Implement Prim's Algorithm to find MST. You must have 10 vertices and 20 edges
 * in the graph. The edge weights are all positive. Print out the resulting MST
 * ... you can list the edges that are part of your MST.
 *****************************************************/

public class Prims {

	public static void main(String[] args) {

		int DV = 9999;
		/**
		 * Using the "Walk-Through" example in MST PPT from Vertice A to H, and
		 * also add two additional vertices I and J and five more edge
		 * (I-A,I-F,I-C and J-H,J-G) to make it 10 vertices and 20 edges total
		 **/

		int[][] matrix = { { DV, 8, DV, DV, DV, 10, DV, 4, 11, DV },
				{ 8, DV, 4, DV, 10, 7, DV, 9, DV, DV },
				{ DV, 4, DV, 3, DV, 3, DV, DV, 13, DV },
				{ DV, DV, 3, DV, 25, 18, 2, DV, DV, DV },
				{ DV, 10, DV, 25, DV, 2, 7, DV, DV, DV },
				{ 10, 7, 3, 18, 2, DV, DV, DV, 12, DV },
				{ DV, DV, DV, 2, 7, DV, DV, 3, DV, 15 },
				{ 4, 9, DV, DV, DV, DV, 3, DV, DV, 14 },
				{ 11, DV, 13, DV, DV, 12, DV, DV, DV, DV },
				{ DV, DV, DV, DV, DV, DV, 15, 14, DV, DV } };

		int[] added = new int[10];

		int u = 0;		
		int v = 0;
		int cost = 0;

		added[0] = 1;
		
		System.out.println("Displaying resulting MST: ");
		
		// ten vertices make the total nine edges of MST    
		for (int k = 0; k < 9; k++) {

			DV = 9999;

			for (int i = 0; i < 10; i++) {

				if (added[i] == 1) {

					for (int j = 0; j < 10; j++) {

						if (added[j] == 0) {

							if (DV > matrix[i][j]) {

								DV = matrix[i][j];
								u = i;
								v = j;

							}

						}

					}

				}

			}
			added[v] = 1;
			cost = cost + DV;

			System.out.println("Edge connection : " + "Vertice " + u
					+ " connected to " + "Vertice" + v + " : weighted edge "
					+ DV);

		}
		System.out.println("The total Cost of Minimum Spanning Tree = " + cost);

	}

}
