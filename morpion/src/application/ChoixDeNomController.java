package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChoixDeNomController {
	
	@FXML
    private TextField nom1;
	
	@FXML
    private TextField nom2;
	
	@FXML
    private Button commence;
	
	@FXML
	public void com() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameHuman.fxml"));
        Parent root;
		try {
		root = loader.load();
		GameHumanController gameController = loader.getController();
        gameController.setNoms(nom1.getText(), nom2.getText()); 
        Stage stage = (Stage) commence.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("JeuHuman");
        stage.show();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
