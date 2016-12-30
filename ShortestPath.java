import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
	public static class Graph {
		
		private ArrayList<ArrayList<Integer>> adjMatrix;

		public Graph(int size) {
			adjMatrix = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < size ; i++){
				adjMatrix.add(i,new ArrayList<Integer>());
			}
		}

		public void addEdge(int first, int second) {
			adjMatrix.get(first).add(second);
			adjMatrix.get(second).add(first);
		}

		public int[] shortestReach(int startId) { // 0 indexed
			int[] distances = new int[adjMatrix.get(startId).size()];
			Arrays.fill(distances, -1);
			
			Queue<Integer> queue = new LinkedList<>();
			List<Integer> visited = new ArrayList<Integer>();
			queue.add(startId);
			distances[startId] = 0;
			while (!queue.isEmpty()){
				Integer currentNode = queue.poll();
				visited.add(currentNode);
				for (Integer neighbor : adjMatrix.get(currentNode)){
					if (!visited.contains(neighbor)){
						queue.add(neighbor);
						distances[neighbor] = distances[currentNode] + 6;
					}
				}
			}
			return distances;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int queries = scanner.nextInt();

		for (int t = 0; t < queries; t++) {

			// Create a graph of size n where each edge weight is 6:
			Graph graph = new Graph(scanner.nextInt());
			int m = scanner.nextInt();

			// read and set edges
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;

				// add each edge to the graph
				graph.addEdge(u, v);
			}

			// Find shortest reach from node s
			int startId = scanner.nextInt() - 1;
			int[] distances = graph.shortestReach(startId);

			for (int i = 0; i < distances.length; i++) {
				if (i != startId) {
					System.out.print(distances[i]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		scanner.close();
	}
}
