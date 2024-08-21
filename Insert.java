import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Insert{
    static final String DB_URL="jdbc:mysql://localhost:3306/Cars";
    static final String USER="root";
    static final String PASS="Thiru@2004";
    public static void main(String[] args){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the Car database...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="INSERT INTO RideRentals (RideType, RentalDuration, CustomerName, RentalDate, RentalCost) "+"VALUES (?, ?, ?, ?, ?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"Harley Davidson");
            pstmt.setInt(2,2);
            pstmt.setString(3,"Sri Dharshan");
            pstmt.setDate(4,java.sql.Date.valueOf("2024-08-20"));
            pstmt.setBigDecimal(5,new java.math.BigDecimal("25.50"));
            pstmt.executeUpdate();
            pstmt.setString(1,"Mountain Bike");
            pstmt.setInt(2,4);
            pstmt.setString(3,"Thirumanikandan");
            pstmt.setDate(4,java.sql.Date.valueOf("2024-08-19"));
            pstmt.setBigDecimal(5,new java.math.BigDecimal("40.00"));
            pstmt.executeUpdate();
            pstmt.setString(1,"BMW");
            pstmt.setInt(2,1);
            pstmt.setString(3,"Gowtham");
            pstmt.setDate(4,java.sql.Date.valueOf("2024-08-20"));
            pstmt.setBigDecimal(5,new java.math.BigDecimal("15.00"));
            pstmt.executeUpdate();
            System.out.println("Records inserted successfully into RideRentals table...");
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(pstmt!=null)pstmt.close();
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
