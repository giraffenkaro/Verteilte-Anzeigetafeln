/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class PopUpMessage {
    
    
    public void showInformation(String title, String text)
    {
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setContentText(text);
        alert.showAndWait();
    }
    
      public void showError(String title, String text)
    {
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setContentText(text);
        alert.showAndWait();
    }
      
      public boolean showDialog(String question)
      {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Achtung!");
        alert.setHeaderText("");
        alert.setContentText(question);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK; 

      }
}
