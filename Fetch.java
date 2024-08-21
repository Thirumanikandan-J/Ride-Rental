import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class Fetch{
    static final String DB_URL="jdbc:mysql://localhost:3306/Cars";
    static final String USER="root";
    static final String PASS="Thiru@2004";
    public static void main(String[] args){
        Connection conn=null;
        Statement stmt=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the Car database...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Fetching data from RideRentals table...");
            stmt=conn.createStatement();
            String sql="SELECT * FROM RideRentals";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int rentalID=rs.getInt("RentalID");
                String rideType=rs.getString("RideType");
                int rentalDuration=rs.getInt("RentalDuration");
                String customerName=rs.getString("CustomerName");
                java.sql.Date rentalDate=rs.getDate("RentalDate");
                java.math.BigDecimal rentalCost=rs.getBigDecimal("RentalCost");
                System.out.println("RentalID: "+rentalID);
                System.out.println("RideType: "+rideType);
                System.out.println("RentalDuration: "+rentalDuration+" hours");
                System.out.println("CustomerName: "+customerName);
                System.out.println("RentalDate: "+rentalDate);
                System.out.println("RentalCost: $"+rentalCost);
                System.out.println("-----------------------------");
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
                if(stmt!=null)stmt.close();
            }
            catch(SQLException se2){
            }
            try{
                if(conn!=null)conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
