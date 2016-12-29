import java.util.Comparator;

public class SortingComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return o2.score - o1.score;
	}
	
	
	
}
