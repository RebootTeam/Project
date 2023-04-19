package profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBConnPool;

public class ProfileDAO {
            
       private Connection conn;
       private PreparedStatement pstmt;
       private ResultSet rs;

       public ProfileDAO() {
           try {
               String dbURL = "jdbc:oracle://localhost:1521/XE";
               String dbID = "Reboot";
               String dbPassword = "1234";
               Class.forName("oracle.jdbc.driver.OracleDriver");
               conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       public ProfileDTO getMember(String id) {
           String SQL = "SELECT * FROM INFO WHERE id = ?";
           try {
               pstmt = conn.prepareStatement(SQL);
               pstmt.setString(1, id);
               rs = pstmt.executeQuery();
               if (rs.next()) {
                  ProfileDTO pdto = new ProfileDTO();
                  pdto.setId(rs.getString("id"));
                  pdto.setName(rs.getString("name"));
                  pdto.setPassword(rs.getString("password"));
                  pdto.setAd(rs.getString("ad"));
                  pdto.setPnum(rs.getInt("pnum"));
                  pdto.setIn_d(rs.getDate("in_d"));
                  pdto.setOut_d(rs.getDate("out_d"));
                  pdto.setBday(rs.getDate("bday"));
                  pdto.setGrade(rs.getInt("grade"));
                  pdto.setDeptn(rs.getInt("deptn"));
                   return pdto;
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return null;
       }
   }
   
   
   
   
   
   
   
   
   

