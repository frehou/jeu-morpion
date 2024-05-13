package application;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;

import ai.MultiLayerPerceptron;

import ai.Coup;
import ai.SigmoidalTransferFunction;
import javafx.stage.Stage;


import javafx.application.Platform;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;

import ai.MultiLayerPerceptron;

import ai.Coup;
import ai.SigmoidalTransferFunction;
import javafx.stage.Stage;


public class modelController {

	@FXML
	TextField erreur;
	@FXML
	ProgressBar probar;
	@FXML
	Button Apprentissage;

	public  double learningRate;
	public  int si ;
	public  int  hiddenLayers;

	MultiLayerPerceptron net;

	public void setPar(double learningR,int si,int hid){
		this.learningRate=learningR;
		this.si=si;
		this.hiddenLayers=hid;
	}

	public static HashMap<Integer, Coup> loadCoupsFromFile(String file){
		System.out.println("loadCoupsFromFile from "+file+" ...");
		HashMap<Integer, Coup> map = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
			String s = "";
			while ((s = br.readLine()) != null) {
				String[] sIn = s.split("\t")[0].split(" ");
				String[] sOut = s.split("\t")[1].split(" ");

				double[] in = new double[sIn.length];
				double[] out = new double[sOut.length];

				for (int i = 0; i < sIn.length; i++) {
					in[i] = Double.parseDouble(sIn[i]);
				}

				for (int i = 0; i < sOut.length; i++) {
					out[i] = Double.parseDouble(sOut[i]);
				}

				Coup c = new Coup(9, "");
				c.in = in ;
				c.out = out ;
				map.put(map.size(), c);
			}
			br.close();
		}
		catch (Exception e) {
			System.out.println("Test.loadCoupsFromFile()");
			e.printStackTrace();
			System.exit(-1);
		}
		return map ;
	}

	public MultiLayerPerceptron learne(int size, HashMap<Integer, Coup> mapTrain, int h, double lr, int l, boolean verbose, double epochs){

		try {
			if ( verbose ) {
				System.out.println();
				System.out.println("START TRAINING ...");
				System.out.println();
			}
			//
			//			int[] layers = new int[]{ size, 128, 128, size };
			int[] layers = new int[l+2];
			layers[0] = size ;
			for (int i = 0; i < l; i++) {
				layers[i+1] = h ;
			}
			layers[layers.length-1] = size ;
			//

			net = new MultiLayerPerceptron(layers, lr, new SigmoidalTransferFunction());
			if ( verbose ) {
				System.out.println("---");
				System.out.println("Load data ...");
				System.out.println("---");
			}
			probar.progressProperty().unbind();
			probar.setProgress(0);

			Task<Double> task = new Task<Double>() {
				@Override
				protected Double call() throws Exception {
					System.out.println("Task ...");
					
					int batch = 1000;
					//TRAINING ...
					for(int i = 0; i < epochs; i++){
						
						double error = 0.0;

						 double bestError1 = 1000;
						 for (int j = 0; j < epochs; j++) {
						 Coup c = mapTrain.get((int) (Math.random() * mapTrain.size()));
						 double e = net.backPropagate(c.in, c.out);
						 updateProgress(i, epochs);
						 if (bestError1 > e) {
						 bestError1 = e;
						 if (j != 0 && j % 10 == 0 && verbose) {
						 updateMessage(i+"/"+epochs+" = "+error);
						 }
						 }
						 error += e;
						 }
					}
					if ( verbose )
						System.out.println("Learning completed!");
					
					/****************************************************/
					 Platform.runLater(() -> {
						 Task<Void> playerTask = new Task<Void>() {
						 @Override
						 protected Void call() throws Exception {
						 try {
						 Thread.sleep(1000);

						 } catch (InterruptedException e) {

						 e.printStackTrace();

						 }
						 
						 
						 Platform.runLater(() -> {
						 try {
						 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameAI.fxml"));
				    	 Parent root = loader.load();
						 Stage stage = (Stage) Apprentissage.getScene().getWindow();
						 GameAiController gameAiController = loader.getController();
			             gameAiController.setPar(learningRate,si,hiddenLayers);
						 stage.setScene(new Scene(root));
			    	     stage.setTitle("GameAI");
			    	     stage.show();
						 } catch (IOException e) {
						 e.printStackTrace();
						 }
						 });

						 return null;

						 }

						 };

						 new Thread(playerTask).start();

						 });

					return -1.0 ;

				}
			};

			probar.progressProperty().bind(task.progressProperty());

			task.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					erreur.setText(arg2);

				}
			});

			Thread thread = new Thread(task);
			thread.start();
			System.out.println("Task complete ...");
			File modelsDirectory = new File("models");
			String fileName = "model_" + si + "_" + learningRate + "_" + hiddenLayers + ".srl";
			System.out.println("fichier cree");
			net.save(modelsDirectory.getPath() + File.separator + fileName);
			

		}
		catch (Exception e) {
			System.out.println("Test.learn()");
			e.printStackTrace();
			System.exit(-1);
		}

		return net ;
	}
	
    @FXML
	public void apprends() throws IOException {
		double epochs = 1000 ;
		HashMap<Integer, Coup> mapTrain = loadCoupsFromFile("train.txt");
		learne(9,mapTrain,si,learningRate,hiddenLayers,true,epochs);
	}

}

