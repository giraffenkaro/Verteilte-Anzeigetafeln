/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anzeigetafel;

import database.objects.Message;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Laura
 */
public class AnzeigetafelFXMLController implements Initializable {
    
    @FXML
    private VBox vbox;
    
    @FXML
    private ScrollPane scrollpane;
    
    @FXML
    private HBox hbox;
    
    @FXML
    private Label lTafel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ArrayList<Nachrichtenbox> c = new ArrayList();
        
        for(int i = 0; i < 100; i++)
        {
            c.add(new Nachrichtenbox());
        }

        
        vbox.getChildren().addAll(c);
        
        scrollpane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollpane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        scrollpane.setFitToHeight(true);
        scrollpane.setFitToWidth(true);
        

        
      /*  for(int i = 0; i < 100; i++)
        {
             vbox.getChildren().add(new Nachrichtenbox());
             vbox.getChildren().addAll(c);
             //Abstand erhoehen
             vbox.getChildren().get(i).setStyle("-fx-padding: 4 4 4 4");
             
        }
       */
        
    }    
    
}
