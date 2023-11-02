package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class VboxAgendamentosController {
	
	@FXML
	private AnchorPane vboxEntregas;
	
	@FXML
	private Button btnEntregas;
	
	@FXML
	private Button btnDefesas; 
	
    @FXML
    private BorderPane borderPane; //variavel para armazenar o borderpanel do outro controller
    
    public void setBorderPane(BorderPane borderPane) { //método para configurar o BorderPane
        this.borderPane = borderPane;
    }
	
	@FXML
	public void painelEntregas(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/AgendamentoEntregas.fxml"));
    	borderPane.setCenter(view);
	}

	@FXML
	public void painelDefesas(ActionEvent event) throws IOException {
	   	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/AgendamentoDefesas.fxml"));
	   	borderPane.setCenter(view);
	}
}
