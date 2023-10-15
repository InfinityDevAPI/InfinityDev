package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EntregasDevolutivaController {

    @FXML
    private TextArea DescriçãoEntrega;

    @FXML
    private TextArea Devolutiva;

    @FXML
    private Button botaoCadastrarEntrega;

    @FXML
    private Button botaoCadastrarNota;

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoDevolutiva;

    @FXML
    private Button botaoHome;

    @FXML
    private Button dropdownAluno;

    @FXML
    private Button dropdownAtividade;

    @FXML
    void abrirCadastrarEntrega(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoCadastrarEntrega.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/EntregasCadastrarEntrega.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Entregas");
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
    void abrirCadastrarNota(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoCadastrarNota.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ui/EntregasCadastrarEntrega.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Notas");
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
