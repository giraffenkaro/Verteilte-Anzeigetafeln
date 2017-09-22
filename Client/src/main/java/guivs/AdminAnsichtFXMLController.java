/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guivs;

import classes.GUIVS;
import classes.PopUpMessage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laura
 */
public class AdminAnsichtFXMLController implements Initializable
{
    private PopUpMessage pm;

    //Immer sichtbar in Navigation
    @FXML private Button bNeueNachricht;
    @FXML private Button bBearbeiten;
    @FXML private Button bLoeschen;
    @FXML private ChoiceBox cbAnzeigetafel;
    @FXML private Button bAnzeigetafel;
    
    //Tabelle
    @FXML private TableView tTabelle;
    @FXML private TableColumn tcNachrichten;
    @FXML private TableColumn tcUser;
    
    //MenuBar
    
    //Datei...
    @FXML private MenuItem miAktualisieren;
    @FXML private Menu mAnzeigetafel;
    
    //Seperator...
    @FXML private MenuItem miAbmelden;
    @FXML private MenuItem miSchliessen;
 
    
    //Bearbeiten...
    @FXML private MenuItem miNeueNachricht;
    @FXML private MenuItem miBearbeiten;
    @FXML private MenuItem miLoeschen;
    
    //Seperator...
    @FXML private MenuItem miNeuerUser;
    @FXML private MenuItem miUserBearbeiten;
    
    //Seperator...
    @FXML private MenuItem miNeueGruppe;
    @FXML private MenuItem miGruppeBearbeiten;
    
    //Seperator...
    @FXML private MenuItem miNeueAnzeigetafel;
    @FXML private MenuItem miAnzeigetafelBearbeiten;
    
    
    //Hilfe...
    @FXML private MenuItem miAbout;
    

    
    //Acchordion
    //User...
    @FXML private Button bUserAnlegen;
    @FXML private Button bUserBearbeiten;
    
    //Gruppe...
    @FXML private Button bGruppeAnlegen;
    @FXML private Button bGruppeBearbeiten;
    
    //Anzeigetafel...
    @FXML private Button bAnzeigetafelAnlegen;
    @FXML private Button bAnzeigetafelBearbeiten;
    
    
 
    @FXML
    private void neueNachricht()
    {
        try{
          GUIVS.neueNachricht(); 
        }
        catch( Exception e){}
    }
    
    @FXML 
    private void bearbeiteNachricht()
    {
        try
        {
            GUIVS.bearbeiteNachricht();
        }
        catch(Exception e){} 
    }
    
    @FXML
    private void schliessen()
    {
        Stage stage = (Stage) tTabelle.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void loeschen()
    {
        pm.showDialog("Die ausgewählte Nachricht wird unwiderruflich gelöscht!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        pm = new PopUpMessage();
    }    
    
}
