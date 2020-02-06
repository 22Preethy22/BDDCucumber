package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		//db url details
		String dburl="jdbc:mysql://localhost:3306/sakila";
		String uname="username";
		String pwd="password";
		String Query="Select * from DBNAME;";
		

		//API for connecting the database
		Class.forName("com.mysql.jdbc.Driver");

     	Connection con = DriverManager.getConnection(dburl, uname, pwd);

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(Query);

		 if(rs.next()==false)
		   {
		   	System.out.println("Empty Row");
		   }
		   else
		   {
		   	while(rs.next())
		   	{
		   	rs.getString(0);
		   	rs.getString("username");
		   	}
		   }
		   con.close();

	}
}
