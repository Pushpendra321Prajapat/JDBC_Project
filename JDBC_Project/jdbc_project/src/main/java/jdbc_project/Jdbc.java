package jdbc_project;
import java.sql.*;

public class Jdbc {
	static String url = "jdbc:mysql://127.0.0.1:3306/coffee_store";
	static String username = "Pushpendra Prajapat";
	static String password = "Pu@21-06-2002";
	public static void main(String args[]){
		
		System.out.println("id" +"  "+ "first_name" + "   " + "last_name" + "   " + "gender" + "   " +"phone_number");
		System.out.println("-----------------------------------------------------------");
		
		fetching_data();
		
		insertingInDatabase();
		System.out.println("\t\t INSERTING DATA \n\n");
		fetching_data();		

		updateDatabase();
		System.out.println("\t\t UPDATING DATA \n\n");
		fetching_data();
		
		deleteData();
		System.out.println("\t\t DELETING DATA \n\n");
		fetching_data();
	 
 }
	public static void fetching_data() {
		String quary = "select * from customer";
		
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(url, username, password);  
  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(quary);  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"    "+rs.getString(4)+ "    "+rs.getString(5)); 
		stmt.close();
		con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		} 
	}
	
	public static void insertingInDatabase() {
		String quary1 = "insert into customer values (25, 'Gopal', 'Singh', 'M', '08297289274')";
		String quary2 = "insert into customer values (26, 'Prince', 'Kumar', 'M', '08399766365')";
		String quary3 = "insert into customer values (27, 'Pranay', 'deep', 'M', '0828683r587')";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			
			int rs = stmt.executeUpdate(quary1);
			 rs = stmt.executeUpdate(quary2);
			 rs = stmt.executeUpdate(quary3);
			System.out.println("\n\n **************************************************** \n\n");
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateDatabase() {
		String quary1 = "update customer set first_name = 'KIRAN' where id = 25";
		String quary2 = "update customer set first_name = 'SUSHANT' where id = 26";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			
			int rs = stmt.executeUpdate(quary1);
			
			rs = stmt.executeUpdate(quary2);
			System.out.println("\n\n **************************************************** \n\n");
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteData() {
		String quary1 = "delete from customer where id = 25";
		String quary2 = "delete from customer where id = 26";
		String quary3 = "delete from customer where id = 27";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			
			int rs = stmt.executeUpdate(quary1);
			rs = stmt.executeUpdate(quary2);
			rs = stmt.executeUpdate(quary3);
			System.out.println("\n\n **************************************************** \n\n");
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
