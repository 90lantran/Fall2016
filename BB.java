import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BB {

	public static final String SEPARATOR = "@";
	public static final String COLON = ":";
	private static List<Portfolio> portfolioList = new ArrayList<Portfolio>();
	private static List<Benchmark> benchmarkList = new ArrayList<Benchmark>();
	private static final String SELL = "SELL";
	private static final String BUY = "BUY";

	/*
	 * Complete the function below.
	 * 
	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

	static int countHoldings(String input) {
		String[] tokens = input.split(SEPARATOR);
		return tokens.length;
	}

	// static String printHoldings(String portfolioString) {
	// String[] holdings = portfolioString.split(COLON);
	// String[] tokens = holdings[1].split(SEPARATOR);
	// List<Benchmark> result = new ArrayList<Benchmark>();
	//
	// // Creating Benchmark object for each benchmark
	// for(String token: tokens){
	// String[] subTokens = token.split(",");
	// Benchmark portfolioHolding = new Benchmark(subTokens[0], subTokens[1],
	// subTokens[2]);
	// result.add(portfolioHolding);
	//
	// }
	//
	// // An anonymous comparator for sorting by ticker
	// Comparator<Benchmark> comparator = new Comparator<Benchmark>() {
	// @Override
	// public int compare(Benchmark p1, Benchmark p2) {
	// return p1.getTicker().compareTo(p2.getTicker());
	// }
	// };
	//
	// Collections.sort(result, comparator);
	// String temp = result.toString();
	// // Some String manipulations to match the output format
	// return temp.substring(1,temp.length()-1);
	// }

	static void createPortfolioAndBenchmark(String portfolioString) {
		String[] holdings = portfolioString.split(COLON);
		String[] portfolios = holdings[0].split(SEPARATOR);
		String[] benchmarks = holdings[1].split(SEPARATOR);

		// An anonymous comparator for sorting by ticker
		Comparator<Base> comparator = new Comparator<Base>() {
			@Override
			public int compare(Base p1, Base p2) {
				return p1.getTicker().compareTo(p2.getTicker());
			}
		};

		// Creating portfolioList
		for (String token : portfolios) {
			String[] subTokens = token.split(",");
			Portfolio portfolioHolding = new Portfolio(subTokens[0], subTokens[1], subTokens[2]);
			portfolioList.add(portfolioHolding);
		}
		Collections.sort(portfolioList, comparator);

		// Creating portfolioList
		for (String token : benchmarks) {
			String[] subTokens = token.split(",");
			Benchmark benchmark = new Benchmark(subTokens[0], subTokens[1], subTokens[2],
					Double.parseDouble(subTokens[3]));
			benchmarkList.add(benchmark);
		}
		Collections.sort(benchmarkList, comparator);

	}

	static String generateTransactions(String input) {
		createPortfolioAndBenchmark(input);
		List<Transaction> transactions = new ArrayList<Transaction>();

		Double portfolioNAV = 0.0;
		for (int i = 0; i < portfolioList.size(); i++) {
			Double price = benchmarkList.get(i).getPrice();
			Integer quantity = Integer.parseInt(portfolioList.get(i).getQuantity());
			Double value = price * quantity;
			portfolioNAV += value;
		}

		Double benchmarkNAV = 0.0;
		for (int i = 0; i < benchmarkList.size(); i++) {
			Double price = benchmarkList.get(i).getPrice();
			Integer quantity = Integer.parseInt(benchmarkList.get(i).getQuantity());
			Double value = price * quantity;
			benchmarkNAV += value;
		}

		Transaction t = null;
		for (int i = 0; i < portfolioList.size(); i++) {
			Portfolio currentPortfolio = portfolioList.get(i);
			Benchmark currentBenchmark = benchmarkList.get(i);
			Double quantity = Integer.parseInt(currentBenchmark.getQuantity()) * portfolioNAV / benchmarkNAV
					- Integer.parseInt(currentPortfolio.getQuantity());
			if (Integer.parseInt(currentPortfolio.getQuantity()) > Integer.parseInt(currentBenchmark.getQuantity())) {
				t = new Transaction(SELL, currentBenchmark.getTicker(), quantity);
			} else {
				t = new Transaction(BUY, currentBenchmark.getTicker(), quantity);
			}
			transactions.add(t);
		}

		return formatOutput(transactions.toString());
	}

	static String formatOutput(String output) {
		return output.substring(1, output.length() - 1);
	}

	static class Transaction {
		private String type;
		private String ticker;
		private Double quantity;

		public Transaction(String type, String ticker, Double quantity) {
			this.type = type;
			this.ticker = ticker;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			String temp = String.format("%.02f", quantity);
			return "[" + type + ", " + ticker + ", " + temp + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String res;
		String _input;
		try {
			_input = in.nextLine();
		} catch (Exception e) {
			_input = null;
		}
		// res = printHoldings(_input);
		res = generateTransactions(_input);
		// res = printHoldingsWithWeight(_input);
		System.out.println(res);
		in.close();
	}

	// Anonymous class for benchmark and portfolio
	private static class Base {
		private String ticker;
		private String name;
		private String quantity;

		public Base(String ticker, String name, String quantity) {
			this.ticker = ticker;
			this.name = name;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "[" + ticker + ", " + name + ", " + quantity + "]";
		}

		public String getTicker() {
			return ticker;
		}

		public String getQuantity() {
			return quantity;
		}

		public String getName() {
			return name;
		}

	}

	private static class Portfolio extends Base {
		public Portfolio(String ticker, String name, String quantity) {
			super(ticker, name, quantity);
		}
	}

	private static class Benchmark extends Base {
		private Double price;

		public Benchmark(String ticker, String name, String quantity, Double price) {
			super(ticker, name, quantity);
			this.price = price;
		}

		public Double getPrice() {
			return price;
		}
	}

	static String printHoldingsWithWeight(String inputString) {
		createPortfolioAndBenchmark(inputString);
		Map<String, String> tickerName = new HashMap<String, String>();
		Map<String, Integer> tickerPortfolio = new LinkedHashMap<String, Integer>();
		Map<String, Double> tickerBenmark = new LinkedHashMap<String, Double>();
		List<HoldingsWithWeight> holdingsWithWeightsList = new ArrayList<BB.HoldingsWithWeight>();

		for (Portfolio p : portfolioList) {
			tickerPortfolio.put(p.getTicker(), Integer.parseInt(p.getQuantity()));
			tickerName.put(p.getTicker(), p.getName());
		}
		for (Benchmark b : benchmarkList) {
			tickerBenmark.put(b.getTicker(), b.getPrice());
		}
		Double portfolioNAV = 0.0;
		for (Entry<String, Integer> entry : tickerPortfolio.entrySet()) {
			Double price = tickerBenmark.get(entry.getKey());
			Integer quantity = tickerPortfolio.get(entry.getKey());
			Double value = price * quantity;
			portfolioNAV += value;
		}

		for (Entry<String, Integer> entry : tickerPortfolio.entrySet()) {
			Double price = tickerBenmark.get(entry.getKey());
			Integer quantity = tickerPortfolio.get(entry.getKey());
			Double value = price * quantity;
			HoldingsWithWeight holdingsWithWeight = new HoldingsWithWeight(entry.getKey(), tickerName.get(entry
					.getKey()), quantity.toString(), price, value, value / portfolioNAV * 100);
			holdingsWithWeightsList.add(holdingsWithWeight);
		}

		return formatOutput(holdingsWithWeightsList.toString());

	}

	static class HoldingsWithWeight extends Base {
		private Double price;
		private Double value;
		private Double NAV;

		public HoldingsWithWeight(String ticker, String name, String quantity, Double price, Double value, Double NAV) {
			super(ticker, name, quantity);
			this.price = price;
			this.value = value;
			this.NAV = NAV;

		}

		@Override
		public String toString() {
			return "[" + super.ticker + ", " + super.name + ", " + super.quantity + ", " + doFormat(price) + ", "
					+ doFormat(value) + ", " + doFormat(NAV) + "]";
		}

		private String doFormat(Double d) {
			return String.format("%.02f", d);
		}

	}
}
