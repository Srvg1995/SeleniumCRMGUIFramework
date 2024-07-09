package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryTestWithTryCatchFinally {

	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
			//step1:Load / register the database driver
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);

			//step2:Connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("=====Done======");

			//step3:create sql statement(writing Query)
			Statement stat = conn.createStatement();

			//step4:execute select query & get result
			ResultSet resultset = stat.executeQuery("select * from project123");
			while(resultset.next())
			{
				System.out.println(resultset.getString(1)+" "+ resultset.getString(2)+" "+ resultset.getString(3)+" " +resultset.getString(4)+" " +resultset.getString(5)+" " +resultset.getInt(6));
			}
		}catch (Exception e) {
			System.out.println("handle exception");			
		}finally {
			//step5:close the connection
			conn.close();
			System.out.println("====close the connection=======");

		}
	}
}