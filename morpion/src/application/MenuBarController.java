package application;

import ai.ConfigFileLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuBarController {
    @FXML
    MenuItem config;

    @FXML
    MenuItem models;
    
    @FXML
    private Button ai;
    
    @FXML
    private Button human;
    
    private ConfigFileLoader configFileLoader;

    public MenuBarController() {
        configFileLoader = new ConfigFileLoader();
    }

    @FXML
    private void handleConfigMenuItemClick() {

        configFileLoader.loadConfigFile("config.txt");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/lireConfig.fxml"));
            Parent root = loader.load();

            ConfigController configController = loader.getController();
            configController.setConfigFileLoader(configFileLoader);
            configController.displayConfig("F","M","D");

            Stage stage = new Stage();
            stage.setTitle("Lire Config");
            stage.setScene(new Scene(root));
            configController.setStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void aiClick() {
    	 try {
    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/level.fxml"));
    	        Parent root = loader.load();

    	        
    	        Stage stage = (Stage) human.getScene().getWindow();

    	       
    	        stage.setScene(new Scene(root));
    	        stage.setTitle("Level");
    	        stage.show();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }
    
    
    @FXML
    private void humanClick() {
    	 try {
    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/choixDeNom.fxml"));
    	        Parent root = loader.load();
    	        Stage stage = (Stage) ai.getScene().getWindow();
    	        stage.setScene(new Scene(root));
    	        stage.setTitle("Saisir les noms");
    	        stage.show();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }

    @FXML
    private void model() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/repmodel.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Repmodel");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
