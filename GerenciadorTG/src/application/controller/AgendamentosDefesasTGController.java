package application.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgendamentosDefesasTGController {

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoDefesasTG;

    @FXML
    private Button botaoEntregas;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoTG1;

    @FXML
    private Button botaoTG12;

    @FXML
    private Button botaoTG2;

    @FXML
    private TextField defesaAluno;

    @FXML
    private Button dropdownAluno;

    @FXML
    private Button dropdownCalendario;

    @FXML
    private Button dropdownTipoTG;

    @FXML
    private TextField nomeAluno;

    @FXML
    private TextField orientadorAluno;

    @FXML
    private TextField textAluno;

    @FXML
    private TextField textTipoTG;

    @FXML
    void abrirEntregas(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoDefesasTG.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/AgendamentosEntregas.fxml"));
        Scene agendamentosEntregas = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agendamentos: Entregas");
        stage.setScene(agendamentosEntregas);
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirHome(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoDefesasTG.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Home.fxml"));
        Scene home = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(home);
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void confirmarDefesaTG(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Defesa confirmada!!!", "Confirmado!", 1);
    }

}