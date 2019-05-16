/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgiyarismasi2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.util.*; 
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;

/**
 *
 * @author Tugay
 */
public class BilgiYarismasi2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root,Color.BLACK);
        
        stage.setScene(scene); 
        
        stage.setMinHeight(650);
        stage.setMaxHeight(650);
        stage.setMaxWidth(450);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public List isim(){
        Connection c = null;
        Statement stmt = null;
        
        try{
            c = DriverManager.getConnection("jdbc:sqlite:bilgiyarismasi.db");
            System.out.println("SQLİTE DB CONNECTED");
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM soru;" );
            List<String> arrList = new ArrayList<String>();
            
            
            while(rs.next()){
            int id = rs.getInt("id");
            String Soru = rs.getString("Soru");
            String A  = rs.getString("A");
            String B  = rs.getString("B");
            String C  = rs.getString("C");
            String D  = rs.getString("D");
            String Cevap = rs.getString("Cevap");
            String Resim = rs.getString("Resim");
            
            
            arrList.add(Soru);
            arrList.add(A);
            arrList.add(B);
            arrList.add(C);
            arrList.add(D);
            arrList.add(Cevap);
            arrList.add(Resim);
            }
            
            rs.close();
            stmt.close();
            c.close();
            
            return arrList;
                    
        }catch(Exception e){
            System.out.println("hatalı sql");
            System.out.println(e);
            
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

        
    
    public static void main(String[] args) {
        launch(args);
    
    }
     
}
