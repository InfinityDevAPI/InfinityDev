package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class VboxSubmissoesController {
	
	@FXML
	private AnchorPane vboxSubmissoes;
	
	@FXML
	private Button btnSubEntregas;
	
	@FXML
	private Button btnSubDevolutivas;
	
    @FXML
    private Button btnSubNotas;
	
    @FXML
    private BorderPane borderPane;
    
    public void setBorderPane(BorderPane borderPane) { 
        this.borderPane = borderPane;
    }


	@FXML
	public void painelSubEntregas(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/SubmissoesEntregas.fxml"));
    	borderPane.setCenter(view);
	}

	@FXML
	public void painelSubDevolutivas(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/SubmissoesDevolutivas.fxml"));
    	borderPane.setCenter(view);
	}
	
    @FXML
    public void painelSubNotas(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/SubmissoesNotas.fxml"));
    	borderPane.setCenter(view);
    }
	
}
