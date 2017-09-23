/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guivs;

import classes.GUIVS;
import classes.PopUpMessage;
import classes.Control;
import exceptions.EmptyStringException;
import exceptions.IllegalPermissionLevelException;
import exceptions.IllegalCharacterException;
import exceptions.NoUserFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class loginFXMLController implements Initializable {
    
    
    @FXML
    private TextField tfUsername;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private Button bLogin;
    
    @FXML
    private void login()
    {
        
        PopUpMessage pm = new PopUpMessage();
        try
        {
            Control.isLegit(tfUsername.getText());
            Control.isLegit(pfPassword.getText());
            Stage stage = (Stage) bLogin.getScene().getWindow();
            stage.close();
            System.out.println(GUIVS.instance.control.getC().test(14));
           /*
            GUIVS.userAnsicht();
            
            
            
            GUIVS.instance.setMe
            (
                    //TODO Client.login gibt userobjekt zurück
                GUIVS.instance.control.getC().loginUser(tfUsername.getText(),pfPassword.getText())
                    
            );
            
            if(GUIVS.instance.getMe() == null)
            {
                throw new NoUserFoundException();
            }
            
            if(GUIVS.instance.getMe().getLevel() == 1)
            {
                //TODO: öffne Useransicht
                GUIVS.userAnsicht();
            }
            else if(GUIVS.instance.getMe().getLevel() == 2)
            {
                //TODO: öffne Adminansicht
                GUIVS.adminAnsicht();
            }
            else
            {
                throw new IllegalPermissionLevelException();
            }
    */
        }
        catch(IllegalCharacterException icex)
        {
            pm.showError("Error", "Eingaben dürfen weder ' noch ` enthalten");
        }
        catch(EmptyStringException esex)
        {
            pm.showError("Error", "Eingaben dürfen nicht leer sein!");
        }
        catch(NoUserFoundException nufex)
        {
            pm.showError("Error", "Username oder Passwort falsch!");
        }
        catch(Exception e)
        {
            pm.showError("Error", "Exception: " + e.toString());
        }
        finally
        {
            pm = null;
        }

    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
