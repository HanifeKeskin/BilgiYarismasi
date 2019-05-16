/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgiyarismasi2;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class FXMLDocumentController implements Initializable {
    
    BilgiYarismasi2 by = new BilgiYarismasi2();
    java.util.List s = by.isim();
    int control = 0;
    int control1 = 0;
    int control2 = 0;
    int i = 7;
    int cevap = 5;
    int puan = 0;
    int soruControl = 0;
    
    @FXML
    private AnchorPane panel;
        
    @FXML
    private Button btnAClick;

    @FXML
    private Button btnBClick;

    @FXML
    private Button btnCClick;

    @FXML
    private Button btnDClick;
    
    @FXML
    private Button btnNext;
    
    @FXML
    private Button btnYeniden;

    @FXML
    private Label lbl;
    
    @FXML
    private Label lblPuan;
    
    @FXML
    private ImageView img;
    
    @FXML
    void ClickNext(ActionEvent event) {
        soru();
        btnAClick.setStyle("-fx-background-color: #ffffff; "); 
        btnBClick.setStyle("-fx-background-color: #ffffff; "); 
        btnCClick.setStyle("-fx-background-color: #ffffff; "); 
        btnDClick.setStyle("-fx-background-color: #ffffff; ");
        
        
    }

    @FXML
    void ClickA(ActionEvent event) {
        if(control1 == 0){
            if("A".equals(s.get(cevap).toString())){
            btnAClick.setStyle("-fx-background-color: #71d848; ");
            puan += 10;
            lblPuan.setText("Puan:"+puan);
        }else{
            btnAClick.setStyle("-fx-background-color: #d42d2d; ");
            if("B".equals(s.get(cevap).toString())){
                btnBClick.setStyle("-fx-background-color: #71d848; ");
                
            }else if("C".equals(s.get(cevap).toString())){
                btnCClick.setStyle("-fx-background-color: #71d848; ");

            }else if("D".equals(s.get(cevap).toString())){
                btnDClick.setStyle("-fx-background-color: #71d848; ");
            }
        }
            control = 0;
            control1 = 1;
        }
    }
    
    @FXML
    void ClickB(ActionEvent event) {
        if(control1 == 0)
        {
        if("B".equals(s.get(cevap).toString())){
            btnBClick.setStyle("-fx-background-color: #71d848; ");
            puan += 10;
            lblPuan.setText("Puan:"+puan);
        }else{
            btnBClick.setStyle("-fx-background-color: #d42d2d; ");
            if("A".equals(s.get(cevap).toString())){
                btnAClick.setStyle("-fx-background-color: #71d848; ");

            }else if("C".equals(s.get(cevap).toString())){
                btnCClick.setStyle("-fx-background-color: #71d848; ");

            }else if("D".equals(s.get(cevap).toString())){
                btnDClick.setStyle("-fx-background-color: #71d848; ");
            }
            
        }
        control = 0;
        control1 = 1;
        }
        
    }

    @FXML
    void ClickC(ActionEvent event) {
        if (control1 == 0)
        {
        if("C".equals(s.get(cevap).toString())){
            btnCClick.setStyle("-fx-background-color: #71d848; ");
            puan += 10;
            lblPuan.setText("Puan:"+puan);
        }else{
            btnCClick.setStyle("-fx-background-color: #d42d2d; ");
            if("B".equals(s.get(cevap).toString())){
                btnBClick.setStyle("-fx-background-color: #71d848; ");
            }else if("A".equals(s.get(cevap).toString())){
                btnAClick.setStyle("-fx-background-color: #71d848; ");
            }else if("D".equals(s.get(cevap).toString())){
                btnDClick.setStyle("-fx-background-color: #71d848; ");
            }           
        }
        control = 0;
        control1 = 1;
        }
    }

    @FXML
    void ClickD(ActionEvent event) {
        if(control1 == 0){
        if("D".equals(s.get(cevap).toString())){
            btnDClick.setStyle("-fx-background-color: #71d848; ");
            puan += 10;
            lblPuan.setText("Puan:"+puan);
        }else{
            btnDClick.setStyle("-fx-background-color: #d42d2d; ");
            if("B".equals(s.get(cevap).toString())){
                btnBClick.setStyle("-fx-background-color: #71d848; ");
            }else if("C".equals(s.get(cevap).toString())){
                btnCClick.setStyle("-fx-background-color: #71d848; ");
            }else if("A".equals(s.get(cevap).toString())){
                btnAClick.setStyle("-fx-background-color: #71d848; ");
            }       
        }
        control1 = 1;
        control = 0; 
        }
}
    
    @FXML
    void ClickYeniden(ActionEvent event) {
        soruControl += 70;
        if(s.size() != soruControl){
            puan = 0;
        lblPuan.setText("Puan:"+ Integer.toString(puan));
        btnAClick.setDisable(false);
        btnBClick.setDisable(false);
        btnCClick.setDisable(false);
        btnDClick.setDisable(false);
        btnYeniden.setVisible(false);
        soru();
        }
        else{
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Soru Bitti");
        alert.setHeaderText("Soru Bitti!!!");
        alert.setContentText("Lütfen yeni sorular gelince tekrar deneyin!!!");
        alert.showAndWait();
        System.exit(0);
        }
    }
    
    
    public void soru(){        
        while(i<soruControl + 70 && control == 0){
        lbl.setText(s.get(i).toString());     
        btnAClick.setText(s.get(i+1).toString());
        btnBClick.setText(s.get(i+2).toString());
        btnCClick.setText(s.get(i+3).toString());
        btnDClick.setText(s.get(i+4).toString());
        
        if(!"yok".equals(s.get(i+6).toString()))
        {
            System.out.println(s.get(i+6).toString());
            Image img1 = new Image("file:saat-kulesi.jpg");
            img.setImage(img1);
        }
        
        else{
            img.setImage(null);
        }
        
        control = 1;
        control2 = 1;
        }
        control1 = 0;
        if(i== soruControl+70){
        btnYeniden.setVisible(true);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Oyun Sonu");
        alert.setHeaderText("Oyun Bitti!!!");
        alert.setContentText("Puanınız:"+puan);

        alert.showAndWait();
        
        btnAClick.setDisable(true);
        btnBClick.setDisable(true);
        btnCClick.setDisable(true);
        btnDClick.setDisable(true);
        }
        if (control2 == 1){
        i += 7;
        cevap += 7;
        control2 = 0;
        }
        
        
 }
                    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAClick.setStyle("-fx-background-color: #ffffff; ");
        btnBClick.setStyle("-fx-background-color: #ffffff; ");
        btnCClick.setStyle("-fx-background-color: #ffffff; ");
        btnDClick.setStyle("-fx-background-color: #ffffff; ");
        btnNext.setStyle("-fx-background-color: #ffffff; ");
        lbl.setText(s.get(0).toString());     
        btnAClick.setText(s.get(1).toString());
        btnBClick.setText(s.get(2).toString());
        btnCClick.setText(s.get(3).toString());
        btnDClick.setText(s.get(4).toString());
        btnYeniden.setVisible(false);
        
    } 
    
}