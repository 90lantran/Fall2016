import java.util.Scanner;

/**
 * Given an matrix, find and print the number of cells in the largest region in
 * the matrix. Note that there may be more than one region in the matrix.
 * 
 * @author alantran
 *
 */

public class DFS {
	public static int getBiggestRegion(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = false;
			}
		}
		int currentMax = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int temp = getBiggestRegionHelper(matrix, visited, i, j, n, m);
				currentMax = Math.max(temp, currentMax);
			}
		}
		return currentMax;
	}

	private static int getBiggestRegionHelper(int[][] matrix, boolean[][] visited, int currentRow, int currentCol,
			int row, int col) {
		int numberOfOne = 0;
		if (visited[currentRow][currentCol] == false && matrix[currentRow][currentCol] == 1) {
			numberOfOne = numberOfOne + 1;
			visited[currentRow][currentCol] = true;
			if (currentRow - 1 >= 0) {
				numberOfOne = numberOfOne
						+ getBiggestRegionHelper(matrix, visited, currentRow - 1, currentCol, row, col);
				if (currentCol - 1 >= 0) {
					numberOfOne = numberOfOne
							+ getBiggestRegionHelper(matrix, visited, currentRow - 1, currentCol - 1, row, col);
				}
				if (currentCol + 1 < col) {
					numberOfOne = numberOfOne
							+ getBiggestRegionHelper(matrix, visited, currentRow - 1, currentCol + 1, row, col);
				}
			}
			if (currentRow + 1 < row) {
				numberOfOne = numberOfOne
						+ getBiggestRegionHelper(matrix, visited, currentRow + 1, currentCol, row, col);
				if (currentCol - 1 >= 0) {
					numberOfOne = numberOfOne
							+ getBiggestRegionHelper(matrix, visited, currentRow + 1, currentCol - 1, row, col);
				}
				if (currentCol + 1 < col) {
					numberOfOne = numberOfOne
							+ getBiggestRegionHelper(matrix, visited, currentRow + 1, currentCol + 1, row, col);
				}
			}

			if (currentCol - 1 >= 0) {
				numberOfOne = numberOfOne
						+ getBiggestRegionHelper(matrix, visited, currentRow, currentCol - 1, row, col);

			}

			if (currentCol + 1 < col) {
				numberOfOne = numberOfOne
						+ getBiggestRegionHelper(matrix, visited, currentRow, currentCol + 1, row, col);
			}

			return numberOfOne;
		} else {
			visited[currentRow][currentCol] = true;
		}
		return numberOfOne;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		in.close();
		System.out.println(getBiggestRegion(grid));
	}
}
