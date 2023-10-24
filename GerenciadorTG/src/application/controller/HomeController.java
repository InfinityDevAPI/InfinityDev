package application.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button botaoAgendamentos;

    @FXML
    private Button botaoEntregas;

    @FXML
    private Button botaoImportarCSV;

    @FXML
    private Button botaoRelatorios;

    @FXML
    void abrirAgendamentos(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoAgendamentos.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Agendamentos.fxml"));
        Scene agendamentos = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agendamentos");
        stage.setScene(agendamentos); 
        stage.setResizable(false);
        currentStage.close(); 
        stage.show();
    }

    @FXML
    void abrirEntregas(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoEntregas.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Entregas.fxml"));
        Scene entregas = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas");
        stage.setScene(entregas);  
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirRelatorios(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoRelatorios.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Relatorios.fxml"));
        Scene relatorios = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Relatórios");
        stage.setScene(relatorios);  
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void importarCSV(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "CSV importado com sucesso!!!", "Importado!", 1);
    }
}