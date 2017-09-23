/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guivs;

import classes.GUIVS;
import classes.PopUpMessage;
import database.objects.Board;
import database.objects.Group;
import database.objects.Message;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

   // private ArrayList<ChoiceBox <KeyValuePair > > cbEntries;
    //Immer sichtbar in Navigation
    @FXML private Button bNeueNachricht;
    @FXML private Button bBearbeiten;
    @FXML private Button bLoeschen;
    @FXML private ChoiceBox cbAnzeigetafel;
    @FXML private Button bAnzeigetafel;
    
    //Tabelle
    @FXML private TableView<Message> tTabelle;
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
            GUIVS.bearbeiteNachricht((Message) tTabelle.getSelectionModel().getSelectedItem());
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
        //Wenn ich Moderator bin, dann
        if (GUIVS.instance.getMe().getLevel() == 1 && GUIVS.instance.isMod()) {
            //schalte Adminfunktionen ab
            bAnzeigetafelAnlegen.setDisable(true);
            bAnzeigetafelBearbeiten.setDisable(true);
            bUserAnlegen.setDisable(true);
            bUserBearbeiten.setDisable(true);
            bGruppeAnlegen.setDisable(true);
            miNeueAnzeigetafel.setDisable(true);
            miAnzeigetafelBearbeiten.setDisable(true);
            miNeuerUser.setDisable(true);
            miUserBearbeiten.setDisable(true);
            miNeueGruppe.setDisable(true);

            //und
            try {
                int i = 0;
                //Für alle Gruppen
                for (Group g : GUIVS.instance.getControl().getC().getGroups()) {
                    //Überprüfe, ob ich Member der Gruppe bin
                    if (g.equals(GUIVS.instance.getControl().getC().getGroupsByUser(GUIVS.instance.getMe()))) {
                        //Wenn ja, füge ein MenuItem mit dem Gruppennamen hinzu
                        mAnzeigetafel.getItems().add(new MenuItem(g.getName()));
                       
                        //cbAnzeigetafel.getItems().add(new )
                        //und registriere einen Eventhandler für dieses Item
                        mAnzeigetafel.getItems().get(i).setOnAction(new EventHandler<ActionEvent>() {

                            //,der eine Anzeigetafel für diese Gruppe instanziiert
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    Group g = GUIVS.instance.getControl().getC().getGroupByName(((MenuItem) (event.getSource())).getText());
                                    GUIVS.oeffneAnzeigetafel(g, GUIVS.instance.getControl().getC().getMessagesByGroup(g));
                                } catch (Exception e) {
                                    pm.showError("Exception", e.toString());
                                }
                            }
                        });
                        //Für Index bei getItems().get(i)
                        i++;
                    }
                }
            } catch (Exception e) {
                pm.showError("Exception", e.toString());
            }
        }
        else //ansonsten bin ich Admin
        {
            try {
                int i = 0;
                //Für alle Gruppen
                for (Group g : GUIVS.instance.getControl().getC().getGroups()) {
                    //füge ein MenuItem mit dem Gruppennamen hinzu
                    mAnzeigetafel.getItems().add(new MenuItem(g.getName()));
                    //und registriere einen Eventhandler für dieses Item
                    mAnzeigetafel.getItems().get(i).setOnAction(new EventHandler<ActionEvent>() {

                        //,der eine Anzeigetafel für diese Gruppe instanziiert
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                Group g = GUIVS.instance.getControl().getC().getGroupByName(((MenuItem) (event.getSource())).getText());
                                GUIVS.oeffneAnzeigetafel(g, GUIVS.instance.getControl().getC().getMessagesByGroup(g));
                            } catch (Exception e) {
                                pm.showError("Exception", e.toString());
                            }
                        }
                    });
                    //Für Index bei getItems().get(i)
                    i++;
                }
            } catch (Exception e) {
                pm.showError("Exception", e.toString());
            }
        }
    }
}
