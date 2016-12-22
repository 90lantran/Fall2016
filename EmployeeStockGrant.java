import javax.print.attribute.standard.Finishings;


public class EmployeeStockGrant {
	 public static void main(String[] args){
		 int[] ratings = {6,1,1,1,2,2,2,3,3,3,4,5};
		 int[] min =     {2,1,2,3,2,1,2,3,2,1,2,3};
		 int[] result = new int[ratings.length];
		 
		 // find min ratings
		 int minRatingsIndex = findMin(ratings);
		 result[minRatingsIndex] = min[minRatingsIndex];
		 // forward
		 for (int i = minRatingsIndex + 1; i < ratings.length; i++){
			 if (ratings[i] == ratings[i-1]){
				 result[i] = Math.max(min[i], result[i - 1]);
			 } else {
				 result[i] = 1 + result[i -1];
			 }
		 }
		 //backward
		 for (int i = minRatingsIndex - 1; i >= 0; i--){
			 if (ratings[i] == ratings[i + 1]){
				 result[i] = result[i + 1];
			 } else {
				 result[i] = 1 + result[i + 1];
			 }
		 }
		 
		 for(int x: result){
			 System.out.print(x +  " ") ;
		 }
		 
		 int maxRatingIndex = findMaxRating(ratings);
	 
	 
	 }
	 
	 private static int findMaxRating(int[] ratings){
		 int currentMaxIndex = 0;
		 for(int i = 1; i < ratings.length; i++){
			 if (ratings[currentMaxIndex] < ratings[i]){
				 currentMaxIndex = i;
				 
			 }
		 }
		 
		 return currentMaxIndex;
		 
		 
	 }
	 private static int findMin(int[] ratings){
		 int currentMinIndex = 0;
		 for(int i = 1; i < ratings.length; i++){
			 if (ratings[currentMinIndex] > ratings[i]){
				 currentMinIndex = i;
				 break;
			 }
		 }
		 
		 return currentMinIndex;
	 }
	 
}
