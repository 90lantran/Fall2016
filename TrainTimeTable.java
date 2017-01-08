import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrainTimeTable {
	private int cases ;
	private int turnTime;
	private int tripA;
	private int tripB;
	
	public static void main(String[] args){
		
	}
	
	public void readFromFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter("A-small-train-timetable"));
		cases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= cases; i++){
			turnTime = Integer.parseInt(br.readLine());
			String[] numberOfTrips = br.readLine().split(" ");
			tripA = Integer.parseInt(numberOfTrips[0]);
			tripB = Integer.parseInt(numberOfTrips[1]);
			
			
			
		}
	}
}
