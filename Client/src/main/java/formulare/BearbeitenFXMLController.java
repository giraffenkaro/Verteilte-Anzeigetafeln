/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulare;

import database.objects.Message;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laura
 */
public class BearbeitenFXMLController implements Initializable {

    @FXML private Label lAnzeigeTafel;
    @FXML private TextArea taNachricht;
    @FXML private Button bAbbrechen;
    @FXML private Button bSpeichern;
    private Message m;

    public Message getM() {
        return m;
    }

    public void setM(Message m) {
        this.m = m;
    }
    
   
    
    @FXML 
    private void speichern()
    {
        
    }
        
    private void editLabelText()
    {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bAbbrechen.setCancelButton(true);
        editLabelText();
    }    
    
}
