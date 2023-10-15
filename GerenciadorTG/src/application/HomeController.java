package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
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
    void abrirAgendamentos(MouseEvent event) {
        try {
            // Obtém a referência para a janela atual
            Stage currentStage = (Stage) botaoAgendamentos.getScene().getWindow();
            
            // Cria a nova janela de agendamentos
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/Agendamentos.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Agendamentos");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            
            // Define o modality para Modality.APPLICATION_MODAL, isso faz com que a nova janela seja modal
            stage.initModality(Modality.APPLICATION_MODAL);
            
            // Fecha a janela atual
            currentStage.close();
            
            // Mostra a nova janela de agendamentos
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    void abrirEntregas(MouseEvent event) throws IOException {
        try {
            Stage currentStage = (Stage) botaoEntregas.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/Entregas.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Entregas");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            
            currentStage.close();
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    void abrirRelatorios(MouseEvent event) throws IOException {
        try {
            Stage currentStage = (Stage) botaoRelatorios.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/Relatorios.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Relatorios");
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            
            currentStage.close();
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    void importarCSV(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "CSV importado com sucesso!!!", "Importado!", 1);
    }
}
