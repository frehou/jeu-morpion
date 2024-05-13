package application;

import java.io.File;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameHumanController {
	
	@FXML
    private ImageView imgp1;
	
	@FXML
    private ImageView imgp2;
	
	@FXML
    private Button retour;
	
	@FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;
    
    @FXML
    private Label lab;
    
    @FXML
    private Label pnom;
    
    @FXML
    private Label dnom;

	@FXML
	private Label score1;

	@FXML
	private Label score2;
	
	@FXML
	private Label labX;
	
	@FXML
	private Label labO;
    
   private String nom1,nom2;
    
    
    public void setNoms(String n1,String n2) {
    	this.nom1= n1;
    	this.nom2= n2;
    	pnom.setText(nom1);
        dnom.setText(nom2);
        labX.setVisible(true);
        labO.setVisible(false);
    }
    
    
    int c=0;
	int s1=0;
	int s2=0;

	boolean p1=true;
    
    @FXML
    public void bouton1() {
    	if(!btn1.getText().equals("X")&& !btn1.getText().equals("O")) {
    	if(p1) {
    		btn1.setText("X");
    		btn1.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn1.setText("O");
    		btn1.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton2() {
    	if(!btn2.getText().equals("X")&& !btn2.getText().equals("O")) {
    	if(p1) {
    		btn2.setText("X");
    		btn2.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn2.setText("O");
    		btn2.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}

		checkWinnerOrDraw();
		}

    }
    @FXML
    public void bouton3() {
    	if(!btn3.getText().equals("X")&& !btn3.getText().equals("O")) {
    	if(p1) {
    		btn3.setText("X");
    		btn3.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn3.setText("O");
    		btn3.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton4() {
    	if(!btn4.getText().equals("X")&& !btn4.getText().equals("O")) {
    	if(p1) {
    		btn4.setText("X");
    		btn4.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn4.setText("O");
    		btn4.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}

		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton5() {
    	if(!btn5.getText().equals("X")&& !btn5.getText().equals("O")) {
    	if(p1 ) {
    		btn5.setText("X");
    		btn5.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn5.setText("O");
    		btn5.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton6() {
    	if(!btn6.getText().equals("X")&& !btn6.getText().equals("O")) {
    	if(p1) {
    		btn6.setText("X");
    		btn6.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn6.setText("O");
    		btn6.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton7() {
    	if(!btn7.getText().equals("X") && !btn7.getText().equals("O")) {
    	if(p1) {
    		btn7.setText("X");
    		btn7.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn7.setText("O");
    		btn7.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton8() {
    	if(!btn8.getText().equals("X")&& !btn8.getText().equals("O")) {
    	if(p1) {
    		btn8.setText("X");
    		btn8.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn8.setText("O");
    		btn8.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    @FXML
    public void bouton9() {
    	if(!btn9.getText().equals("X")&& !btn9.getText().equals("O")) {
    	if(p1) {
    		btn9.setText("X");
    		btn9.setTextFill(Color.YELLOW);
    		c++;
			p1=false;
			labX.setVisible(false);
	        labO.setVisible(true);
    	}else {
    		btn9.setText("O");
    		btn9.setTextFill(Color.CYAN);
    		c++;
			p1=true;
			labX.setVisible(true);
	        labO.setVisible(false);
    	}
		checkWinnerOrDraw();
		}
    }
    
    public void checkWinnerOrDraw() {

    	checkline(btn1,btn2,btn3);
    	checkline(btn4,btn5,btn6);
    	checkline(btn7,btn8,btn9);
    	
    	checkline(btn1,btn4,btn7);
    	checkline(btn2,btn5,btn8);
    	checkline(btn3,btn6,btn9);
    	
    	checkline(btn1,btn5,btn9);
    	checkline(btn3,btn5,btn7);

    	if(c==9 && lab.getText()=="") {
            lab.setText("Partie Null");
            lab.setVisible(true);
            DisableOrAbleAll(true);
        }
    }
    
    public void checkline(Button btn1,Button btn2,Button btn3) {
    	if(btn1.getText().equals("X") && btn2.getText().equals("X") && btn3.getText().equals("X")) {
    		lab.setText("victoire :"+pnom.getText());
			lab.setVisible(true);
			DisableOrAbleAll(true);
			s1++;
            score1.setText(""+s1);
            highlightWinner(btn1,btn2,btn3);
            playWinningSound();
    	}
    	if(btn1.getText().equals("O") && btn2.getText().equals("O") && btn3.getText().equals("O")) {
    		lab.setText("victoire :"+ dnom.getText());
			lab.setVisible(true);
			DisableOrAbleAll(true);
			s2++;
			score2.setText(""+ s2);
			highlightWinner(btn1,btn2,btn3);
			playWinningSound();
    	}
    }
	public void DisableOrAbleAll(boolean n) {
		btn1.setDisable(n);
		btn2.setDisable(n);
		btn3.setDisable(n);
		btn4.setDisable(n);
		btn5.setDisable(n);
		btn6.setDisable(n);
		btn7.setDisable(n);
		btn8.setDisable(n);
		btn9.setDisable(n);
	}
	public void cleanAllText() {
		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn5.setText("");
		btn6.setText("");
		btn7.setText("");
		btn8.setText("");
		btn9.setText("");
	}

	
	
	public void highlightWinner(Button btn1, Button btn2, Button btn3) {
        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.7), btn1);
        tt1.setByX(10);
        tt1.setCycleCount(2);
        tt1.setAutoReverse(true);

        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(0.7), btn2);
        tt2.setByX(10);
        tt2.setCycleCount(2);
        tt2.setAutoReverse(true);

        TranslateTransition tt3 = new TranslateTransition(Duration.seconds(0.7), btn3);
        tt3.setByX(10); 
        tt3.setCycleCount(2);
        tt3.setAutoReverse(true);

        tt1.play();
        tt2.play();
        tt3.play();
    }
	public void playWinningSound() {
        String path = "Sound.mp3"; 
		Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
	
	@FXML
	public void replay(){
		lab.setVisible(false);
		DisableOrAbleAll(false);
		cleanAllText();
		c=0;
	}
    
	
	@FXML
    private void back() {
    	try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menubarv2.fxml"));
	        Parent root = loader.load();

	        
	        Stage stage = (Stage) retour.getScene().getWindow();

	       
	        stage.setScene(new Scene(root));
	        stage.setTitle("Home");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }
}
