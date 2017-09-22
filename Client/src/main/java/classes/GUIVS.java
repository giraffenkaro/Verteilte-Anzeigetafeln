/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import database.*;
import database.objects.*;
import javafx.stage.Modality;

/**
 *
 * @author Laura
 */
public class GUIVS extends Application {
    
    public static GUIVS instance;
    public Control control;
    public GUIVS()
    {
            instance = this;
            control = new Control();
            
    }
    private User me = null;
    
    public void setMe(User me)
    {
        this.me = me;
    }
    public User getMe()
    {
        return this.me;
    }
    
    private static Stage previousStage;
    private static void setPreviousStage(Stage stage)
    {
        instance.previousStage = stage;
    }
    
    public static Stage getPreviousStage()
    {
        return instance.previousStage;
    }
    

    public static void neueNachricht() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GUIVS.class.getResource("/formulare/neueNachrichtFXML.fxml"));
        Parent p = loader.load();
        
        Scene vtScene = new Scene(p);
        Stage vtStage = new Stage();
        vtStage.setTitle("Neue Nachricht");
        vtStage.initOwner(previousStage);
        vtStage.initModality(Modality.WINDOW_MODAL);
        vtStage.setScene(vtScene);
        vtStage.setResizable(false);
        vtStage.showAndWait();
    }
    
     public static void bearbeiteNachricht() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GUIVS.class.getResource("/formulare/bearbeitenFXML.fxml"));
        Parent p = loader.load();
        
        Scene vtScene = new Scene(p);
        Stage vtStage = new Stage();
        vtStage.setTitle("Nachricht bearbeiten");
        vtStage.initOwner(previousStage);
        vtStage.initModality(Modality.WINDOW_MODAL);
        vtStage.setScene(vtScene);
        vtStage.setResizable(false);
        vtStage.showAndWait();
    }
    
    
    public static void userAnsicht() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GUIVS.class.getResource("/guivs/userAnsichtFXML.fxml"));
        Parent p = loader.load();
        
        Scene vtScene = new Scene(p);
        Stage vtStage = new Stage();
        setPreviousStage(vtStage);
        vtStage.setTitle("Ansicht für User");
        vtStage.setScene(vtScene);
        vtStage.setResizable(false);
        vtStage.showAndWait();
    }

        public static void adminAnsicht() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(GUIVS.class.getResource("/guivs/adminAnsichtFXML.fxml"));
        Parent p = loader.load();
        
        Scene vtScene = new Scene(p);
        Stage vtStage = new Stage();
        setPreviousStage(vtStage);
        vtStage.setTitle("Ansicht für Administratoren");
        vtStage.setScene(vtScene);
        vtStage.setResizable(false);
        vtStage.showAndWait();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/guivs/loginFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
