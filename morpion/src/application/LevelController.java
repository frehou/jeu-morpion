package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import ai.ConfigFileLoader;
import ai.Coup;
import ai.Test;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

import ai.ConfigFileLoader;
import ai.Coup;
import ai.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LevelController {

    @FXML
    private Button facile;

    @FXML
    private Button difficile;

    @FXML
    private Button moyen;
    
    @FXML
    private Button back;



    @FXML
    private void facileClick() {
        try {
        	int size = 0;
        	double learningRate = 0.0;
        	int hiddenLayers=0;
            BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
            String configLine;
            while ((configLine = configReader.readLine()) != null) {
                String[] configValues = configLine.split(":");
                if (configValues.length >= 4 && configValues[0].equals("F")) {
                     size = Integer.parseInt(configValues[1]);
                     learningRate = Double.parseDouble(configValues[2]);
                     hiddenLayers = Integer.parseInt(configValues[3]);
                }
            }
            configReader.close();
            String fileName = "model_" + size + "_" + learningRate + "_" + hiddenLayers + ".srl";
            System.out.println(fileName);

     
            File modelsDirectory = new File("models");
            File[] modelFiles = modelsDirectory.listFiles();
            boolean modelExists = false;

            if (modelFiles != null) {
                for (File modelFile : modelFiles) {
                	 System.out.println(modelFile.getName());
                    if (modelFile.getName().equals(fileName)) {
                        modelExists = true;
                        System.out.println(modelExists);
                        break;
                    }
                }
            }

            if (!modelExists) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/model.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) facile.getScene().getWindow();
                modelController modelController = loader.getController();
                modelController.setPar(learningRate,size,hiddenLayers);
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameAI.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) facile.getScene().getWindow();
                GameAiController gameAiController = loader.getController();
                gameAiController.setPar(learningRate,size,hiddenLayers);
                stage.setTitle("GameAI");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void moyenClick() {
        try {
        	int size = 0;
        	double learningRate = 0.0;
        	int hiddenLayers=0;
            BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
            String configLine;

            while ((configLine = configReader.readLine()) != null) {
                String[] configValues = configLine.split(":");
                if (configValues.length >= 4 && configValues[0].equals("M")) {
                     size = Integer.parseInt(configValues[1]);
                     learningRate = Double.parseDouble(configValues[2]);
                     hiddenLayers = Integer.parseInt(configValues[3]);
                }
            }
            configReader.close();


            String fileName = "model_" + size + "_" + learningRate + "_" + hiddenLayers + ".srl";
            System.out.println(fileName);


            File modelsDirectory = new File("models");
            File[] modelFiles = modelsDirectory.listFiles();
            boolean modelExists = false;

            if (modelFiles != null) {
                for (File modelFile : modelFiles) {
                	 System.out.println(modelFile.getName());
                    if (modelFile.getName().equals(fileName)) {
                        modelExists = true;
                        System.out.println(modelExists);
                        break;
                    }
                }
            }

            if (!modelExists) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/model.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) moyen.getScene().getWindow();
                modelController modelController = loader.getController();
                modelController.setPar(learningRate,size,hiddenLayers);
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameAI.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) moyen.getScene().getWindow();
                GameAiController gameAiController = loader.getController();
                gameAiController.setPar(learningRate,size,hiddenLayers);
                stage.setTitle("GameAI");
                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void dificileClick() {
    	try {
        	int size = 0;
        	double learningRate = 0.0;
        	int hiddenLayers=0;
            BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
            String configLine;

            while ((configLine = configReader.readLine()) != null) {
                String[] configValues = configLine.split(":");
                if (configValues.length >= 4 && configValues[0].equals("D")) {
                     size = Integer.parseInt(configValues[1]);
                     learningRate = Double.parseDouble(configValues[2]);
                     hiddenLayers = Integer.parseInt(configValues[3]);
                }
            }
            configReader.close();

            String fileName = "model_" + size + "_" + learningRate + "_" + hiddenLayers + ".srl";
            System.out.println(fileName);


            File modelsDirectory = new File("models");
            File[] modelFiles = modelsDirectory.listFiles();
            boolean modelExists = false;

            if (modelFiles != null) {
                for (File modelFile : modelFiles) {
                	 System.out.println(modelFile.getName());
                    if (modelFile.getName().equals(fileName)) {
                        modelExists = true;
                        System.out.println(modelExists);
                        break;
                    }
                }
            }

            if (!modelExists) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/model.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) difficile.getScene().getWindow();
                modelController modelController = loader.getController();
                modelController.setPar(learningRate,size,hiddenLayers);
                stage.setTitle("Model");
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameAI.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) difficile.getScene().getWindow();
                GameAiController gameAiController = loader.getController();
                gameAiController.setPar(learningRate,size,hiddenLayers);
                stage.setTitle("GameAI");
                stage.setScene(new Scene(root));
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    private void funBack() {
    	try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menubarv2.fxml"));
	        Parent root = loader.load();
	        Stage stage = (Stage) back.getScene().getWindow();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Home");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }


}