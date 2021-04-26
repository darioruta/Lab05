package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polio.tdp.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AnagrammiModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtResCorretti;

    @FXML
    private TextArea txtresErrati;

    @FXML
    private Button doReset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	
    	txtResCorretti.clear();
       	txtresErrati.clear();
       	String input = txtParola.getText();
       	if(input.length() <= 1) {
       		txtResCorretti.setText("La parola inserita è troppo corta");
       	}
       	
      	
    	
    	Set<String> res = model.calcolaAnagrammi(input);
    	
    	for (String ss : res) {
    		if (model.isCorrect(ss)) {
    			txtResCorretti.appendText(ss+ "\n");
    		}
    		else {
    			txtresErrati.appendText(ss +"\n");
    		}
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	

    	txtResCorretti.clear();
    	txtresErrati.clear();
    	txtParola.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResCorretti != null : "fx:id=\"txtResCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtresErrati != null : "fx:id=\"txtresErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert doReset != null : "fx:id=\"doReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(AnagrammiModel model) {
		this.model=model;
		
	}
}
