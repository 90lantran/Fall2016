
public class BitManipulation {
	public static void main(String[] args){
		int n = 7;
		//int result = 0;
		
	}
	
	
	// Count Parity
	private int countParity(int n){
		int count = 0;
		while (n > 0){
			//result ^= (n & 1);
			count += 0 ^ (n & 1);
			n >>= 1;
		}
		System.out.println(count);
		return count;
	}
	private boolean getBit(int n, int index){
		int temp = 1<<index ;
		return ((n & temp) != 0);
	}
}
