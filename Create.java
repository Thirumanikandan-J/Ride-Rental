import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class Create{
    static final String DB_URL = "jdbc:mysql://localhost:3306/Cars";
    static final String USER = "root";
    static final String PASS = "Thiru@2004";
    public static void main(String[] args){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating database...");
            stmt=conn.createStatement();
            String sql="CREATE DATABASE IF NOT EXISTS Car";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
            sql="USE Car";
            stmt.executeUpdate(sql);
            System.out.println("Using Car database...");
            System.out.println("Creating table in given database...");
            sql="CREATE TABLE IF NOT EXISTS RideRentals ("+"RentalID INT AUTO_INCREMENT PRIMARY KEY, "+"RideType VARCHAR(50), "+"RentalDuration INT, "+"CustomerName VARCHAR(100), "+"RentalDate DATE, "+"RentalCost DECIMAL(10, 2)"+")";
            stmt.executeUpdate(sql);
            System.out.println("Table RideRentals created successfully...");
            System.out.println("Inserting records into the table...");
            sql="INSERT INTO RideRentals (RideType, RentalDuration, CustomerName, RentalDate, RentalCost) "+"VALUES "+"('Harley Davidson', 2, 'Sri Dharshan', '2024-08-20', 25.50), "+"('Mountain Bike', 4, 'Thirumanikandan', '2024-08-19', 40.00), "+"('BMW', 1, 'Gowtham', '2024-08-20', 15.00)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            System.out.println("Updating records in the table...");
            sql="UPDATE RideRentals "+"SET RentalCost = 30.00 "+"WHERE RentalID = 1";
            stmt.executeUpdate(sql);
            System.out.println("Updated records in the table...");
            System.out.println("Deleting records from the table...");
            sql="DELETE FROM RideRentals "+"WHERE RentalID = 3";
            stmt.executeUpdate(sql);
            System.out.println("Deleted records from the table...");
            System.out.println("Retrieving data from the table...");
            sql="SELECT * FROM RideRentals";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("RentalID: "+rs.getInt("RentalID")+", RideType: " + rs.getString("RideType")+", RentalDuration: " + rs.getInt("RentalDuration")+", CustomerName: " + rs.getString("CustomerName")+", RentalDate: " + rs.getDate("RentalDate")+", RentalCost: " + rs.getBigDecimal("RentalCost"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(stmt!=null) stmt.close();
            }
            catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
