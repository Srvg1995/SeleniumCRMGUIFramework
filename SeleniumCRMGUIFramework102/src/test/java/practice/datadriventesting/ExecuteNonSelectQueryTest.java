package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		//step1:Load / register the database driver
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//step2:Connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				System.out.println("=====Done======");
				
				//step3:create sql statement(writing Query)
				Statement stat = conn.createStatement();
				
				//step4:execute select query & get result
			       int res = stat.executeUpdate("insert into project values('TY_2000','Deepak','04/27/2023','FB_01','On Going','100')");
				System.out.println(res);
				//step5:close the connection
				conn.close();
	}

}
