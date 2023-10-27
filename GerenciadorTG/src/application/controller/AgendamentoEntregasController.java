package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AgendamentoEntregasController implements Initializable {

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoDefesasTG;

    @FXML
    private Button botaoEntregas;

    @FXML
    private Button botaoHome;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea descricaoEntrega;

    @FXML
    private DatePicker dropdownCalendario;

    @FXML
    private Button dropdownEntrega;

    @FXML
    private TextField numeroEntregas;

    @FXML
    void abrirDefesasTG(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoDefesasTG.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/AgendamentoDefesasTG.fxml"));
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
    void abrirHome(MouseEvent event) {
        try {

            Stage currentStage = (Stage) botaoHome.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Home.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("JavaFX", "Python", "FXML");
        comboBox.setItems(list);
    }
    
}