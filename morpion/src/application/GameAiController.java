
package application;



import ai.Coup;
import ai.MultiLayerPerceptron;
import ai.Test;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameAiController {
	
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
    private Button btn0;

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

    private String nom1,nom2;

    public  double learningRate;
    public  int size ;
    public  int  hiddenLayers;

    Coup coup;

    double[] tab = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

    MultiLayerPerceptron net;
    public void setPar(double learningR,int si,int hid){
        this.learningRate=learningR;
        this.size=si;
        this.hiddenLayers=hid;
        coup = new Coup(9, "test");
        net = MultiLayerPerceptron.load("/home/nas-wks01/users/uapv2200719/eclipse-workspace/exam/src/exam/hellotest/models/model_" + size + "_"
                + learningRate + "_" + hiddenLayers + ".srl");
    }
    int c=0;
    int scor=0;
    int s2=0;

    boolean p1=true;

    void IAPlay()   {
    	if(lab.getText()=="") {
    	coup.addInBoard(tab);
		double[] res = Test.play(net, coup);
		while (c % 2 != 0) {
			double max = 0;
			int indice = 0;
			for (int i = 0; i < 9; i++) {
				if ((res[i] > max) && (c < 8)) {
					max = res[i];
					indice = i;
				}
			}
			if (c == 9) {
				break;
			}
			if (tab[indice] != Coup.EMPTY) {
				max = 0;
				res[indice] = -1;
			} else {
                Button Btn = btn0;
                String BtnStr = "btn" + indice;
                
                if((btn0.getId()).equals(BtnStr))
                        Btn = btn0;
                else if ((btn1.getId()).equals(BtnStr))
                    Btn = btn1;
                else if ((btn2.getId()).equals(BtnStr))
                    Btn = btn2;
                else if ((btn3.getId()).equals(BtnStr))
                    Btn = btn3;
                else if ((btn4.getId()).equals(BtnStr))
                    Btn = btn4;
                else if ((btn5.getId()).equals(BtnStr))
                    Btn = btn5;
                else if ((btn6.getId()).equals(BtnStr))
                    Btn = btn6;
                else if ((btn7.getId()).equals(BtnStr))
                    Btn = btn7;
                else
                    Btn = btn8;
                
                tab[indice] = Coup.O;
                Btn.setText("O");
                Btn.setTextFill(Color.CYAN);
                c++;
                p1=true;
                System.out.println(p1);
                checkWinnerOrDraw();
            }
        }
		}

    }

    @FXML
    public void bouton1() {
    	if(!btn0.getText().equals("X") && !btn0.getText().equals("O")) {
        if(p1) {
            btn0.setText("X");
            btn0.setTextFill(Color.YELLOW); 
            c++;
            p1=false;
            checkWinnerOrDraw();
            tab[0] = Coup.X;
            IAPlay();
        }
      }
    }
    @FXML
    public void bouton2() {
    	if(!btn1.getText().equals("X")&& !btn1.getText().equals("O")) {
        if(p1) {
            btn1.setText("X");
            btn1.setTextFill(Color.YELLOW);
            c++;
            p1=false;
            checkWinnerOrDraw();
            tab[1] = Coup.X;
            IAPlay();
        }
        }

    }
    @FXML
    public void bouton3() {
    	if(!btn2.getText().equals("X")&& !btn2.getText().equals("O")) {
        if(p1) {
            btn2.setText("X");
            btn2.setTextFill(Color.YELLOW);
            c++;
            p1=false;
            checkWinnerOrDraw();
            tab[2] = Coup.X;
            IAPlay();
        }
        }
    }
    @FXML
    public void bouton4() {
    	if(!btn3.getText().equals("X")&& !btn3.getText().equals("O")) {
            if(p1) {
                btn3.setText("X");
                btn3.setTextFill(Color.YELLOW);
                c++;
                p1=false;
                checkWinnerOrDraw();
                tab[3] = Coup.X;
                IAPlay();
            }
         }
    }
    @FXML
    public void bouton5() {
    	if(!btn4.getText().equals("X")&& !btn4.getText().equals("O")) {
            if(p1) {
                btn4.setText("X");
                btn4.setTextFill(Color.YELLOW);
                c++;
                p1=false;
                checkWinnerOrDraw();
                tab[4] = Coup.X;
                IAPlay();
            }
         }
    }
    @FXML
    public void bouton6() {
    	if(!btn5.getText().equals("X")&& !btn5.getText().equals("O")) {
            if(p1) {
                btn5.setText("X");
                btn5.setTextFill(Color.YELLOW);
                c++;
                p1=false;
                checkWinnerOrDraw();
                tab[5] = Coup.X;
                IAPlay();
            }
         }
    }
    @FXML
    public void bouton7() {
    	if(!btn6.getText().equals("X")&& !btn6.getText().equals("O")) {
            if(p1) {
                btn6.setText("X");
                btn6.setTextFill(Color.YELLOW);
                c++;
                p1=false;
                checkWinnerOrDraw();
                tab[6] = Coup.X;
                IAPlay();
            }
         }
    }
    @FXML
    public void bouton8() {
    	if(!btn7.getText().equals("X")&& !btn7.getText().equals("O")) {
            if(p1) {
                btn7.setText("X");
                btn7.setTextFill(Color.YELLOW);
                c++;
                p1=false;
                checkWinnerOrDraw();
                tab[7] = Coup.X;
                IAPlay();
            }
         }
    }
    @FXML
    public void bouton9() {
    	if(!btn8.getText().equals("X")&& !btn8.getText().equals("O")) {
            if(p1) {
                btn8.setText("X");
                btn8.setTextFill(Color.YELLOW);
                c++;
                p1=false;
                checkWinnerOrDraw();
                tab[8] = Coup.X;
                IAPlay();
            }
         }
    }

    public void checkWinnerOrDraw() {

        checkline(btn0,btn1,btn2);
        checkline(btn3,btn4,btn5);
        checkline(btn6,btn7,btn8);

        checkline(btn0,btn3,btn6);
        checkline(btn1,btn4,btn7);
        checkline(btn2,btn5,btn8);

        checkline(btn0,btn4,btn8);
        checkline(btn2,btn4,btn6);

        if(c==9 && lab.getText()=="") {
            lab.setText("draw");
            lab.setVisible(true);
            DisableOrAbleAll(true);
        }
    }

    public void checkline(Button btn1,Button btn2,Button btn3) {
        if(btn1.getText().equals("X") && btn2.getText().equals("X") && btn3.getText().equals("X")) {
            lab.setText("Tu a gagné");
            lab.setVisible(true);
            DisableOrAbleAll(true);
            scor++;
            score1.setText(""+ scor);
            highlightWinner(btn1,btn2,btn3);
            playWinningSound();
            }
        if(btn1.getText().equals("O") && btn2.getText().equals("O") && btn3.getText().equals("O")) {
            lab.setText("Tu a perdu");
            lab.setVisible(true);
            DisableOrAbleAll(true);
            s2++;
            score2.setText(""+ s2);
            highlightWinner(btn1,btn2,btn3);
            playLosingSound();
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
        btn0.setDisable(n);
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
        btn0.setText("");
        lab.setText("");
    }

    @FXML
    public void replay(){
    	try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/level.fxml"));
	        Parent root = loader.load();
	        Stage stage = (Stage) retour.getScene().getWindow();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Morpion");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
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
	
	public void playLosingSound() {
        String path = "Lose.mp3"; 
		Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
	
	@FXML
    private void back() {
    	try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menubarv2.fxml"));
	        Parent root = loader.load();
	        Stage stage = (Stage) retour.getScene().getWindow();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Morpion");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }



}
