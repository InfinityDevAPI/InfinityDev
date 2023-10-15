package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AgendamentosController {

    @FXML
    private Button botaoDefesasTG;

    @FXML
    private Button botaoEntregas;

    @FXML
    private Button botaoHome;
    
    @FXML
    void abrirDefesasTG(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoDefesasTG.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/AgendamentoDefesasTG.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Agendamento de Defesa do TG");
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
    void abrirEntregas(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoEntregas.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/AgendamentoEntregas.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Agendamento de Entregas do TG");
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
    void abrirHome(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoHome.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/Home.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Gerenciador de Tg's");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            
            currentStage.close();
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
}
