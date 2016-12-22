import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONProcessing 
{	
	private static Connection connection = null;
	public static void processJSON(String json) {
		/************* 
		 * Add you code to insert appropriate tuples into the database.
		 ************/
		System.out.println("Adding data from " + json + " into the database");

		JSONParser parser = new JSONParser();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("example.json"));

	
				Object obj = parser.parse(reader);
				JSONObject  jsonObject = (JSONObject) obj;
				System.out.println(obj);
				JSONObject newCustomer = (JSONObject) jsonObject.get("newcustomer");
				if (newCustomer != null) insertCustomer( newCustomer);

				
				JSONObject flightInfo = (JSONObject) jsonObject.get("flightinfo");
				String flightId = flightInfo.get("flightid").toString();
				Date flightDate = getSQLDate(flightInfo.get("flightdate").toString());
				JSONArray customerArray = (JSONArray) flightInfo.get("customers");
				Iterator<JSONObject> it = customerArray.iterator();
				while (it.hasNext()){
					JSONObject customer = it.next();
					String customerId = customer.get("customer_id").toString();
					if (customer.get("name") != null){
						insertCustomer(customer);
					}
					insertFlewOn(flightId, customerId, flightDate);
				}
			reader.close();
		} catch (IOException | ParseException | SQLException | java.text.ParseException e1) {
			e1.printStackTrace();
		}


		
	}
	
	public static void insertFlewOn(String flightId, String customerId, Date flightDate) throws SQLException{
		String insertFlewOn = "INSERT INTO flewon (flightid,customerid,flightDate) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertFlewOn);
		//System.out.println(newCustomer.get("customerid"));
		preparedStatement.setString(1, flightId);
		preparedStatement.setString(2, customerId);
		preparedStatement.setDate(3, flightDate);
		preparedStatement .executeUpdate();
	}
	public static Date getSQLDate(String date) throws java.text.ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		
	    sdf.setTimeZone(TimeZone.getTimeZone("EST"));
		
		
		java.util.Date javaDate =  sdf.parse(date);
		java.sql.Date sql = new java.sql.Date(javaDate.getTime());
		return sql;
	}
	
	public static void insertCustomer(JSONObject newCustomer) throws SQLException, java.text.ParseException{
		
		String insertCustomer = "INSERT INTO customers (customerid,name,birthdate,frequentflieron) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertCustomer);
		System.out.println(newCustomer.get("customerid"));
		preparedStatement.setString(1, newCustomer.get("customerid").toString());
		preparedStatement.setString(2, newCustomer.get("name").toString());
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//		java.util.Date date =  sdf.parse(newCustomer.get("birthdate").toString());
//		java.sql.Date sql = new java.sql.Date(date.getTime());


		preparedStatement.setDate(3, getSQLDate(newCustomer.get("birthdate").toString()) );
		
		PreparedStatement airlinePreparedStatement = connection.prepareStatement("SELECT * FROM airlines WHERE name = ?");
		airlinePreparedStatement.setString(1,newCustomer.get("frequentflieron").toString());
		ResultSet rs = airlinePreparedStatement.executeQuery();
		String abreviation = null;
		while(rs.next()){
			abreviation = rs.getString(1);
		}
		preparedStatement.setString(4, abreviation);
		// execute insert SQL stetement
		preparedStatement .executeUpdate();
		

	}

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");
        //Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/flightsskewed","vagrant", "vagrant");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
            return;
        }

        
		System.out.println("Welcome, please type in input: ");
		Scanner in_scanner = new Scanner(System.in);



		while(in_scanner.hasNext()) {
			String json = in_scanner.nextLine();
			processJSON(json);
		}



	}
}

