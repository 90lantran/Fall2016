import java.util.Scanner;

/**
 * In an array, , the elements at indices and (where ) form an inversion if . In
 * other words, inverted elements and are considered to be "out of order". To
 * correct an inversion, we can swap adjacent elements.
 * 
 * For example, consider . It has two inversions: and . To sort the array, we
 * must perform the following two swaps to correct the inversions:
 * 
 * @author alantran
 *
 */

public class CountingInversion {
	public static long countInversions(int[] arr) {
		return countInversionsHelper(arr, 0, arr.length - 1);
	}

	public static long countInversionsHelper(int[] arr, int start, int end) {
		if (start == end)
			return 0;
		else {
			long x = countInversionsHelper(arr, start, (start + end) / 2);
			long y = countInversionsHelper(arr, (start + end) / 2 + 1, end);
			long z = countSplitInversion(arr, start, (start + end) / 2, end);
			return x + y + z;
		}
	}

	public static long countSplitInversion(int[] arr, int lo, int mid, int hi) {

		long count = 0;
		int i = lo, j = mid + 1, k = 0;
		int[] newArr = new int[hi - lo + 1];
		while(i <= mid && j <= hi){
			if (arr[i] <= arr [j]){
				newArr[k++] = arr[i++];
			} else {
				newArr[k++] = arr[j++];
				count += mid - i + 1;
			}
		} 
		 while (i <= mid){
			 newArr[k++] = arr[i++];
		 }
		 
		 while (j <= hi){
			 newArr[k++] = arr[j++];
		 }
		 
		 System.arraycopy(newArr, 0, arr, lo, hi - lo + 1);
	
		return count;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			System.out.println(countInversions(arr));
		}
	}
}
