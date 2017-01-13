import java.util.Dictionary;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
 * "SEE", -> returns true, word = "ABCB", -> returns false.
 * 
 * @author alantran
 *
 */
public class WordSearch {
	private static char[][] dict;
	private static boolean[][] visited;
	static int maxR = dict.length ;
	static int maxC = dict[0].length;
	
	public static void main(String[] args){
		
		String s = "ABCD";
		visited = new boolean[maxR][maxC];
		for(int i = 0; i < dict.length; i++){
			for(int j = 0; j <dict[0].length ; j++){
				findWord(s, 0, i, j,maxR, maxC);			
			}
		}
	}
	
	private static boolean findWord( String target, int index, int row, int col,int maxR,int maxC){
		if (index == target.length()) return true;
		if (visited[row][col] == true) return false;
		char currentChar = target.charAt(index);
		
		if (dict[row][col] != currentChar) return false;
		if(dict[row][col] == currentChar){
			index++;
			visited[row][col] = true;
		}
		boolean tempAnswer = false;
		if (row -1 >=0){
			tempAnswer = tempAnswer || findWord( target, index, row - 1, col, maxR,maxC);
		}
		
		if (row+1 <= maxR){
			tempAnswer = tempAnswer || findWord(target, index, row + 1, col, maxR,maxC);
		}
		
		if (col -1 >=0){
			tempAnswer = tempAnswer || findWord(target, index, row, col - 1, maxR,maxC);
		}
		
		if (col+1 <= maxC){
			tempAnswer = tempAnswer || findWord(target, index, row, col + 1, maxR,maxC);
		}
		
		return tempAnswer;
	}

}
