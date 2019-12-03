package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectDB {

    public static String url;

    //contructor của hàm kết nối ConnectDB
    public ConnectDB() {
        super();
        url = "jdbc:sqlserver://localhost:1433;databaseName=POLY_EXAM;user=sa;password=123";

    }

    //Đường dãn tới SQL
    public static Connection connect() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connect = DriverManager.getConnection(url);
            return connect;

        } catch (Exception e) {
            System.out.println("loi 1: " + e.getMessage());
        }
        return null;
    }

    //hàm thực thi câu lệnh update SQL
    public void UpdateSQL(String sql) throws Exception {
        try {
            Connection connect = connect();
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Lỗi 2" + e);
        }
    }

    //Hàm chạy câu lệnh select SQL
    public ResultSet querySQL(String sql) throws SQLException, Exception {
        try {
            Connection connect = connect();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println("Lỗi 3" + e);
            return null;
        }
    }

    public PreparedStatement dungStament(String sql) throws SQLException, Exception {
        return connect().prepareStatement(sql);
    }

//    //Function connect()
//    public Connection connect() {
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection(url);
//            return con;
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi kết nối database tại hàm connect: " + e);
//            return null;
//        }
//    }
//
//    //Function Statement
//    public Statement StatementSQL(String sql) {
//
//        try {
//            Connection con = this.connect();
//            return con.prepareStatement(sql);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi kết nối tại hàm Statement 2:" + e);
//            return null;
//        }
//    }
//
//    //Hàm thực thi sql
//    public ResultSet SqlQuery(String sql) {
//        try {
//            Connection connect = this.connect();
//            Statement stm = connect.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
//            return rs;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi tại hàm SqlQuery: " + e);
//            return null;
//        }
//    }
}
