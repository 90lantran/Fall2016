import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Input
 * 
 * The first line of the input file contains the number of cases, N. N test
 * cases follow.
 * 
 * Each case starts with the number S -- the number of search engines. The next
 * S lines each contain the name of a search engine. Each search engine name is
 * no more than one hundred characters long and contains only uppercase letters,
 * lowercase letters, spaces, and numbers. There will not be two search engines
 * with the same name.
 * 
 * The following line contains a number Q -- the number of incoming queries. The
 * next Q lines will each contain a query. Each query will be the name of a
 * search engine in the case.
 * 
 * 
 * @author alantran
 *
 */

public class SavingUniverse {

	private int cases;
	private List<String> segment = new ArrayList<String>();
	private int counter;
	private int answer = 0;

	public static void main(String[] args) throws IOException {
		SavingUniverse main = new SavingUniverse();
		main.readFromFile("A-large-practice.in");
	}

	public void readFromFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter("A-large-practice.out"));
		cases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= cases; i++) {
			int numSearchEngines = Integer.parseInt(br.readLine());
			for (int j = 1; j <= numSearchEngines; j++) {
				br.readLine();
			}
			int numQueries = Integer.parseInt(br.readLine());
			answer = getSolution(numQueries, numSearchEngines, br);
			bw.write("Case #" + i + ": " + answer + "\n");
		}
		bw.close();
	}

	private int getSolution(int numQueries, int numSearchEngines, BufferedReader br) throws IOException {
		segment.clear();
		counter = 0;
		answer = 0;
		for (int j = 1; j <= numQueries; j++) {
			String currentQuery = br.readLine();
			if (!segment.contains(currentQuery)) {
				segment.add(currentQuery);
				counter++;
			}
			if (counter == numSearchEngines) {
				answer++;
				segment.clear();
				segment.add(currentQuery);
				counter = 1;
			}
		}
		return answer;
	}
}
