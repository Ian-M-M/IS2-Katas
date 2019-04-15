package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class Main {
    
    private Connection connect() {
        
        String url = "jdbc:sqlite:KATA5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t" +
                                rs.getString("Name") + "\t" +
                                rs.getString("Apellido") + "\t" +
                                rs.getString("Departamento") + "\t");    
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createTable() {
        
        String query = "CREATE TABLE IF NOT EXISTS EMAIL (ID INTEGER PRIMARY KEY AUTOINCREMENT,MAIL TEXT NOT NULL);";
        
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void fillTable(){
        String path = "./mails.txt";
        List<String> emails = MailListReader.read(path);
        try {
            String insert = "INSERT INTO EMAIL(Mail) VALUES(?)";
            Connection conn = this.connect();
            PreparedStatement pstmt= conn.prepareStatement(insert);
            for (String email : emails) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        Main app = new Main();
        //app.selectAll();
        //app.createTable();
        app.fillTable();
    }
}