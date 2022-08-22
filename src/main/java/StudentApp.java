import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class StudentApp {
	
	private static Scanner scan;
	
	public static void main(String[] args) {
		String sqlSelectAllPersons = "SELECT * FROM students";
		String connectionUrl = "jdbc:mysql://localhost:3306/students?serverTimezone=UTC";
		List<Person> people = new LinkedList<Person>();
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl, "root", "password"); 
		    PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons); 
		    ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            String name = rs.getString("Imie");
		            String lastName = rs.getString("Nazwisko");
		            int salary = rs.getInt("Pensja");
		            
		            Person person = new Person(name,lastName,salary);
		           
		        	people.add(person);
		        	
		        	
		        	
		            
		        }
		} catch (SQLException e) {
		   System.out.println("Baza nie istnieje");
		}

		printList(people);
		people.remove(3);
		System.out.println(people);
		
	
		
	}
	private static void printOptions() {
		// TODO Auto-generated method stub
		
	}
	private static void printList(List<Person> list ) {
		for (Person element: list) {
			System.out.println(element);
		}
	}

}
